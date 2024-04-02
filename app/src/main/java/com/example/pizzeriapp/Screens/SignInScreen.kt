package com.example.pizzerapp.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pizzeriapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignInScreen(onClick: () -> Unit) {

    val username = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }


    Box(modifier = Modifier
        .background(color = Color.Black)
        .fillMaxSize()){
        Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxSize()) {
            
            Spacer(modifier = Modifier.height(30.dp))
            Image(painter = painterResource(id = R.drawable.logo), contentDescription = "logo")
            
            
            Spacer(modifier = Modifier.height(30.dp))
            
            Text(text = "Реєстрація", fontSize = 20.sp, color = Color.White)
            Spacer(modifier = Modifier.height(30.dp))

            MyOutlinedTextField(value = username.value, onValueChange = { username.value = it }, label = "Username")
            Spacer(modifier = Modifier.height(30.dp))

            MyOutlinedTextField(value = password.value, onValueChange = { password.value = it }, label = "Password")

            Spacer(modifier = Modifier.height(150.dp))

            Button(onClick = { onClick() }, colors = ButtonDefaults.buttonColors(Color.Magenta)) {
                Text(text = "Sign In", modifier = Modifier.padding(20.dp))
                
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyOutlinedTextField(value: String, onValueChange: (String) -> Unit, label: String? = null) {
    val textState = remember { mutableStateOf(value) } // Remember the current text

    OutlinedTextField(
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Magenta,
            unfocusedBorderColor = Color.Magenta),
        value = textState.value,
        onValueChange = { textState.value = it },
        placeholder = { if (label != null) Text(label) else Text("") },
        modifier = Modifier
            .height(50.dp),
        textStyle = TextStyle(
            color = Color.White // Set your desired text color here
        )
    )
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun preview(){
    SignInScreen {}
}