# Material3Playground

Compose for Desktop app for exploring Material 3 color schemes and components.

## Commands

```bash
./gradlew run          # Run the app
./gradlew test         # Run tests
./gradlew packageDmg   # Build macOS DMG
./gradlew packageDeb   # Build Linux Deb
```

## Architecture

- Single-window Compose Desktop app
- State hoisting: color schemes managed in `Main.kt`, passed down
- Page-based navigation via `Page` enum in `ComponentScope.kt`
- Components live in `src/main/kotlin/m3components/components/`
- Tests use Compose UI Test v2 API (`androidx.compose.ui.test.junit4.v2.createComposeRule`)

## Adding a Component

1. Create `src/main/kotlin/m3components/components/YourComponent.kt`
2. Add `Page` enum entry in `ComponentScope.kt`
3. Add to `M3Components` composable's `when` block
4. Add test tag to `TestTags.kt`
5. Create `src/test/kotlin/m3components/components/YourComponentVisibilityTest.kt`

## Key Files

- `Main.kt` - Entry point, window, theme state
- `ComponentScope.kt` - Layout, navigation, `Page` enum
- `TestTags.kt` - Test tag constants
- `ColorPreferences.kt` - Color persistence (uses java.util.prefs)

## Notes

- Side-by-side mode: Cmd+Shift+S
- Colors persist across sessions via Preferences API
- Build targets: macOS (DMG), Linux (Deb, Rpm)
