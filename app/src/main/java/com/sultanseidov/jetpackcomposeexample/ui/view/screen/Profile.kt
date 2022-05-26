package com.sultanseidov.jetpackcomposeexample.ui.view


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.sultanseidov.jetpackcomposeexample.ui.theme.*
import com.sultanseidov.jetpackcomposeexample.ui.view.screen.CommonUiComponents

@Composable
fun ProfileScreen() {

    val commonUi = CommonUiComponents()
    Box(
        modifier = Modifier
            .background(DeepBlue)
            .fillMaxSize()
    ) {
        Column {
            commonUi.AlertDialogSample()
            commonUi.ExtendedFloatingActionButtonDemo()

        }
    }
}

@Composable
@Preview
fun ProfileScreenPreview() {
    ProfileScreen()

}