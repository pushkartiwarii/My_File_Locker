package com.api.myfilelocker.GoogleSignIn

import android.content.Context
import android.content.Intent
import android.content.IntentSender
import com.api.myfilelocker.SignInResult
import com.api.myfilelocker.UserData
import com.api.myfilelocker.ui.GoogleViewModel
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.android.gms.auth.api.identity.BeginSignInRequest.GoogleIdTokenRequestOptions
import com.google.android.gms.auth.api.identity.SignInClient
import com.google.firebase.Firebase
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.auth
import kotlinx.coroutines.tasks.await
import kotlin.coroutines.cancellation.CancellationException

class GoogleAuthUiClient(
    private val context: Context,
    private val oneTapClient: SignInClient,
    val viewModel: GoogleViewModel


) {
    private val auth = Firebase.auth

    suspend fun signIn(): IntentSender? {
        val result = try {

            oneTapClient.beginSignIn(
                buildSignLInRequest()
            ).await()
        } catch (e: Exception) {
            e.printStackTrace()
            if (e is CancellationException) throw e
            null
        }
        return result?.pendingIntent?.intentSender

    }

    private fun buildSignLInRequest(): BeginSignInRequest {
        return BeginSignInRequest.builder().setGoogleIdTokenRequestOptions(
            GoogleIdTokenRequestOptions.builder().setSupported(true)
                .setFilterByAuthorizedAccounts(false)
                .setServerClientId("713026632637-usalrjg6gf9u3432thogn7vhe1jaj514.apps.googleusercon")
                .build()
        ).setAutoSelectEnabled(true).build()

    }


    suspend fun signInWithIntent(intent: Intent): SignInResult {
        viewModel.resetState()
        val cred = oneTapClient.getSignInCredentialFromIntent(intent)
        val googleIdToken = cred.googleIdToken
        val googleCred = GoogleAuthProvider.getCredential(googleIdToken, null)
        return try {
            val user = auth.signInWithCredential(googleCred).await().user
            SignInResult(
                errorMessage = null,
                data = user?.run {
                    UserData(
                        email = email.toString(),
                        userId = uid,
                        username = displayName.toString(),
                        ppurl = photoUrl.toString().substring(0, photoUrl.toString().length-6)

                    )


                }
            )

        }catch (e:Exception){
            e.printStackTrace()
            if (e is CancellationException) throw e
            SignInResult(
                errorMessage = e.message,
                data = null
            )

        }
    }
}
