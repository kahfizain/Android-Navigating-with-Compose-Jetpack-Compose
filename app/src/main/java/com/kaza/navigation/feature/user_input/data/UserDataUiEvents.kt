package com.kaza.navigation.feature.user_input.data

sealed class UserDataUiEvents{
    data class UserNameEntered(val name:String): UserDataUiEvents()
    data class AnimalSelected(val animalValue:String):UserDataUiEvents()

}
