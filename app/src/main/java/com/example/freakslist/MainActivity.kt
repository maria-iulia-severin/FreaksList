package com.example.freakslist

import BottomNavItem
import FreakItem
import FreaksList
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.TopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.freakslist.ui.theme.AgileBlue
import com.example.freakslist.ui.theme.AgileGray
import com.example.freakslist.ui.theme.FreaksListTheme

class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FreaksListTheme {
                // A surface container using the 'background' color from the theme
                //    Surface(
                //      modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                //      ) {
//scaffold is kind of a layout that has specific spots that and specific containers for predefined views, so tipical material design views
                //de ex pt buttom nav view, we can just pass it and scaffold already knows how to put it and where.
                //we have to get our current navController
                val navController = rememberNavController()
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = { Text(text = "Freaks List", color = AgileGray)},
                            backgroundColor = Color.White
                        )
                    },
                    bottomBar = {
                    BottomNavigationBar(
                        items = listOf(
                            BottomNavItem(
                                name = "Home", route = "home", icon = R.drawable.ic_home
                            ),
                            BottomNavItem(
                                name = "Freaks", route = "freaks", icon = R.drawable.ic_dashboard
                            ),
                            BottomNavItem(
                                name = "Profile", route = "profile", icon = R.drawable.ic_profile
                            )
                        ),
                        navController = navController,
                        onItemClick = {
                            //i tell where to navigate to
                            navController.navigate(it.route)
                        })
                }) { paddingValues ->
                    //aici facem ref la nav composable care sa o imi inlocuiasca screen urile
                    Navigation(navController = navController, paddingValues)
                }


                //FreaksList()
                //  }
            }
        }
    }
}

//asta face partea de navigatie, dar trebuie sa creez si componenta de buttomNav
@Composable
fun Navigation(navController: NavHostController, paddingValues: PaddingValues) {
// in the navigation composable we pass the NavHostController because we need that to set up the navHost composable
//creating navHost composable where we define different screens in between we want to be able to navigate
    NavHost(navController = navController, startDestination = "home", modifier = Modifier.padding(paddingValues)) {
        //ce avem intre curly breckets reprezinta screen ul nostru, iar ce avem intre ghilimele este ROUTE ul
        composable("home") { HomeScreen() }
        composable("freaks") { FreaksList() }
        composable("profile") { ProfileScreen() }
    }
}

//here we need to pass something so the ButtomNav knows what items should display, in our case
//avem doar cele 3 icons de jos intre care navigam
//creez o data clasa pentru ca am prea multe info: name, icon
//deci o sa pasez o lista buttomNavItem
//apoi avem nevoie de access catre navController deci facem referire si la el ca sa putem accessa route ul curent
//to check if there is an item that should show as selected or not
//ca sa facem asta cu selectul - avem nevoie doar sa sitm current route pe care il comparam cu route ul pe care il primim aici in ButtomNav
//pass modifier si apoi functia onClick care ne da access sa facem click, ca sa handle that outside of this
//buttom nav compsable
@Composable
fun BottomNavigationBar(
    items: List<BottomNavItem>,
    navController: NavController,
    modifier: Modifier = Modifier,
    onItemClick: (BottomNavItem) -> Unit
) {
// observe the current state and catch it into this val
    val backStackEntry = navController.currentBackStackEntryAsState()
    BottomNavigation(modifier = modifier, backgroundColor = Color.White, elevation = 5.dp) {
        //display specific item of our buttomNav view
        //we need one item for each ellement in our list
        items.forEach { item ->
// this will be updated when a route will actually change
            val selected = item.route == backStackEntry.value?.destination?.route
            BottomNavigationItem(selected = selected,
                onClick = { onItemClick(item) },
                selectedContentColor = AgileBlue,
                unselectedContentColor = AgileGray,
                //creez un column pt ca icon si text stau unul sub altul
                icon = {
                    Column(horizontalAlignment = CenterHorizontally) {
                        Icon(
                            imageVector = ImageVector.vectorResource(id = item.icon), contentDescription = item.name
                        )
                        Text(
                            text = item.name, textAlign = TextAlign.Center, fontSize = 10.sp, color = if(selected) AgileBlue else AgileGray
                        )
                    }

                })
        }
    }
}

@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
    ) {
        Text(text = "Home screen")
    }
}

@Composable
fun ProfileScreen() {
    Box(
        modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
    ) {
        Text(text = "Profile screen")
    }
}


@Preview
@Composable
fun FreakItemPreview() {
    Box(modifier = Modifier.background(Color.Yellow)) {
        FreakItem("Calin", R.drawable.calin)
    }
}