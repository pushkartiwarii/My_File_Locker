package com.api.myfilelocker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.ExperimentalMaterial3Api
import com.api.myfilelocker.ui.screens.AppNavigation
import com.api.myfilelocker.ui.theme.MyFileLockerTheme

@kotlin.OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyFileLockerTheme {
                AppNavigation()

            }
        }
    }
//
//    private lateinit var database: DatabaseReference
//    private lateinit var spinnerTasbeeh: Spinner
//    private lateinit var textViewTasbeehName: TextView
//    private lateinit var textViewCount: TextView
//    private lateinit var imageViewTasbeeh: ImageView
//    private var count = 0
//    private var currentTasbeeh = ""
//    private lateinit var binding: ActivityMainBinding
//    private var pdfFileUri: Uri? = null
//    private lateinit var storageReference: StorageReference
//    private lateinit var databaseReference: DatabaseReference

//    private val viewModel : GoogleViewModel  by viewModels()
//
//    private val googleAuthUiClient by lazy {
//        GoogleAuthUiClient (
//            context = applicationContext,
//            viewModel = viewModel,
//            oneTapClient = Identity.getSignInClient(applicationContext)
//        )
//    }




            }




//                    val nc = rememberNavController()
//
//                    val launcher = rememberLauncherForActivityResult(contract = ActivityResultContracts.StartIntentSenderForResult(),
//                        onResult ={
//                            result ->
//                            if(result.resultCode== RESULT_OK){
//                                lifecycleScope.launch {
//                                val signInResult = googleAuthUiClient.signInWithIntent(
//                                    intent = result.data ?: return@launch
//                                )}
//                                viewModel.resetState()
//                            }
//
//
//
//                        } )





//                    LoginScreen(getVideoUri(), state = AppState(), onLoginClicked = {
//                        lifecycleScope.launch {
//                            val signInIntentSender = googleAuthUiClient.signIn()
//                            launcher.launch(
//                                IntentSenderRequest.Builder(
//                                    signInIntentSender ?: return@launch
//                                ).build()
//                            )
//                        }
//                    })









//    private fun getVideoUri(): Uri {
//        val rawId = resources.getIdentifier("citynight", "raw", packageName)
//        val videoUri = "android.resource://$packageName/$rawId"
//        return Uri.parse(videoUri)
//    }




//
//private fun Context.doLogin() {
//    Toast.makeText(
//        this,
//        "Something went wrong, try again later!",
//        Toast.LENGTH_SHORT
//    ).show()
//}
//
//private fun Context.buildExoPlayer(uri: Uri) =
//    ExoPlayer.Builder(this).build().apply {
//        setMediaItem(MediaItem.fromUri(uri))
//        repeatMode = Player.REPEAT_MODE_ALL
//        playWhenReady = true
//        prepare()
//    }
//
//private fun Context.buildPlayerView(exoPlayer: ExoPlayer) =
//    StyledPlayerView(this).apply {
//        player = exoPlayer
//        layoutParams = FrameLayout.LayoutParams(MATCH_PARENT, MATCH_PARENT)
//        useController = false
//        resizeMode = RESIZE_MODE_ZOOM
//    }
//
//@SuppressLint("OpaqueUnitKey")
//@Composable
//fun LoginScreen (videoUri: Uri, onLoginClicked: ()->Unit ={},state:AppState ) {
//    val context = LocalContext.current
//    val passwordFocusRequester = FocusRequester()
//    val focusManager = LocalFocusManager.current
//    val exoPlayer = remember { context.buildExoPlayer(videoUri) }
//    DisposableEffect(
//        AndroidView(
//            factory = { it.buildPlayerView(exoPlayer) },
//            modifier = Modifier
//                .fillMaxSize()
//                .background(Color.Black)
//        )
//    ) {
//        onDispose {
//            exoPlayer.release()
//        }
//    }
//    ProvideWindowInsets {
//        if (state.loginStatus== LoginStatus.IN_PROGRESS){
//            CircularProgressIndicator()
//        }
//        else{
//
//        Column(
//            Modifier
//                .navigationBarsWithImePadding()
//                .padding(24.dp)
//                .fillMaxSize(),
//            verticalArrangement = Arrangement.spacedBy(16.dp, alignment = Alignment.CenterVertically),
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//            Icon(
//                painter = painterResource(id = R.drawable.bird),
//                null,
//                Modifier.size(100.dp),
//                tint = Color.Black
//            )
//
//
//            Button(onClick = {
//                onLoginClicked()
//
//            }, modifier = Modifier
//                .fillMaxWidth()
//                .height(60.dp)
//                .align(Alignment.End),
//                shape = RoundedCornerShape(100.dp),
//                colors = ButtonDefaults.buttonColors(Color.White),
//                elevation = ButtonDefaults.buttonElevation(5.dp)
//            ) {
//                Image(
//                    painter = painterResource(id = R.drawable.img_1),
//                    contentDescription = null, modifier = Modifier.size(30.dp))
//                Spacer(modifier = Modifier.width(12.dp))
//            Text("SIGN IN WITH GOOGLE", Modifier.padding(vertical = 8.dp),
//                fontSize = 20.sp,
//                fontWeight = FontWeight.ExtraBold, color = Color.Black)
//
//
//
//        }}
//        }
//}
//}
//
//enum class Screen(val route: String) {
//    Home("home"),
//    Login("login"),
//}


