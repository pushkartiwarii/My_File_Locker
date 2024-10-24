package com.api.myfilelocker.ui

import androidx.lifecycle.ViewModel
import com.api.myfilelocker.SignInResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
enum class LoginStatus {
    LOGGED_IN,
    IN_PROGRESS,
    LOGGED_OUT,
    FAILED,
}
data class AppState(
    val loginStatus: LoginStatus = LoginStatus.LOGGED_OUT,
    val errorMessage: String = "",

    val message: String = "",
    val sendingError: String = "",
    val loadingError: String = "",

)
class GoogleViewModel:ViewModel() {

    private val _appState = MutableStateFlow(AppState())

    fun resetState() {
        _appState.value = AppState()
    }




}