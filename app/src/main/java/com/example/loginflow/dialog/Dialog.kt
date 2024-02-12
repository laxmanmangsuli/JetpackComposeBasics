package com.example.loginflow.dialog

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddAlert
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.AlertDialogDefaults.containerColor
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.loginflow.R

@Preview
@Composable
fun AlertDialogScreen() {
    var isDialog by remember {
        mutableStateOf(false)
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {
        Button(onClick = { isDialog = true }) {
            Text(text = "Click here")

        }

        if (isDialog) {
            AlertDialog(
                modifier = Modifier.fillMaxWidth(),

                icon = {
                    Icon(imageVector = Icons.Filled.AddAlert, contentDescription = "Icon")
                },
                title = {
                    Text(
                        modifier = Modifier,
                        text = "Alert dialog"
                    )
                },
                text = {
                    Text(text = "This is an alert dialog with button ")
                },
                iconContentColor = Color.LightGray,
                titleContentColor = Color.Gray,
                textContentColor = Color.Black,
                onDismissRequest = { isDialog = false },
                confirmButton = {
                    TextButton(onClick = { isDialog = false }) {
                        Text(text = "Confirm", color = Color.Blue)
                    }

                },
                dismissButton = {
                    TextButton(onClick = { isDialog = false }) {
                        Text(text = "Dismiss", color = Color.Cyan)
                    }
                }
            )
        }
//        Counter()
        DialogWithImage()

    }

}

@Composable
fun Counter() {
    var count by remember { mutableStateOf(0) }
    Button(onClick = { count++ }) {
        Text("Increment")
    }

    Text("Count: $count")
}

@Composable
fun DialogWithImage() {
    var isDialog by remember {
        mutableStateOf(false)
    }
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {
        Button(onClick = { isDialog = true }) {
            Text(text = "Click here for image dialog")

        }
        if (isDialog) {
            Dialog(onDismissRequest = { isDialog = false }) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(380.dp)
                        .padding(17.dp),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.logo_slider),
                            contentDescription = "",
                            contentScale = ContentScale.Fit,
                            modifier = Modifier.height(160.dp)
                        )
                        Text(
                            text = "This is a dialog with buttons and an image.",
                            modifier = Modifier.padding(16.dp),
                        )
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center,
                        ) {
                            TextButton(
                                onClick = { isDialog = false },
                                modifier = Modifier.padding(8.dp),
                            ) {
                                Text("Dismiss")
                            }
                            TextButton(
                                onClick = { isDialog = false },
                                modifier = Modifier.padding(8.dp),
                            ) {
                                Text("Confirm")
                            }

                        }


                    }
                }

            }
        }
    }
}


