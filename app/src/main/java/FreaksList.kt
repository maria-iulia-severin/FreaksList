import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import com.example.freakslist.ui.theme.AgileBlue

@Composable
fun FreaksList() {
    Column(
        modifier = Modifier.padding(100.dp).border(
            width = 1.dp, color = AgileBlue, shape = RectangleShape
        )
    ) {
        for (freaksList in freaks) {
            FreakItem(name = freaksList.name, imageResource = freaksList.imageResource)
            Spacer(modifier = Modifier.height(1.dp).fillMaxWidth().background(color = Color.Blue))
        }
    }
}