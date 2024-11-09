import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.socialmistry.smarticles.R
import com.socialmistry.smarticles.ui.theme.SMArticlesTheme

@Composable
fun BasicCardExample() {
    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp,
        ),
        shape = RoundedCornerShape(8.dp)
    ) {
        Text(
            text = "Hello, I’m a basic card! But let’s get fancy.",
            modifier = Modifier.padding(16.dp),
            style = MaterialTheme.typography.headlineSmall
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SMArticlesTheme {
        BasicCardExample()
    }
}


@Composable
fun StyledCard() {
    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFE0F7FA)
        )
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "I'm a stylish card now!",
                style = MaterialTheme.typography.headlineSmall,
                color = Color.DarkGray
            )
            Spacer(modifier = Modifier.height(8.dp))
            Image(
                painter = painterResource(id = R.drawable.my_cool_image),
                contentDescription = "Cool Image",
                modifier = Modifier
                    .height(150.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp)),
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun StyledCardPreview() {
    SMArticlesTheme {
        StyledCard()
    }
}

@Composable
fun ClickableCard(onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .clickable { onClick() },
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Tap me to learn something cool!",
                style = MaterialTheme.typography.headlineSmall
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Just kidding, it's all lorem ipsum here.",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ClickableCardPreview() {
    SMArticlesTheme {
        ClickableCard {}
    }
}

@Composable
fun AnimatedCard() {
    var isClicked by remember { mutableStateOf(false) }
    val scale by animateFloatAsState(if (isClicked) 1.05f else 1f, label = "scale")

    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .graphicsLayer(scaleX = scale, scaleY = scale)
            .clickable { isClicked = !isClicked },
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Watch me grow! 🪴",
                style = MaterialTheme.typography.headlineSmall
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Go on, tap again. You know you want to.",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AnimatedCardPreview() {
    SMArticlesTheme {
        AnimatedCard()
    }
}

@Composable
fun FancyCard() {
    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .border(2.dp, Color.Magenta, RoundedCornerShape(12.dp)),
        elevation = CardDefaults.cardElevation(defaultElevation = 16.dp),
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "✅ Check out my fancy border!",
                style = MaterialTheme.typography.headlineSmall
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Yes, I'm kind of a big deal.",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FancyCardPreview() {
    SMArticlesTheme {
        FancyCard()
    }
}