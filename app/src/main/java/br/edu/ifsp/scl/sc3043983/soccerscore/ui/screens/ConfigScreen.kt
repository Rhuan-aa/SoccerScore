package br.edu.ifsp.scl.sc3043983.soccerscore.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun ConfigScreen(navController: NavController) {
    var teamAName by rememberSaveable { mutableStateOf("") }
    var teamBName by rememberSaveable { mutableStateOf("") }
    var scoreA by rememberSaveable { mutableStateOf("") }
    var scoreB by rememberSaveable { mutableStateOf("") }

    val isFormValid = teamAName.isNotBlank() &&
            teamBName.isNotBlank() &&
            (scoreA.toIntOrNull() ?: -1) >= 0 &&
            (scoreB.toIntOrNull() ?: -1) >= 0

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = "Configuração da Partida",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        OutlinedTextField(
            value = teamAName,
            onValueChange = { teamAName = it },
            label = { Text("Nome do Time A") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        OutlinedTextField(
            value = scoreA,
            onValueChange = { scoreA = it },
            label = { Text("Gols do Time A") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = teamBName,
            onValueChange = { teamBName = it },
            label = { Text("Nome do Time B") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        OutlinedTextField(
            value = scoreB,
            onValueChange = { scoreB = it },
            label = { Text("Gols do Time B") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            singleLine = true
        )

        Button(
            onClick = {
                navController.navigate("summary/$teamAName/$teamBName/$scoreA/$scoreB")
            },
            modifier = Modifier
                .padding(top = 24.dp)
                .fillMaxWidth(),
            enabled = isFormValid
        ) {
            Text("Ver Resultado")
        }
    }
}