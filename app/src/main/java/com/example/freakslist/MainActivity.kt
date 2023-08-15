package com.example.freakslist

import BottomNavItem
import BottomNavigationBar
import FreakItem
import NavigationFreaks
import Routes
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material.TopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.freakslist.ui.theme.AgileGray
import com.example.freakslist.ui.theme.FreaksListTheme
import com.example.freakslist.ui.theme.Nunito

class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FreaksListTheme {
                // A surface container using the 'background' color from the theme
//scaffold is kind of a layout that has specific spots that and specific containers for predefined views, so tipical material design views
                //de ex pt buttom nav view, we can just pass it and scaffold already knows how to put it and where.
                //we have to get our current navController
                val navController = rememberNavController()
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(
                                    text = getString(R.string.top_bar_name), color = AgileGray, fontFamily = Nunito,
                                    fontWeight = FontWeight.SemiBold
                                )
                            },
                            backgroundColor = Color.White
                        )
                    },
                    bottomBar = {
                        BottomNavigationBar(
                            items = listOf(
                                BottomNavItem(
                                    name = Routes.HOME.title,
                                    route = Routes.HOME.route,
                                    icon = R.drawable.ic_home
                                ),
                                BottomNavItem(
                                    name = Routes.FREAKS.title,
                                    route = Routes.FREAKS.route,
                                    icon = R.drawable.ic_dashboard
                                ),
                                BottomNavItem(
                                    name = Routes.PROFILE.title,
                                    route = Routes.PROFILE.route,
                                    icon = R.drawable.ic_profile
                                )
                            ),
                            navController = navController,
                            onItemClick = {
                                //i tell where to navigate to
                                navController.navigate(it.route)
                            })
                    }) { paddingValues ->
                    //aici facem ref la nav composable care sa o imi inlocuiasca screen urile
                    NavigationFreaks(navController = navController, paddingValues)
                }

            }
        }
    }
}


@Preview
@Composable
fun FreakItemPreview() {
    Box(modifier = Modifier.background(Color.Yellow)) {
        FreakItem("Calin", R.drawable.calin)
    }
}