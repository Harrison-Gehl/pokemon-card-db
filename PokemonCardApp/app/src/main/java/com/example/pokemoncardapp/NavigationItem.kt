//Adapted from https://blog.devgenius.io/android-development-addition-of-bottom-navigation-bar-with-kotlin-and-jetpack-compose-3c7ceb7e6b71

package com.example.pokemoncardapp

import android.media.Image
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

sealed class NavigationItem(val route: String, val label: String, val icons: ImageVector) {
    object SearchCard : NavigationItem("search", "Search", Icons.Default.Search)
    object AddCard : NavigationItem("add", "Add", Icons.Default.Add)
}