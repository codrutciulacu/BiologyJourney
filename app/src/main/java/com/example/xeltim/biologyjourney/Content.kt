package com.example.xeltim.biologyjourney

class Content(var URL: Array<String>, var title: String?){

    private var mTitle : String? = null
    get() = mTitle

    private var mURL : Array<String>? = null
    get() = mURL

    init{
        this.mTitle = title
        this.mURL = URL
    }



}