@file:Suppress("DEPRECATION")

package com.api.myfilelocker.ItemView


//@OptIn(ExperimentalMaterial3Api::class)
//    @Composable
//    fun FileItemView(
//        facultyModel: FacultyModel,
//        delete: (fileModel: FacultyModel) -> Unit,
//        deleteImage: (image: String, name: String) -> Unit
//    ) {
//
//
//
//            OutlinedCard(modifier = Modifier
//                .padding(4.dp)
//                .fillMaxWidth()) {
//                ConstraintLayout(modifier = Modifier.fillMaxWidth()) {
//                    val (catname, delete) = createRefs()
//
//
//                    Card(
//                        modifier = Modifier
//                            .constrainAs(delete) {
//                                top.linkTo(parent.top)
//                                end.linkTo(parent.end)
//                            }
//                            .padding(4.dp)
//                            .clickable {
//                                delete(fileModel)
//                            }
//                    ) {
//                        Image(imageVector = Icons.Default.Delete, contentDescription = null,
//                            modifier = Modifier.padding(8.dp))
//                    }
//
//                }
//                }
//
//                LazyRow {
//                    items(fileModel.images?.take(1) ?: emptyList()) { imageUrl ->
//                        val context = LocalContext.current
//                        val uri = Uri.parse(imageUrl.toString())
//
//                        Image(
//                            painter = painterResource(id = R.drawable.logo),
//                            contentDescription = null,
//                            modifier = Modifier
//                                .padding(4.dp)
//                                .clickable {
//                                    val intent = Intent(Intent.ACTION_VIEW)
//                                    intent.setDataAndType(uri, "image/*")
//                                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
//                                    intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
//
//                                    try {
//                                        context.startActivity(intent)
//                                    } catch (e: ActivityNotFoundException) {
//                                        Toast
//                                            .makeText(
//                                                context,
//                                                "No app found to open image",
//                                                Toast.LENGTH_SHORT
//                                            )
//                                            .show()
//                                    }
//                                }
//                        )
//                    }
//                }
//            }
//
//@Preview
//@Composable
//private fun FileItemViewPreview() {
//    FileItemView(fileModel = FacultyModel(), delete =
//
//    { }, deleteImage = { _, _ -> })
//
//}








