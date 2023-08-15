import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.freakslist.ui.theme.AgileBlue
import com.example.freakslist.ui.theme.AgileGray

@Composable
fun FreakItem(name: String, imageResource: Int) {

    Row(modifier = Modifier.padding(
        horizontal = 16.dp,
        vertical = 24.dp)
    ) {
        Image(
            painter = painterResource(imageResource),
            modifier = Modifier
                .size(56.dp)
                .border(
                    width = 2.dp,
                    color = AgileBlue,
                    shape = CircleShape
                ),
            contentDescription = null
        )

        Spacer(modifier = Modifier.width(24.dp))

        Text(
            text = name,
            style = TextStyle(
                color = AgileGray,
                fontSize = 16.sp,
                // fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.W600,
                //  fontStyle = FontStyle.normal,
                // lineHeightStyle = 24.dp
            )
        )
    }
}