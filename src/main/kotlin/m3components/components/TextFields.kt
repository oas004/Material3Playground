package components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.dp

@Composable
fun M3TextFields() {
    Column {
        Spacer(Modifier.size(16.dp))

        M3OnSurfaceText(
            text = "Text Fields",
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(Modifier.size(16.dp))

        Row {
            val text = remember {
                mutableStateOf("")
            }

            OutlinedTextField(
                value = text.value,
                onValueChange = {
                    text.value = it
                },
                placeholder = {
                    Text("Please type a text")
                }
            )

            Spacer(Modifier.size(16.dp))

            Column {
                val text = remember {
                    mutableStateOf("")
                }

                OutlinedTextField(
                    value = text.value,
                    onValueChange = {
                        text.value = it
                    },
                    placeholder = {
                        Text("Please type a text")
                    },
                    isError = true,
                )
                TextFieldErrorMessage(message = "Something went wrong")
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TextFieldErrorMessage(message: String) {
    // This will ensure that the error message will be aligned with the input text. Since we do
    // not have a built-in label supported for our text fields, using textFieldWithoutLabelPadding
    // is just fine here.
    val startPadding = TextFieldDefaults.textFieldWithoutLabelPadding()
        .calculateStartPadding(layoutDirection = LocalLayoutDirection.current)

    Text(
        modifier = Modifier
            .padding(
                top = 4.dp,
                start = startPadding
            ),
        text = message,
        style = MaterialTheme.typography.labelSmall,
        color = MaterialTheme.colorScheme.error,
    )
}