package br.edu.ifsp.scl.sc3043983.soccerscore

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.edu.ifsp.scl.sc3043983.soccerscore.navigation.Routes
import br.edu.ifsp.scl.sc3043983.soccerscore.ui.screens.ConfigScreen
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
                }
            }
        }
    }
}