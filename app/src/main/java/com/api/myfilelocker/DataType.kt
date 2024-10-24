package com.api.myfilelocker

data class SignInResult(
    val data: com.api.myfilelocker.UserData?,
    val errorMessage: String?
)

data class UserData(
    val userId: String,
    val username: String,
    val ppurl: String?,
    val email : String?
)
