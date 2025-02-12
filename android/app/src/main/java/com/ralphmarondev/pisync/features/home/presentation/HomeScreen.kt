package com.ralphmarondev.pisync.features.home.presentation

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.DarkMode
import androidx.compose.material.icons.outlined.LightMode
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ralphmarondev.pisync.features.home.presentation.components.DoorCard
import com.ralphmarondev.pisync.features.home.presentation.components.GreetingsCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    darkTheme: Boolean,
    toggleDarkTheme: () -> Unit
) {
    var mainDoor by remember { mutableStateOf(false) }
    var doorOne by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Home",
                        fontFamily = FontFamily.Monospace
                    )
                },
                actions = {
                    IconButton(onClick = toggleDarkTheme) {
                        val icon =
                            if (darkTheme) Icons.Outlined.LightMode else Icons.Outlined.DarkMode
                        Icon(
                            imageVector = icon,
                            contentDescription = "Theme Icon"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                    actionIconContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            item {
                GreetingsCard(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                )
            }

            item {
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Registered doors",
                    fontFamily = FontFamily.Monospace,
                    fontSize = 18.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.W500,
                    color = MaterialTheme.colorScheme.secondary,
                    modifier = Modifier.padding(horizontal = 16.dp),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    DoorCard(
                        checked = mainDoor,
                        toggleChecked = { mainDoor = !mainDoor },
                        label = "Main",
                        modifier = Modifier
                            .weight(1f)
                            .padding(8.dp)
                    )
                    DoorCard(
                        checked = doorOne,
                        toggleChecked = { doorOne = !doorOne },
                        label = "Door 1",
                        modifier = Modifier
                            .weight(1f)
                            .padding(8.dp)
                    )
                }
            }
        }
    }
}