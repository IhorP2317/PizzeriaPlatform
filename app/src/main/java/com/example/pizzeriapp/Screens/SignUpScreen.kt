import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pizzerapp.Screens.MyOutlinedTextField
import com.example.pizzeriapp.R

@Composable
fun SignUpScreen(onClick : () -> Unit){
    val username = remember { mutableStateOf("") }
    val email = remember { mutableStateOf("") }
    val number = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val repeatPassword = remember { mutableStateOf("") }

    Box(modifier = Modifier
        .background(color = Color.Black)
        .fillMaxSize()){
        Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxSize()) {

            Spacer(modifier = Modifier.height(30.dp))
            Image(painter = painterResource(id = R.drawable.logo), contentDescription = "logo")


            Spacer(modifier = Modifier.height(30.dp))

            Text(text = "Реєстрація", fontSize = 20.sp, color = Color.White)
            Spacer(modifier = Modifier.height(20.dp))

            MyOutlinedTextField(value = username.value, onValueChange = { username.value = it }, label = "Username")
            Spacer(modifier = Modifier.height(20.dp))

            MyOutlinedTextField(value = email.value, onValueChange = { email.value = it }, label = "E-mail")
            Spacer(modifier = Modifier.height(20.dp))

            MyOutlinedTextField(value = number.value, onValueChange = { number.value = it }, label = "Number")
            Spacer(modifier = Modifier.height(20.dp))

            MyOutlinedTextField(value = password.value, onValueChange = { password.value = it }, label = "Password")
            Spacer(modifier = Modifier.height(20.dp))

            MyOutlinedTextField(value = repeatPassword.value, onValueChange = { repeatPassword.value = it }, label = "Repeat Password")
            Spacer(modifier = Modifier.height(40.dp))

            Button(onClick = { onClick() }, colors = ButtonDefaults.buttonColors(Color.Magenta)) {
                Text(text = "Sign In", modifier = Modifier.padding(20.dp))

            }
        }
    }
}