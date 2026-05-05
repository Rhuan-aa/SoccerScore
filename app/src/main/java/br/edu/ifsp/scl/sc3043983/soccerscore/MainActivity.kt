package br.edu.ifsp.scl.sc3043983.soccerscore

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.edu.ifsp.scl.sc3043983.soccerscore.navigation.Routes
import br.edu.ifsp.scl.sc3043983.soccerscore.ui.screens.ConfigScreen
import br.edu.ifsp.scl.sc3043983.soccerscore.ui.screens.SummaryScreen
import br.edu.ifsp.scl.sc3043983.soccerscore.ui.theme.SoccerScoreTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SoccerScoreTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = Routes.SCREEN_1) {
                    composable(Routes.SCREEN_1) {
                        ConfigScreen(navController)
                    }
                    composable(
                        route = "summary/{nameA}/{nameB}/{scoreA}/{scoreB}"
                    ) { backStackEntry ->
                        val nameA = backStackEntry.arguments?.getString("nameA") ?: ""
                        val nameB = backStackEntry.arguments?.getString("nameB") ?: ""
                        val scoreA = backStackEntry.arguments?.getString("scoreA")?.toIntOrNull() ?: 0
                        val scoreB = backStackEntry.arguments?.getString("scoreB")?.toIntOrNull() ?: 0

                        SummaryScreen(navController, nameA, nameB, scoreA, scoreB)
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, name = "Config Screen Preview")
@Composable
fun ConfigScreenPreview() {
    SoccerScoreTheme {
        ConfigScreen(navController = rememberNavController())
    }
}