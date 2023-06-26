package rs.ac.metropolitan.pzcs330.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import rs.ac.metropolitan.pzcs330.presentation.detail.BikeDetailScreen
import rs.ac.metropolitan.pzcs330.presentation.list.components.BikeListScreen
import rs.ac.metropolitan.pzcs330.presentation.theme.PZCS330Theme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PZCS330Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost (
                        navController = navController,
                        startDestination = Screen.BikeListScreen.route
                    ) {
                        composable(
                            route = Screen.BikeListScreen.route
                        ) {
                            BikeListScreen(navController)
                        }
                        composable (
                                route = Screen.BikeDetailScreen.route + "/{bikeId}"
                        ) {
                            BikeDetailScreen()
                        }
                    }

                }
            }
        }
    }
}

