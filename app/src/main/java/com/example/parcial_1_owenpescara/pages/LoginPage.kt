package com.example.parcial_1_owenpescara.pages


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.parcial_1_owenpescara.User
import com.example.parcial_1_owenpescara.ui.theme.Parcial_1_OwenPescaraTheme

@Composable
fun LoginPage(modifier: Modifier = Modifier) {

    val navHostController = rememberNavController()

    Scaffold(
        modifier = modifier,
        topBar = { MainTopAppBar(modifier) },
        floatingActionButton = {
            // TODO: ...
        }
    ) {
        MainNavHost(
            modifier = modifier.padding(it),
            navHostController = navHostController
        )
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainTopAppBar(modifier: Modifier) {
    CenterAlignedTopAppBar(
        title = {
                Text(
                    text = "1º Parcial MobileApps",
                    style = MaterialTheme.typography.titleLarge
                )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary
        )
    )
}

@Composable
fun Login(modifier: Modifier, navHostController: NavHostController){

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val user: User = User()

    Column (
        modifier = Modifier,
        verticalArrangement = Arrangement.SpaceAround
    ){
        Spacer(modifier = modifier)

        Text(
            text = "Ingrese sus datos",
            modifier = modifier
                .align(Alignment.CenterHorizontally),
            style = MaterialTheme.typography.titleLarge
        )

        TextField(
            label = {
                Text(
                    text = "E-mail:",
                    style = MaterialTheme.typography.titleMedium
                )
            },
            maxLines = 1,
            modifier = modifier.align(Alignment.CenterHorizontally),
            value = email,
            onValueChange = {
                email = it
            }
        )

        TextField(
            label = {
                Text(
                    text = "Password:",
                    style = MaterialTheme.typography.titleMedium
                )
            },
            maxLines = 1,
            modifier = modifier.align(Alignment.CenterHorizontally),
            value = password,
            onValueChange = {
                password = it
            }
        )

        Spacer(modifier = modifier)

        Row (modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ){
            Button(onClick = {
                if (email == user.email && password == user.pass){
                    navHostController.navigate("welcome")
                }

            },
                modifier
                    .height(100.dp)
                    .aspectRatio(1.0f),
                colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.secondary)
            ) {
                Text(text = "Log in")
            }
        }
    }
}

@Composable
fun MainNavHost(
    modifier: Modifier,
    navHostController: NavHostController
) {
    NavHost(
        navController = navHostController,
        startDestination = "login"
    ) {
        composable("login"){
            Login(
                modifier = modifier,
                navHostController = navHostController
            )
        }
        composable("welcome"){
            WelcomePage()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginPagePreview() {
    Parcial_1_OwenPescaraTheme {
        LoginPage()
    }
}