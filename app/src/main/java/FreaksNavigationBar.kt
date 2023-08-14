import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun FreaksNavigationBar() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "destination1") {
       // composable("destination1") { Destination1Screen(navController) }
     //   composable("destination2") { Destination2Screen(navController) }
    }
}