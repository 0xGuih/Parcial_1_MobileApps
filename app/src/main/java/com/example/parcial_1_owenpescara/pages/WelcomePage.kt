package com.example.parcial_1_owenpescara.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.example.parcial_1_owenpescara.ui.theme.Parcial_1_OwenPescaraTheme

@Composable
fun WelcomePage(
    modifier: Modifier = Modifier,
    userName: String
){
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Welcome",
            modifier = modifier,
            style = MaterialTheme.typography.titleLarge

        )

        Text(
            text = userName,
            modifier = modifier,
            style = MaterialTheme.typography.titleLarge
        )
    }

}

@Preview(showBackground = true)
@Composable
fun WelcomePagePreview() {
    Parcial_1_OwenPescaraTheme {
        WelcomePage(userName = "UserName")
    }
}