package com.example.pizzerapp.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.pizzerapp.Navigation.ScreensEnum
import com.example.pizzeriapp.AppViewModelProvider
import com.example.pizzeriapp.Database.GoodItem
import com.example.pizzeriapp.R
import com.example.pizzeriapp.ViewModel.DBViewModel
import java.time.LocalDate

@Composable
fun ShoppingCartScreen(navController: NavController, viewModel: DBViewModel = androidx.lifecycle.viewmodel.compose.viewModel(factory = AppViewModelProvider.Factory)) {
    Box(
        modifier = Modifier
            .background(color = Color.Black)
            .fillMaxSize()
    ) {
        Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {


            Text(
                text = "Кошик", fontSize = 15.sp,
                color = Color.White, modifier = Modifier.padding(20.dp)
            )

            Divider(color = Color.White, thickness = 1.dp)
            val basketItems = viewModel.getAllSpendingItems().collectAsState(initial = listOf())
            if (basketItems.value.isEmpty()) {
                Dialog(onDismissRequest = {}) {

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp)
                            .padding(16.dp),
                        shape = RoundedCornerShape(16.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color.White,
                        )
                    ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.End
                            ) {

                                Icon(
                                    imageVector = Icons.Default.Clear,
                                    contentDescription = "close",

                                    modifier = Modifier
                                        .padding(top = 5.dp, end = 15.dp)
                                        .clickable {
                                            navController.navigate(ScreensEnum.MENU.name)
                                        },
                                )
                            }
                            Spacer(modifier = Modifier.weight(0.1f))

                            Text(text = "Тут пусто:(")
                            Spacer(modifier = Modifier.weight(0.3f))

                            Divider(color = Color.Black, thickness = 1.dp)
                            Spacer(modifier = Modifier.weight(0.3f))

                            Button(
                                onClick = { navController.navigate(ScreensEnum.MENU.name); },
                                colors = ButtonDefaults.buttonColors(Color.Magenta)
                            ) {
                                Text(
                                    text = "Головна сторінка",
                                    modifier = Modifier.padding(
                                        start = 10.dp,
                                        end = 10.dp,
                                        top = 5.dp,
                                        bottom = 5.dp
                                    )
                                )

                            }
                            Spacer(modifier = Modifier.weight(0.3f))

                        }
                    }
                }
            }
            else{

                LazyColumn(){

                    items(basketItems.value){
                            item ->
                        BasketCard(item = item)

                    }
                }

            }
        }
    }
}

@Composable
fun BasketCard(item : GoodItem){
    Card (shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.Magenta,

        ),
        modifier = Modifier.padding(10.dp)){

        Row {
            Image(painter = painterResource(id = item.image), contentDescription = "pepsi")
            Column(modifier = Modifier.fillMaxHeight()) {

                Text(text = item.title, modifier = Modifier.padding(10.dp))
                Spacer(modifier = Modifier.height(55.dp))
                Row {
                    Text(text = "-")
                    Text(text = "1")
                    Text(text = "+")
                }
            }
            Spacer(modifier = Modifier.weight(1f))
            Column(modifier = Modifier.fillMaxHeight().padding(start = 10.dp), horizontalAlignment = Alignment.CenterHorizontally){

                Icon(
                    imageVector = Icons.Default.Clear,
                    contentDescription = "close",

                    modifier = Modifier
                        .padding(top = 5.dp)
                        .clickable {
                        },
                )

                Spacer(modifier = Modifier.height(55.dp))

                Text(text = item.price.toString() + " ₴", modifier = Modifier.padding(vertical = 5.dp, horizontal = 10.dp))


            }
        }

    }
}