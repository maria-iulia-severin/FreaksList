import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

//asta face partea de navigatie, dar trebuie sa creez si componenta de buttomNav
@Composable
fun NavigationFreaks(navController: NavHostController, paddingValues: PaddingValues) {
// in the navigation composable we pass the NavHostController because we need that to set up the navHost composable
//creating navHost composable where we define different screens in between we want to be able to navigate
    NavHost(navController = navController, startDestination = Routes.FREAKS.route, modifier = Modifier.padding(paddingValues)) {
        //ce avem intre curly breckets reprezinta screen ul nostru, iar ce avem intre ghilimele este ROUTE ul
        composable(Routes.HOME.route) { HomeScreen() }
        composable(Routes.FREAKS.route) { FreaksListScreen() }
        composable(Routes.PROFILE.route) { ProfileScreen() }
    }
}