import androidx.compose.foundation.layout.Column
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.freakslist.ui.theme.AgileBlue
import com.example.freakslist.ui.theme.AgileGray
import com.example.freakslist.ui.theme.Nunito

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
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(
                            imageVector = ImageVector.vectorResource(id = item.icon),
                            contentDescription = item.name
                        )
                        Text(
                            text = item.name,
                            textAlign = TextAlign.Center,
                            fontSize = 10.sp,
                            color = if (selected) AgileBlue else AgileGray,
                            fontFamily = Nunito,
                            fontWeight = if (selected) FontWeight.SemiBold else FontWeight.Normal
                        )
                    }

                })
        }
    }
}