package com.example.loginflow.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Lock
import androidx.compose.material.icons.rounded.PersonOutline
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loginflow.R

@Composable
fun NormalTextComponent(value: String) {
    Text(
        text = value, modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(align = Alignment.Bottom)
            .heightIn(min = 40.dp), style = TextStyle(
            fontSize = 24.sp, fontWeight = FontWeight.Normal, fontStyle = FontStyle.Normal
        ), color = colorResource(id = R.color.colorText), textAlign = TextAlign.Center,
        overflow = TextOverflow.Ellipsis

    )
}

@Composable
fun HeadingTextComponent(value: String) {
    Text(
        text = value, modifier = Modifier.fillMaxWidth(), style = TextStyle(
            fontSize = 30.sp, fontWeight = FontWeight.Bold, fontStyle = FontStyle.Normal
        ), color = colorResource(id = R.color.colorText), textAlign = TextAlign.Center

    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextField(labelValue: String) {
    val textValue = remember {
        mutableStateOf(value = "")
    }

    OutlinedTextField(modifier = Modifier
        .fillMaxWidth()
        .padding(0.dp),
        label = { Text(text = labelValue) },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = colorResource(id = R.color.colorPrimary),
            focusedLabelColor = colorResource(id = R.color.colorPrimary),
            cursorColor = colorResource(id = R.color.colorPrimary),

            ),
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
        singleLine = true,
        maxLines = 1,
        value = textValue.value,
        onValueChange = {
            textValue.value = it
        },
        leadingIcon = {
            when (labelValue) {
                "First Name", "Last Name" -> {
                    Icon(imageVector = Icons.Rounded.PersonOutline, contentDescription = "")
                }

                "Email" -> {
                    Icon(imageVector = Icons.Rounded.Email, contentDescription = "")
                }

                else -> {
                    Icon(imageVector = Icons.Rounded.Lock, contentDescription = "")
                }
            }
        })

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordTextField(labelValue: String) {

    val localFocusManager = LocalFocusManager.current
    val password = remember {
        mutableStateOf(value = "")
    }
    var isPasswordVisible by remember {
        mutableStateOf(false)
    }

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp),
        label = { Text(text = labelValue,
            overflow = TextOverflow.Ellipsis) },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = colorResource(id = R.color.colorPrimary),
            focusedLabelColor = colorResource(id = R.color.colorPrimary),
            cursorColor = colorResource(id = R.color.colorPrimary),

            ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password, imeAction = ImeAction.Done),
        singleLine = true,
        keyboardActions = KeyboardActions{
            localFocusManager.clearFocus()
        },
        maxLines = 1,
        value = password.value,
        onValueChange = {
            password.value = it
        },
        leadingIcon = {
            when (labelValue) {
                "First Name", "Last Name" -> {
                    Icon(imageVector = Icons.Rounded.PersonOutline, contentDescription = "")
                }

                "Email" -> {
                    Icon(imageVector = Icons.Rounded.Email, contentDescription = "")
                }

                else -> {
                    Icon(imageVector = Icons.Rounded.Lock, contentDescription = "")
                }
            }
        },
        trailingIcon = {

            val iconImage = if (isPasswordVisible) {
                Icons.Filled.Visibility
            } else {
                Icons.Filled.VisibilityOff
            }

            val description = if (isPasswordVisible) {
                stringResource(id = R.string.hide_password)
            } else {
                stringResource(id = R.string.show_password)
            }

            IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {

                Icon(imageVector = iconImage, contentDescription = description)

            }

        },

        visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation()

    )

}

@Composable
fun CheckBoxComponent(value: String, onTextSelected: (String) -> Unit) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(56.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        var isCheckedState by remember {
            mutableStateOf(false)
        }
        Checkbox(checked = isCheckedState, onCheckedChange = {
            isCheckedState = !isCheckedState
        })

        TextClickableTextComponent(value = value, onTextSelected)

    }

}

@Composable
fun TextClickableTextComponent(value: String, onTextSelected: (String) -> Unit) {
    val initialText = "By continuing you accept our "
    val privacyPolicyText = "privacy policy "
    val andText = " and"
    val termsAndConditionText = " terms of use"

    val annotatedString = buildAnnotatedString {
        append(initialText)
        withStyle(style = SpanStyle(color = colorResource(id = R.color.colorPrimary))) {
            pushStringAnnotation(tag = privacyPolicyText, annotation = privacyPolicyText)
            append(privacyPolicyText)
        }
        append(andText)
        withStyle(style = SpanStyle(color = colorResource(id = R.color.colorPrimary))) {
            pushStringAnnotation(tag = privacyPolicyText, annotation = termsAndConditionText)
            append(termsAndConditionText)
        }

    }

    ClickableText(text = annotatedString, onClick = {
        annotatedString.getStringAnnotations(it, it).firstOrNull()?.also { span ->
            Log.d("TAG", "TextClickableTextComponent:{${span.item}} ")
            if ((span.item == termsAndConditionText) || (span.item == privacyPolicyText)) {
                onTextSelected(span.item)
            }

        }
    })

}

