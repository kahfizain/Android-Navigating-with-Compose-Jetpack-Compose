package com.kaza.navigation.feature.user_input

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.kaza.navigation.feature.user_input.data.UserDataUiEvents
import com.kaza.navigation.feature.user_input.data.UserInputViewModel
import com.kaza.navigation.ui.TextComponent
import com.kaza.navigation.ui.TextFieldComponent
import com.kaza.navigation.ui.TopBar

@Composable
fun UserInputScreen(userInputViewModel: UserInputViewModel) {
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
            TextFieldComponent(onTexChanged = {
                userInputViewModel.onEvent(
                    UserDataUiEvents.UserNameEntered(it)
                )
            })


        }
    }

}

@Preview
@Composable
fun UserInputScreenPreview() {
    UserInputScreen(UserInputViewModel())
}