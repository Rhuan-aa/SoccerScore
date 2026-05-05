# SoccerScore ⚽

[![Repositório GitHub](https://img.shields.io/badge/GitHub-Repository-blue?style=for-the-badge&logo=github)](https://github.com/Rhuan-aa/SoccerScore.git)

## 📋 Sobre o Projeto

O **SoccerScore** é um aplicativo Android desenvolvido nativamente em Kotlin, projetado para atuar como um Simulador de Placar de Futebol. O foco deste projeto é consolidar os fundamentos da programação declarativa utilizando o **Jetpack Compose** para a construção da interface gráfica e o **Navigation Compose** para a gestão do fluxo e passagem de parâmetros entre telas.

A interface foi construída exclusivamente com componentes básicos de UI, priorizando organização, hierarquia visual e um gerenciamento de estado resiliente.

## 🚀 Estrutura e Funcionalidades

O aplicativo atende aos requisitos de negócio através de três telas distintas:

*   **Tela 1 - Configuração da Partida:** Coleta os dados iniciais do jogo (Nome do Time A, Nome do Time B, Gols do Time A e Gols do Time B).
    *   *Destaques Técnicos:* Implementa `rememberSaveable` para preservar o preenchimento do usuário durante eventos de recriação da Activity (ex: rotação de tela). Possui validação reativa para garantir que todos os campos sejam preenchidos e que os gols sejam valores numéricos inteiros maiores ou iguais a zero[cite: 1].
*   **Tela 2 - Resumo da Partida:** Extrai os parâmetros da rota e apresenta o placar processado de forma sumarizada.
    *   *Ações:* "Confirmar Resultado" (avança para a Tela 3 processando as regras de vitória) ou "Editar" (retorna para a Tela 1).
*   **Tela 3 - Resultado Final:** Exibe a conclusão da partida com base na regra de negócio ("Time A venceu!", "Time B venceu!" ou "Empate emocionante!").
    *   *Destaques Técnicos:* Utiliza controle estrito da pilha de navegação (`popUpTo` com `inclusive = true`) no botão "Novo Jogo" para garantir que o *backstack* seja limpo e o aplicativo reinicie seu fluxo corretamente.

## 🛠️ Tecnologias e Padrões Utilizados

*   **Linguagem:** Kotlin
*   **Ambiente de Desenvolvimento:** Android Studio
*   **Interface Gráfica:** Jetpack Compose (uso exclusivo de componentes básicos como Text, OutlinedTextField, Button, Card, Row e Column)
*   **Navegação:** Navigation Compose (rotas, passagem de parâmetros e conversão de tipos String para Int)
*   **Boas Práticas:** Código limpo e organizado em funções composables separadas, convenção de nomenclatura em `camelCase` e tratamento idiomático do `Null Safety` do Kotlin.
