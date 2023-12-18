package com.example.pokemoncardapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.pokemoncardapp.ui.theme.PokemonCardAppTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokemonCardAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Screen()
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Screen(){
    // top bar from
    // https://developer.android.com/jetpack/compose/components/app-bars
    // https://blog.devgenius.io/android-development-addition-of-bottom-navigation-bar-with-kotlin-and-jetpack-compose-3c7ceb7e6b71

    val navController = rememberNavController()
    val bottomNavItems = listOf(NavigationItem.SearchCard, NavigationItem.AddCard)

    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.run {
                    topAppBarColors(
                                containerColor = MaterialTheme.colorScheme.primaryContainer,
                                titleContentColor = MaterialTheme.colorScheme.primary,
                            )
                },
                title = {
                    Text("Pokemon Card DB")
                }
            )
        },
        bottomBar = {
            NavigationBar(containerColor = MaterialTheme.colorScheme.primaryContainer) {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route

                bottomNavItems.forEach {
                    NavigationBarItem(
                        selected = currentRoute == it.route,
                        label = {
                            Text(
                                text = it.label,
                                fontSize = 16.sp,
                                color = if (currentRoute == it.route)
                                    MaterialTheme.colorScheme.primary
                                    else MaterialTheme.colorScheme.secondary
                            )
                        },
                        icon = {
                            Icon(
                                imageVector = it.icons,
                                contentDescription = null,
                                tint = if (currentRoute == it.route)
                                    MaterialTheme.colorScheme.primary
                                    else
                                        MaterialTheme.colorScheme.secondary
                            )
                        },
                        onClick = {
                            if (currentRoute != it.route) {
                                navController.graph?.startDestinationRoute?.let {
                                    navController.popBackStack(
                                        it, true
                                    )
                                }
                                navController.navigate(it.route){
                                    launchSingleTop = true
                                }
                            }
                        }
                    )
                }
            }
        }

    ) { innerPadding ->
        ScrollContent(innerPadding)
        NavigationController(navController = navController)
    }



}

@Composable
fun MainTextStyles(title: String){
    Spacer(modifier = Modifier.height(60.dp))
    Text(
        text = title,
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold
        )
}

@Composable
fun <PaddingValues> ScrollContent(innerPadding: PaddingValues) {

}

@Composable
fun SearchCard(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        MainTextStyles(title = "Search from your Collection")
    }

}

@Composable
fun AddCard(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        MainTextStyles(title = "Add a card to your collection")
    }

}

// adapted from
// https://blog.devgenius.io/android-development-addition-of-bottom-navigation-bar-with-kotlin-and-jetpack-compose-3c7ceb7e6b71
// https://stackoverflow.com/questions/76137730/how-do-i-fix-unresolved-reference-composable-and-interface-navhost-does-not
@Composable
fun NavigationController(navController: NavHostController) {
    NavHost(navController = navController, startDestination = NavigationItem.SearchCard.route){
        composable(NavigationItem.SearchCard.route){
            SearchCard()
        }
        composable(NavigationItem.AddCard.route){
            AddCard()
        }
    }
}

