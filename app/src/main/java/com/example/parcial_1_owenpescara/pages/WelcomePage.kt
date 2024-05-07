package com.example.parcial_1_owenpescara.pages

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.parcial_1_owenpescara.ui.theme.Parcial_1_OwenPescaraTheme

@Composable
fun WelcomePage(modifier: Modifier = Modifier){
    Text(
        text = "Welcome",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun WelcomePagePreview() {
    Parcial_1_OwenPescaraTheme {
        WelcomePage()
    }
}