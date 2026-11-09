#!/bin/bash
# Script to create a proper macOS icon with squircle shape
# Requires ImageMagick: brew install imagemagick
#
# Usage: ./scripts/create_macos_icon.sh [source_image.png]
#
# If no source image is provided, uses src/main/resources/icon.iconset/icon_512x512@2x.png
# The source image should be at least 1024x1024 pixels for best quality.
#
# The squircle shape follows Apple's macOS Big Sur icon guidelines:
# - Continuous corner radius (superellipse)
# - Approximately 22.37% corner radius ratio

set -e

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
PROJECT_ROOT="$(dirname "$SCRIPT_DIR")"
RESOURCES_DIR="$PROJECT_ROOT/src/main/resources"
ICONSET_DIR="$RESOURCES_DIR/icon.iconset"

# Check for ImageMagick
if ! command -v magick &> /dev/null; then
    echo "Error: ImageMagick is required but not installed."
    echo "Install with: brew install imagemagick"
    exit 1
fi

# Source image
SOURCE_IMAGE="${1:-$ICONSET_DIR/icon_512x512@2x.png}"

if [ ! -f "$SOURCE_IMAGE" ]; then
    echo "Error: Source image not found: $SOURCE_IMAGE"
    exit 1
fi

echo "Using source image: $SOURCE_IMAGE"

# Create temporary directory
TEMP_DIR=$(mktemp -d)
trap "rm -rf $TEMP_DIR" EXIT

# Create the squircle mask using a superellipse approximation
# macOS uses a continuous curvature corner with approximately 22.37% radius
create_squircle_mask() {
    local size=$1
    local output=$2
    local radius=$(echo "$size * 0.2237" | bc)

    # Create a rounded rectangle mask
    magick -size ${size}x${size} xc:none \
        -fill white \
        -draw "roundrectangle 0,0 $((size-1)),$((size-1)) $radius,$radius" \
        "$output"
}

# Apply squircle mask to an image
apply_squircle() {
    local input=$1
    local size=$2
    local output=$3

    local mask="$TEMP_DIR/mask_${size}.png"
    create_squircle_mask $size "$mask"

    magick "$input" -resize ${size}x${size} \
        "$mask" -alpha off -compose CopyOpacity -composite \
        "$output"
}

mkdir -p "$ICONSET_DIR"

# macOS icon sizes
echo "Creating icon sizes..."
apply_squircle "$SOURCE_IMAGE" 16 "$ICONSET_DIR/icon_16x16.png"
apply_squircle "$SOURCE_IMAGE" 32 "$ICONSET_DIR/icon_16x16@2x.png"
apply_squircle "$SOURCE_IMAGE" 32 "$ICONSET_DIR/icon_32x32.png"
apply_squircle "$SOURCE_IMAGE" 64 "$ICONSET_DIR/icon_32x32@2x.png"
apply_squircle "$SOURCE_IMAGE" 128 "$ICONSET_DIR/icon_128x128.png"
apply_squircle "$SOURCE_IMAGE" 256 "$ICONSET_DIR/icon_128x128@2x.png"
apply_squircle "$SOURCE_IMAGE" 256 "$ICONSET_DIR/icon_256x256.png"
apply_squircle "$SOURCE_IMAGE" 512 "$ICONSET_DIR/icon_256x256@2x.png"
apply_squircle "$SOURCE_IMAGE" 512 "$ICONSET_DIR/icon_512x512.png"
apply_squircle "$SOURCE_IMAGE" 1024 "$ICONSET_DIR/icon_512x512@2x.png"

echo "Converting to .icns..."
iconutil -c icns "$ICONSET_DIR" -o "$RESOURCES_DIR/icon.icns"

echo "Done! Icon created at: $RESOURCES_DIR/icon.icns"
echo ""
echo "Note: For the best results, provide a source image that is:"
echo "  - At least 1024x1024 pixels"
echo "  - Already has the squircle shape applied (or is designed to work with it)"
echo "  - Has appropriate padding from the edges"
