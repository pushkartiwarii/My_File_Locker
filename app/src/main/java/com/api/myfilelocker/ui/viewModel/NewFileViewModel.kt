package com.api.myfilelocker.ui.viewModel

import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.api.myfilelocker.dataModel.FacultyModel
import com.api.myfilelocker.utils.constants.NEWFILE
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import com.google.firebase.storage.storage
import java.util.UUID

//class NewFileViewModel : ViewModel() {
//    private val facultyRef = Firebase.firestore.collection(NEWFILE)
//
//    private val storageRef = Firebase.storage.reference
//
//    private val _isPosted = MutableLiveData<Boolean>()
//    val isPosted: LiveData<Boolean> = _isPosted
//
//    private val _isDeleted = MutableLiveData<Boolean>()
//    val isDeleted : LiveData<Boolean> = _isDeleted
//
//    private val _facultyList = MutableLiveData<List<FileModel>>()
//    val facultyList : LiveData<List<FileModel>> = _facultyList
//
//    private val _categoryList = MutableLiveData<List<String>>()
//    val categoryList : LiveData<List<String>> = _categoryList
//
//
//
//    fun saveFaculty(uri: Uri, name:String, catName:String){
//        _isPosted.postValue(false)
//        val randomid = UUID.randomUUID().toString()
//
//        val imageRef = storageRef.child("$NEWFILE/${randomid}.jpg")
//
//        val uploadTask = imageRef.putFile(uri)
//
//        uploadTask.addOnSuccessListener {
//            imageRef.downloadUrl.addOnSuccessListener {
//                uploadNotice(it.toString(),randomid,name,catName)
//            }
//        }
//    }
//    private fun uploadNotice(imageUrl: String , docId: String , name: String , catName: String){
//        val map = mutableMapOf<String,String>()
//        map["imageUrl"] = imageUrl
//        map["name"] = name
//
//        map["catName"] = catName
//
//        facultyRef.document(catName).collection("file").document(docId).set(map)
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
//    fun uploadCategory (category:String){
//        val map = mutableMapOf<String,String>()
//        map["catName"] = category
//
//
//        facultyRef.document(category).set(map)
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
//
//    fun getFaculty(catName: String){
//        facultyRef.document(catName).collection("Teacher").get().addOnSuccessListener{
//            val list = mutableListOf<FileModel>()
//
//            for(doc in it){
//                list.add(doc.toObject(FileModel::class.java))
//            }
//            _facultyList.postValue(list)
//
//        }
//
//    }
//    fun getCategory(){
//        facultyRef.get().addOnSuccessListener{
//            val list = mutableListOf<String>()
//
//            for(doc in it){
//                list.add(doc.get("catName").toString())
//            }
//            _categoryList.postValue(list)
//
//        }
//
//    }
//
//    fun deleteFaculty (fileModel: FileModel){
//
//
//        facultyRef.document(fileModel.catName!!).collection("Teacher").document(fileModel.docId!!).delete()
//            .addOnSuccessListener {
//                Firebase.storage.getReferenceFromUrl(fileModel.imageUrl!!).delete()
//                _isDeleted.postValue(true)
//            }
//            .addOnFailureListener{
//                _isDeleted.postValue(false)
//            }
//    }
//
//    fun deleteCategory (category: String){
//
//
//        facultyRef.document(category).delete()
//            .addOnSuccessListener {
//
//                _isDeleted.postValue(true)
//            }
//            .addOnFailureListener{
//                _isDeleted.postValue(false)
//            }
//    }
//}

class FacultyViewModel : ViewModel() {
    private val facultyRef = Firebase.firestore.collection(NEWFILE)

    private val storageRef = Firebase.storage.reference

    private val _isPosted = MutableLiveData<Boolean>()
    val isPosted:LiveData<Boolean> = _isPosted

    private val _isDeleted = MutableLiveData<Boolean>()
    val isDeleted :LiveData<Boolean> = _isDeleted

    private val _facultyList = MutableLiveData<List<FacultyModel>>()
    val facultyList : LiveData<List<FacultyModel>> = _facultyList

    private val _categoryList = MutableLiveData<List<String>>()
    val categoryList : LiveData<List<String>> = _categoryList



    fun saveFaculty(uri: Uri,name:String,email:String,position:String,catName:String){
        _isPosted.postValue(false)
        val randomid = UUID.randomUUID().toString()

        val imageRef = storageRef.child("$NEWFILE/${randomid}.jpg")

        val uploadTask = imageRef.putFile(uri)

        uploadTask.addOnSuccessListener {
            imageRef.downloadUrl.addOnSuccessListener {
                uploadNotice(it.toString(),randomid,name,email,position,catName)
            }
        }
    }
    private fun uploadNotice(imageUrl: String , docId: String , name: String , email: String,position: String,catName: String){
        val map = mutableMapOf<String,String>()
        map["imageUrl"] = imageUrl
        map["docId"] = docId
        map["name"] = name
        map["email"] = email
        map["position"] = position
        map["catName"] = catName

        facultyRef.document(catName).collection("Teacher").document(docId).set(map)
            .addOnSuccessListener {
                _isPosted.postValue(true
                )
            }
            .addOnFailureListener{
                _isPosted.postValue(false
                )
            }

    }
    fun uploadCategory (category:String){
        val map = mutableMapOf<String,String>()
        map["catName"] = category


        facultyRef.document(category).set(map)
            .addOnSuccessListener {
                _isPosted.postValue(true
                )
            }
            .addOnFailureListener{
                _isPosted.postValue(false
                )
            }

    }
    fun getFaculty(catName: String){
        facultyRef.document(catName).collection("Teacher").get().addOnSuccessListener{
            val list = mutableListOf<FacultyModel>()

            for(doc in it){
                list.add(doc.toObject(FacultyModel::class.java))
            }
            _facultyList.postValue(list)

        }

    }
    fun getCategory(){
        facultyRef.get().addOnSuccessListener{
            val list = mutableListOf<String>()

            for(doc in it){
                list.add(doc.get("catName").toString())
            }
            _categoryList.postValue(list)

        }

    }
    fun deleteFaculty (noticeModel: FacultyModel){


        facultyRef.document(noticeModel.catName!!).collection("Teacher").document(noticeModel.docId!!).delete()
            .addOnSuccessListener {
                Firebase.storage.getReferenceFromUrl(noticeModel.imageUrl!!).delete()
                _isDeleted.postValue(true)
            }
            .addOnFailureListener{
                _isDeleted.postValue(false)
            }
    }
    fun deleteCategory (category: String){


        facultyRef.document(category).delete()
            .addOnSuccessListener {

                _isDeleted.postValue(true)
            }
            .addOnFailureListener{
                _isDeleted.postValue(false)
            }
    }
}