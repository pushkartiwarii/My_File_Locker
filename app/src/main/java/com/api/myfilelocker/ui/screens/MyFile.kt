package com.api.myfilelocker.ui.screens

import android.Manifest
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.api.myfilelocker.R


enum class NavScreens {
    REQUESTPERMISSIONSCREEN,
    HOMESCREEN
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun RequestPermissionScreen(navController: NavHostController) {

    val permissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission(),
        onResult = { isGranted ->
            if (!isGranted) {
                return@rememberLauncherForActivityResult
            } else {

                navController.navigate(NavScreens.HOMESCREEN.name)
            }

        }
    )

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,

        ) {
            Icon(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Icon",
                modifier = Modifier.size(40.dp)
            )
            Text(
                modifier = Modifier.padding(vertical = 20.dp),
                text = "You must grant permission to access device files",
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.6f)
                )
            )
            Button(
                modifier = Modifier
                    .height(50.dp)
                    .width(100.dp),
                onClick = {

                        permissionLauncher.launch(Manifest.permission.READ_EXTERNAL_STORAGE)
                    }
                ,
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.onBackground
                )
            ) {
                Text(
                    text = "Allow",
                    style = TextStyle(
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.background
                    )
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun RequestPermissionScreenPreview() {
    RequestPermissionScreen(
        navController = rememberNavController()
    )

}
