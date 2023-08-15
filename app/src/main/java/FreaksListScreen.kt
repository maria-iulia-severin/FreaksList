import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.freakslist.ui.theme.AgileGray

@Composable
fun FreaksListScreen() {
    Column(
        modifier = Modifier
            .padding(50.dp)
            .border(
                width = 1.dp, color = AgileGray, shape = RoundedCornerShape(10)
            )
    ) {
        freaks.forEachIndexed { index, freak ->
            FreakItem(name = freak.name, imageResource = freak.imageResource)
            //Spacer(modifier = Modifier.height(1.dp).width(50.dp).background(color = AgileBlue))
            if (index < freaks.size-1) {
                Divider(modifier = Modifier.padding(horizontal = 16.dp), color = AgileGray, thickness = 1.dp)
            }

        }
    }
}