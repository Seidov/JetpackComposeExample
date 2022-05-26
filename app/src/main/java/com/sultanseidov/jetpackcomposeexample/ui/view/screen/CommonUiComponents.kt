package com.sultanseidov.jetpackcomposeexample.ui.view.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sultanseidov.jetpackcomposeexample.ui.theme.DeepBlue

class CommonUiComponents {

    @Composable
    fun AlertDialogSample() {
        MaterialTheme {
            Box(
                modifier = Modifier
                    .padding(start = 15.dp, top = 5.dp, bottom = 15.dp)

            ) {
                Column {
                    val openDialog = remember { mutableStateOf(false) }

                    Button(onClick = {
                        openDialog.value = true
                    }) {
                        Text("Click me")
                    }

                    if (openDialog.value) {

                        AlertDialog(
                            onDismissRequest = {
                                // Dismiss the dialog when the user clicks outside the dialog or on the back
                                // button. If you want to disable that functionality, simply use an empty
                                // onCloseRequest.
                                openDialog.value = false
                            },
                            title = {
                                Text(text = "Dialog Title")
                            },
                            text = {
                                Text("Here is a text ")
                            },
                            confirmButton = {
                                Button(

                                    onClick = {
                                        openDialog.value = false
                                    }) {
                                    Text("This is the Confirm Button")
                                }
                            },
                            dismissButton = {
                                Button(

                                    onClick = {
                                        openDialog.value = false
                                    }) {
                                    Text("This is the dismiss Button")
                                }
                            }
                        )
                    }
                }

            }
        }
    }

    @Composable
    fun ExtendedFloatingActionButtonDemo() {
        Box(
            modifier = Modifier
                .padding(start = 15.dp, top = 5.dp, bottom = 15.dp)

        ) {
            ExtendedFloatingActionButton(
                icon = { Icon(Icons.Filled.Favorite, "") },
                text = { Text("FloatingActionButton") },
                onClick = { /*do something*/ },
                elevation = FloatingActionButtonDefaults.elevation(8.dp)
            )
        }

    }
}