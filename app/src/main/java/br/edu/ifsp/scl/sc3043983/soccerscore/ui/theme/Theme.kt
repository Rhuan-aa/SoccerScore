import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import br.edu.ifsp.scl.sc3043983.soccerscore.ui.theme.DarkBackground
import br.edu.ifsp.scl.sc3043983.soccerscore.ui.theme.GreenPrimary
import br.edu.ifsp.scl.sc3043983.soccerscore.ui.theme.GreenSecondary
import br.edu.ifsp.scl.sc3043983.soccerscore.ui.theme.LightBackground
import br.edu.ifsp.scl.sc3043983.soccerscore.ui.theme.TextOnPrimary
import br.edu.ifsp.scl.sc3043983.soccerscore.ui.theme.TextPrimary
import br.edu.ifsp.scl.sc3043983.soccerscore.ui.theme.Typography

private val LightColorScheme = lightColorScheme(
    primary = GreenPrimary,
    secondary = GreenSecondary,
    background = LightBackground,
    onPrimary = TextOnPrimary,
    onBackground = TextPrimary
)

private val DarkColorScheme = darkColorScheme(
    primary = GreenSecondary,
    background = DarkBackground,
)

@Composable
fun SoccerScoreTheme(
    darkTheme: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography, 
        content = content
    )
}