@Composable
fun ButtonComponent(value: String) {
    Button(
        onClick = { /*TODO*/ },
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(48.dp),
        contentPadding = PaddingValues(),
        colors = ButtonDefaults.buttonColors(Color.Transparent)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(48.dp)
                .background(
                    brush = Brush.horizontalGradient(
                        listOf(
                            colorResource(id = R.color.colorSecondary),
                            colorResource(id = R.color.colorPrimary)
                        )
                    ),
                    shape = RoundedCornerShape(50.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = value,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )

        }

    }
}

@Composable
fun DividerTextComponent() {

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            color = colorResource(id = R.color.colorGray),
            thickness = 1.dp
        )
        Text(
            modifier = Modifier.padding(8.dp), text = stringResource(R.string.or),
            fontSize = 18.sp,
            color = colorResource(id = R.color.colorText)
        )
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            color = colorResource(id = R.color.colorGray),
            thickness = 1.dp
        )
    }

}

@Composable
fun ClickableLoginTextComponent(tryingToLogin: Boolean = true, onTextSelected: (String) -> Unit) {
    val initialText = if (tryingToLogin) "Already have an account? " else "Don't have an account yet? "
    val loginText = if (tryingToLogin) " Login" else "Register"

    val annotatedString = buildAnnotatedString {
        append(initialText)
        withStyle(style = SpanStyle(color = colorResource(id = R.color.colorPrimary))) {
            pushStringAnnotation(tag = loginText, annotation = loginText)
            append(loginText)
        }

    }

    ClickableText(modifier = Modifier
        .fillMaxWidth()
        .heightIn(min = 40.dp), style = TextStyle(
        fontSize = 18.sp, fontWeight = FontWeight.Normal, fontStyle = FontStyle.Normal,
        textAlign = TextAlign.Center
    ), text = annotatedString, onClick = {
        annotatedString.getStringAnnotations(it, it).firstOrNull()?.also { span ->
            Log.d("TAG", "TextClickableTextComponent:{${span.item}} ")
            if ((span.item == loginText)) {
                onTextSelected(span.item)
            }

        }
    })

}

@Composable
fun UnderLineTextComponent(value: String) {
    Text(
        text = value, modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 40.dp), style = TextStyle(
            fontSize = 16.sp, fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal
        ), color = colorResource(id = R.color.colorGray),
        textAlign = TextAlign.Center,
        textDecoration = TextDecoration.Underline

    )
}

val nameList= listOf(
    "1John", "Jane", "Michael","Mahi","Rohit","Virat","Lucky",  "John", "Jane", "Michael","Mahi","Rohit","Virat","Lucky",  "John", "Jane", "Michael","Mahi","Rohit","Virat","Lucky",  "John", "Jane", "Michael","Mahi","Rohit","Virat","Lucky",  "John", "Jane", "Michael","Mahi","Rohit","Virat","Lucky",  "John", "Jane", "Michael","Mahi","Rohit","Virat","Lucky",  "John", "Jane", "Michael","Mahi","Rohit","Virat","Lucky",
    "John", "Jane", "Michael","Mahi","Rohit","Virat","Lucky",  "John", "Jane", "Michael","Mahi","Rohit","Virat","Lucky",  "John", "Jane", "Michael","Mahi","Rohit","Virat","Lucky",  "John", "Jane", "Michael","Mahi","Rohit","Virat","Lucky",  "John", "Jane", "Michael","Mahi","Rohit","Virat","Lucky",  "John", "Jane", "Michael","Mahi","Rohit","Virat","Lucky",  "John", "Jane", "Michael","Mahi","Rohit","Virat","10Lucky",
)

@Composable
fun HorizontalItem(){
    LazyRow{
      items(nameList){
         RecyclerView(value = it)
      }
    }
}

@Composable
fun RecyclerView(value: String){
    Text(
            text = value,
        modifier = Modifier
            .padding(7.dp)
            .fillMaxWidth(),
        color = Color.LightGray,
        textAlign = TextAlign.Left,
        fontSize = 15.sp,
        fontWeight = FontWeight.SemiBold,
        )
}


@Composable
fun VerticalItem(){
    LazyColumn{
        items(nameList){
            RecyclerView(value = it)

            Spacer(modifier = Modifier
                .fillMaxHeight()
                .background(Color.Blue)
            )

        }
    }
}


