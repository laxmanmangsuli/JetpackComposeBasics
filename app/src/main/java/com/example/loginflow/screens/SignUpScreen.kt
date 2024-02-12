package com.example.loginflow.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.loginflow.R
import com.example.loginflow.components.ButtonComponent
import com.example.loginflow.components.CheckBoxComponent
import com.example.loginflow.components.DividerTextComponent
import com.example.loginflow.components.HeadingTextComponent
import com.example.loginflow.components.MyTextField
import com.example.loginflow.components.NormalTextComponent
import com.example.loginflow.components.PasswordTextField
import com.example.loginflow.components.ClickableLoginTextComponent
import com.example.loginflow.components.HorizontalItem
import com.example.loginflow.navigation.PostOfficeAppRouter
import com.example.loginflow.navigation.Screen

@Composable
fun  SignUpScreen() {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(28.dp)
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            NormalTextComponent(value = stringResource(id = R.string.hello))
            HeadingTextComponent(value = stringResource(id = R.string.create_account))
            Spacer(modifier = Modifier.height(20.dp))
            MyTextField(labelValue = stringResource(id = R.string.first_name))
            MyTextField(labelValue = stringResource(id = R.string.last_name))
            MyTextField(labelValue = stringResource(id = R.string.email))
            PasswordTextField(labelValue = stringResource(id = R.string.password))
            CheckBoxComponent(value = stringResource(id = R.string.terms_condition),
                onTextSelected ={
                    PostOfficeAppRouter.navigationTo(Screen.TermsAndConditionScreen)
                } )
            Spacer(modifier = Modifier.height(40.dp))
            ButtonComponent(value = stringResource(id = R.string.register) )
            DividerTextComponent()
            ClickableLoginTextComponent(tryingToLogin = true,onTextSelected = {
            PostOfficeAppRouter.navigationTo(Screen.LoginScreen)
            })
            HorizontalItem()
        }
    }
}

@Preview
@Composable
fun DefaultPreviewSignupScreen(){
    SignUpScreen()
}