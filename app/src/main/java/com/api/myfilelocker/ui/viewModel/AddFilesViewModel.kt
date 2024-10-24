package com.api.myfilelocker.ui.viewModel

//class AddFilesViewModel:ViewModel(){
//
//    private val addfileref = Firebase.firestore.collection(FILE)
//
//    private val storageRef = Firebase.storage.reference
//
//    private val _isPosted = MutableLiveData<Boolean>()
//    val isPosted: LiveData<Boolean> = _isPosted
//
//    private val _isDeleted = MutableLiveData<Boolean>()
//    val isDeleted : LiveData<Boolean> = _isDeleted
//
//    private val _fileList= MutableLiveData<List<FileModel>>()
//    val fileList : LiveData<List<FileModel>> = _fileList
//
//    fun saveImage(uri: Uri,name:String,){
//        _isPosted.postValue(false)
//        val randomid = UUID.randomUUID().toString()
//
//        val imageRef = storageRef.child("$FILE/${randomid}.jpg")
//
//        val uploadTask = imageRef.putFile(uri)
//
//        uploadTask.addOnSuccessListener {
//            imageRef.downloadUrl.addOnSuccessListener {
//                uploadImage(it.toString(),name)
//            }
//        }
//    }
//    fun uploadImage(
//        imageUrl: String,
//        name: String,
//    ){
//        val map = mutableMapOf<String,Any>()
//        map["imageUrl"] = imageUrl
//        map["name"] = name
//
//
//        addfileref.document("University").set(map)
//            .addOnSuccessListener {
//                _isPosted.postValue(true
//                )
//            }
//            .addOnFailureListener{
//                _isPosted.postValue(false
//                )
//            }
//
//    }
//    fun getGallery(){
//        addfileref.get().addOnSuccessListener{
//            val list = mutableListOf<FileModel>()
//
//            for(doc in it){
//                list.add(doc.toObject(FileModel::class.java))
//            }
//            _fileList.postValue(list)
//
//        }
//
//    }
//    fun deleteImage (name: String,image: String){
//
//
//        addfileref.document(name).update("images", FieldValue.arrayRemove(image))
//            .addOnSuccessListener {
//                Firebase.storage.getReferenceFromUrl(image).delete()
//
//                _isDeleted.postValue(true)
//            }
//            .addOnFailureListener{
//                _isDeleted.postValue(false)
//            }
//    }
//    fun deleteGallery(fileModel: FileModel){
//
//
//        addfileref.document(fileModel.name!!).delete()
//            .addOnSuccessListener {
//                fileModel.images!!.forEach {
//                    Firebase.storage.getReferenceFromUrl(it).delete()
//
//                }
//                _isDeleted.postValue(true)
//            }
//            .addOnFailureListener{
//                _isDeleted.postValue(false)
//            }
//    }
//
//
//
//
//
//
//
//}