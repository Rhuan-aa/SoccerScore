package br.edu.ifsp.scl.sc3043983.soccerscore.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun SummaryScreen(
    navController: NavController,
    nameA: String,
    nameB: String,
    scoreA: Int,
    scoreB: Int
) {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Resumo da Partida", style = MaterialTheme.typography.titleLarge)

        Text(
            text = "$nameA $scoreA x $scoreB $nameB",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(vertical = 24.dp)
        )

        Button(
            onClick = {
                val result = when {
                    scoreA > scoreB -> nameA
                    scoreB > scoreA -> nameB
                    else -> "Empate"
                }
                navController.navigate("final/$result")
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Confirmar Resultado")
        }

        OutlinedButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier.padding(top = 8.dp).fillMaxWidth()
        ) {
            Text("Editar")
        }
    }
}

