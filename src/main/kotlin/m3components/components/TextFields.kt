package components

import TestTags
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.LazyGridScope
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
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp

fun LazyGridScope.m3TextFields() {

    item {

        val text = remember {
            mutableStateOf("")
        }

        OutlinedTextField(
            modifier = Modifier.padding(8.dp).testTag(TestTags.TextField.regular),
            value = text.value,
            onValueChange = {
                text.value = it
            },
            placeholder = {
                Text("Please type a text")
            }
        )
    }

    item {

        Column(
            modifier = Modifier.padding(8.dp),
        ) {
            val text = remember {
                mutableStateOf("")
            }

            OutlinedTextField(
                modifier = Modifier.testTag(TestTags.TextField.error),
                value = text.value,
                onValueChange = {
                    text.value = it
                },
                placeholder = {
                    Text("Please type a text")
                },
                isError = true,
            )
            TextFieldErrorMessage(
                modifier = Modifier.testTag(TestTags.TextField.errorLabel),
                message = "Something went wrong"
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TextFieldErrorMessage(modifier: Modifier = Modifier, message: String) {
    // This will ensure that the error message will be aligned with the input text. Since we do
    // not have a built-in label supported for our text fields, using textFieldWithoutLabelPadding
    // is just fine here.
    val startPadding = TextFieldDefaults.textFieldWithoutLabelPadding()
        .calculateStartPadding(layoutDirection = LocalLayoutDirection.current)

    Text(
        modifier = modifier
            .padding(
                top = 4.dp,
                start = startPadding
            ),
        text = message,
        style = MaterialTheme.typography.labelSmall,
        color = MaterialTheme.colorScheme.error,
    )
}