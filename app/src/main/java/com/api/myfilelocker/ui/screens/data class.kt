package com.api.myfilelocker.ui.screens

data class PdfFile(val fileName : String , val downloadUrl : String){
    constructor() : this("","")
}

