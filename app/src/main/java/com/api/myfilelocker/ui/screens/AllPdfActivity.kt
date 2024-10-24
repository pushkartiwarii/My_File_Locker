@file:Suppress("IMPLICIT_CAST_TO_ANY")

package com.api.myfilelocker.ui.screens

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


//@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun HomeScreen(navController: NavController) {
//    val context = LocalContext.current
//    val imageUrl by remember {
//        mutableStateOf("")
//    }
//    var imageUri by remember {
//        mutableStateOf<Uri?>(null)
//    }
//
//    val launcher = rememberLauncherForActivityResult(contract = ActivityResultContracts.GetContent() ){
//        imageUri = it
//    }
//
//    val selected = false
//    var isContentVisible by remember { mutableStateOf(false) }
//    val invertMatrix = ColorMatrix().apply {
//        postConcat(
//            ColorMatrix(
//                floatArrayOf(
//                    -1f,
//                    0f,
//                    0f,
//                    0f,
//                    255f,
//                    0f,
//                    -1f,
//                    0f,
//                    0f,
//                    255f,
//                    0f,
//                    0f,
//                    -1f,
//                    0f,
//                    255f,
//                    0f,
//                    0f,
//                    0f,
//                    1f,
//                    0f
//                )
//            )
//        )
//    }
//
//
//    var isaddFiles by remember {
//        mutableStateOf(false)
//    }
//    val checked by remember {
//        mutableStateOf(false)
//    }
//    val animatedBlurEffect by animateDpAsState(targetValue = if (checked) 50.dp else 0.dp)
//
//    var name by remember {
//        mutableStateOf("")
//    }
//    val addfilesViewModel : AddFilesViewModel = viewModel()
//    val isUploaded by addfilesViewModel.isPosted.observeAsState(false)
//    val isDeleted by addfilesViewModel.isDeleted.observeAsState(false)
//    val fileList by addfilesViewModel.fileList.observeAsState(null)
//
//    AddFilesViewModel().getGallery()
//
//    LaunchedEffect(isUploaded) {
//
//        if (isUploaded){
//
//            Toast.makeText(context, "Data Added", Toast.LENGTH_SHORT).show()
//
//            isContentVisible = true
//            isaddFiles=false
//            imageUri = null
//            name = ""
//
//
//        }
//
//
//    }
//    LaunchedEffect(isDeleted) {
//
//
//        if (isDeleted){
//            Toast.makeText(context, "Data Deleted", Toast.LENGTH_SHORT).show()
//            isContentVisible = false
//
//
//
//        }
//
//    }
//
//
//
//
//
//    Scaffold(
//
//        topBar = {
//            TopAppBar(title = {
//                Column(Modifier.fillMaxWidth(), Arrangement.Center, Alignment.CenterHorizontally) {
//
//                    Text(
//                        text = "My Files Locker",
//                        Modifier.blur(
//                            radius = animatedBlurEffect,
//                            edgeTreatment = BlurredEdgeTreatment.Unbounded
//                        )
//                    )
//
//                }
//            })
//        },
//        bottomBar = {
//            BottomAppBar {
//                Column(Modifier.fillMaxWidth(), Arrangement.Center, Alignment.CenterHorizontally) {
//                    IconButton(onClick = { isaddFiles = true }) {
//                        Icon(
//                            painter = painterResource(id = R.drawable.img_2),
//                            contentDescription = "Folders",
//
//                            Modifier
//                                .blur(
//                                    radius = animatedBlurEffect,
//                                    edgeTreatment = BlurredEdgeTreatment.Unbounded
//                                )
//                                .size(24.dp)
//                                .align(Alignment.CenterHorizontally)
//                        )
//
//                    }
//
//                }
//            }
//
//
//        }
//
//
//    ) { paddingValues ->
//        if (!isContentVisible) {
//            Column(
//                modifier = Modifier.fillMaxSize(),
//                verticalArrangement = Arrangement.Center,
//                horizontalAlignment = Alignment.CenterHorizontally,
//
//                )
//            {
//                Image(
//                    painter = painterResource(id = R.drawable.img_4),
//                    contentDescription = "add file",
//                    Modifier
//                        .size(120.dp), colorFilter = ColorFilter.tint(Color.Gray)
//                )
//                Text(
//                    modifier = Modifier
//                        .blur(
//                            radius = animatedBlurEffect,
//                            edgeTreatment = BlurredEdgeTreatment.Unbounded
//                        )
//                        .padding(vertical = 20.dp),
//                    text = "No Files Added Yet",
//                    style = TextStyle(
//                        fontSize = 17.sp,
//                        fontWeight = FontWeight.Normal,
//                        color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.6f)
//                    )
//                )
//
//
//            }
//        } else {
//            null
//        }
//
//        if (isaddFiles)
//            Box(Modifier.fillMaxSize(), Alignment.Center) {
//
//
//                Column(
//                    modifier = Modifier
//                        .padding(16.dp)
//                        .fillMaxWidth()
//                        .shadow(16.dp)
//                        .clip(
//                            RoundedCornerShape(16.dp)
//                        )
//
//                        .padding(16.dp)
//                        .verticalScroll(rememberScrollState()),
//                    horizontalAlignment = Alignment.CenterHorizontally
//                ) {
//                    ElevatedCard(modifier = Modifier.padding(8.dp)) {
//                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
//                            Spacer(modifier = Modifier.height(5.dp))
//                            Text(text = "Enter File Name")
//                            Spacer(modifier = Modifier.height(7.dp))
//
//
//                            OutlinedTextField(value = name, onValueChange = {
//                                name = it
//                            },
//                                placeholder = { Text(text = "Name...") },
//                                modifier = Modifier
//                                    .fillMaxWidth()
//                                    .padding(4.dp)
//                            )
//                            Spacer(modifier = Modifier.height(5.dp))
//                            Image(painter = (if (imageUri == null) painterResource(id = R.drawable.img_4)
//                            else rememberAsyncImagePainter(model = imageUri)) as Painter,
//                                contentDescription = "banner_image",
//                                modifier = Modifier
//                                    .fillMaxWidth()
//                                    .clickable {
//                                        launcher.launch("image/*")
//
//                                    }
//                                    .height(200.dp),
//                                contentScale = ContentScale.Crop
//                            )
//                            Spacer(modifier = Modifier.height(7.dp))
//
//
//                            Row {
//                                Button(
//                                    onClick = {
//                                        if (isaddFiles == name.isEmpty()) {
//                                            Toast.makeText(
//                                                context,
//                                                "Please provide name for the file",
//                                                Toast.LENGTH_SHORT
//                                            ).show()
//                                        } else if (imageUri == null) {
//                                            Toast.makeText(
//                                                context,
//                                                "Please all fields are required",
//                                                Toast.LENGTH_SHORT
//                                            ).show()
//                                        } else {
//                                            addfilesViewModel.saveImage(imageUri!!, name)
//                                        }
//
//                                    },
//                                    modifier = Modifier
//                                        .fillMaxWidth()
//                                        .weight(1f)
//                                        .padding(4.dp)
//                                ) {
//                                    Text(text = "Add file")
//                                }
//                                OutlinedButton(
//                                    onClick = {
//                                        imageUri = null
//                                        isaddFiles = false
//                                        isContentVisible = false
//                                    },
//                                    modifier = Modifier
//                                        .fillMaxWidth()
//                                        .padding(4.dp)
//                                        .weight(1f), colors = ButtonDefaults.buttonColors(Color.Red)
//                                ) {
//                                    Text(text = "Cancel")
//                                }
//                            }
//                        }
//
//                    }
//                }
//                LazyColumn {
//                    items(fileList ?: emptyList()) {
//                        FileItemView(it, delete = { docId ->
//                            addfilesViewModel.deleteGallery(fileModel = it)
//                        }
//                        , deleteImage = { name, image ->
//                            addfilesViewModel.deleteImage(name, image)})
//
//
//                    }
//
//                }
//            }
//    }
//}






@ExperimentalMaterial3Api
@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = NavScreens.REQUESTPERMISSIONSCREEN.name
    ) {
        composable(NavScreens.REQUESTPERMISSIONSCREEN.name) {
            RequestPermissionScreen(navController)
        }
        composable(NavScreens.HOMESCREEN.name) {
            NewFile(navController)
        }
        composable(Routes.FileDetailScreen.route){
            val data = it.arguments!!.getString("catName")
            FileDetailScreen(navController,data!!)
    }
}
}


