package com.example.loginflow.app

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.loginflow.dateandtimepicker.DateAndTimePickerScreen
import com.example.loginflow.dialog.AlertDialogScreen
import com.example.loginflow.scaffold_button.TopAppBarComponent
import com.example.loginflow.swapabletabrow.SwapRows

@Composable
fun PostOfficeApp(){
    Surface(modifier = Modifier
        .fillMaxSize(),
        color = Color.White
    ) {
        DateAndTimePickerScreen()
//        AlertDialogScreen()
//        TopAppBarComponent()
//        Crossfade(targetState = PostOfficeAppRouter.currentScreen, label = "") { currentState ->
//            when(currentState.value){
//                is Screen.SignUpScreen ->{
//                    SignUpScreen()
//                }
//                is Screen.TermsAndConditionScreen ->{
//                    TermsAndConditionScreen()
//                }
//
//                is Screen.LoginScreen ->{
//                  LoginScreen()
//                }
//            }
//
//        }
    }
}