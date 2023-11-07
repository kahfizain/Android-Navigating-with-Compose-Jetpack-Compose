package com.kaza.navigation.feature.user_input

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kaza.navigation.R
import com.kaza.navigation.feature.user_input.data.UserDataUiEvents
import com.kaza.navigation.feature.user_input.data.UserInputViewModel
import com.kaza.navigation.feature.welcome.WelcomeScreen
import com.kaza.navigation.ui.AnimalCard
import com.kaza.navigation.ui.ButtonComponent
import com.kaza.navigation.ui.TextComponent
import com.kaza.navigation.ui.TextFieldComponent
import com.kaza.navigation.ui.TopBar
import com.kaza.navigation.ui.screens.FunFactsNavigationGraph

@Composable
fun UserInputScreen(
    userInputViewModel: UserInputViewModel,
    showWelcomeScreen: (valuePair: Pair<String, String>)-> Unit){
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(18.dp)
        )
        {
            TopBar("Hi there \uD83D\uDE0A")
            TextComponent(texValue = "Let's learn about You !", textSize = 24.sp)

            Spacer(modifier = Modifier.size(20.dp))

            TextComponent(
                texValue = "This app will prepare a details pag based on input provided by you !",
                textSize = 18.sp
            )

            Spacer(modifier = Modifier.size(60.dp))
            TextComponent(texValue = "Name", textSize = 18.sp)
            Spacer(modifier = Modifier.size(10.dp))
            TextFieldComponent(onTexChanged = {
                userInputViewModel.onEvent(
                    UserDataUiEvents.UserNameEntered(it)
                )
            })
            Spacer(modifier = Modifier.size(20.dp))
            TextComponent(
                texValue = "What do you like",
                textSize = 18.sp
            )
            Row(modifier = Modifier.fillMaxWidth()) {
                AnimalCard(image = R.drawable.ic_cat, animalSelected = {
                    userInputViewModel.onEvent(
                        UserDataUiEvents.AnimalSelected(it)
                    )
                }, selected = userInputViewModel.uiState.value.animalSelected == "Cat")

                AnimalCard(image = R.drawable.ic_rabbit, animalSelected = {
                    userInputViewModel.onEvent(
                        UserDataUiEvents.AnimalSelected(it)
                    )
                }, selected = userInputViewModel.uiState.value.animalSelected == "Rabbit")
            }

            Spacer(modifier = Modifier.weight(1f))

            if (userInputViewModel.isValidState()) {
                ButtonComponent(
                    goToDetailScreen = {
                        showWelcomeScreen(
                            Pair(
                                userInputViewModel.uiState.value.nameEntered,
                                userInputViewModel.uiState.value.animalSelected)
                        )
                    }
                )
            }

        }
    }

}

@Preview
@Composable
fun UserInputScreenPreview() {
    UserInputScreen(UserInputViewModel()) { /* Define your action here */ }
}