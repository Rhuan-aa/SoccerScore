package br.edu.ifsp.scl.sc3043983.soccerscore.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.edu.ifsp.scl.sc3043983.soccerscore.navigation.Routes

@Composable
fun FinalResultScreen(
    navController: NavController,
    resultMessage: String
) {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Resultado Final",
            style = MaterialTheme.typography.titleLarge
        )

        Text(
            text = resultMessage,
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(vertical = 32.dp)
        )

        Button(
            onClick = {
                navController.navigate(Routes.SCREEN_1) {
                    popUpTo(Routes.SCREEN_1) { inclusive = true }
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Novo Jogo")
        }
    }
}