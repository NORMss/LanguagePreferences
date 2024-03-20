package com.norm.mylanguagepreferences

import android.app.AppComponentFactory
import android.app.LocaleManager
import android.os.Build
import android.os.LocaleList
import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import androidx.appcompat.app.AppCompatDelegate
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.core.os.LocaleListCompat

@Composable
fun MainScreen() {
    val context = LocalContext.current

    LaunchedEffect(key1 = Unit) {
        launch(Dispatchers.Main) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
//                context.getSystemService(LocaleManager::class.java)
//                    .applicationLocales = LocaleList.forLanguageTags("ru")
            } else {
                AppCompatDelegate.setApplicationLocales(LocaleListCompat.forLanguageTags("ru"))
            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                val currentAppLocales = context.getSystemService(LocaleManager::class.java)
                    .applicationLocales
                Log.d("Locale A13", "$currentAppLocales")
            } else {
                val currentAppLocales = AppCompatDelegate.getApplicationLocales()
                Log.d("Locale A12", "$currentAppLocales")
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            modifier = Modifier.clickable {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                    context.getSystemService(LocaleManager::class.java)
                        .applicationLocales = LocaleList.forLanguageTags("ru")
                }
            },
            text = stringResource(id = R.string.text),
            fontSize = MaterialTheme.typography.displaySmall.fontSize,
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Click on the text to set the Russian language",
            style = MaterialTheme.typography.titleSmall,
        )
    }
}