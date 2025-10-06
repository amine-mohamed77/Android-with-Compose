package com.example.compose.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.compose.R

@Composable
fun DireBonjourSection(modifier: Modifier = Modifier) {
    var firstname by remember { mutableStateOf("") }
    var greeting by remember { mutableStateOf("") }


    val labelFirstName = stringResource(id = R.string.label_firstname)
    val placeholderFirstName = stringResource(id = R.string.ph_firstname)
    val buttonText = stringResource(id = R.string.btn_greet)
    val greetingTemplate = stringResource(id = R.string.msg_greeting)

    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(text = labelFirstName)
        OutlinedTextField(
            value = firstname,
            onValueChange = { firstname = it },
            placeholder = { Text(placeholderFirstName) },
            modifier = Modifier.fillMaxWidth()
        )
        Button(
            onClick = {
                greeting = if (firstname.isNotBlank()) {
                    String.format(greetingTemplate, firstname)
                } else ""
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(buttonText)
        }

        if (greeting.isNotEmpty()) {
            Text(
                text = greeting,
                style = MaterialTheme.typography.headlineSmall
            )
        }
    }
}
