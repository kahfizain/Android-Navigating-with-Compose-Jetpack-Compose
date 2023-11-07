package com.kaza.navigation.feature.welcome

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.kaza.navigation.feature.user_input.data.UserDataUiEvents
import com.kaza.navigation.feature.user_input.data.UserInputViewModel
import com.kaza.navigation.ui.FactComposable
import com.kaza.navigation.ui.TextComponent
import com.kaza.navigation.ui.TextWithShadow
import com.kaza.navigation.ui.TopBar
import com.kaza.navigation.ui.screens.Routes

@Composable
fun WelcomeScreen(username : String?, animal :String?) {

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(18.dp)
        )
        {
            TopBar("Welcome $username \uD83D\uDE0A")

            TextComponent(texValue = "Thank You! for sharing yout data", textSize = 24.sp)

            Spacer(modifier = Modifier.size(60.dp))

            val finalText = if (animal == "Cat") {
                "You are a Cat lover \uD83D\uDE36 "
            } else {
                "You are a Rabbit lover \uD83D\uDE36"
            }
            TextWithShadow(value = finalText)

            FactComposable(value = "ABC")

        }
    }
}

@Preview
@Composable
fun WelcomeScreenPreview(){
    WelcomeScreen("Kahfi","Cat")
}