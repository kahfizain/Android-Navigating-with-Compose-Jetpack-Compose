package com.kaza.navigation.feature.user_input.data

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class UserInputViewModel : ViewModel() {

    var uiState = mutableStateOf(UserInputState())

    fun onEvent(events: UserDataUiEvents) {
        when (events) {
            is UserDataUiEvents.UserNameEntered -> {
                uiState.value = uiState.value.copy(
                    nameEntered = events.name
                )
            }

            is UserDataUiEvents.AnimalSelected -> {
                uiState.value = uiState.value.copy(
                    animalSelected = events.animalValue
                )
            }
        }
    }
}

