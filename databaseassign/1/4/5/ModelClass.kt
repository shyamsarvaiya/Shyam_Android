package com.example.work_management

import android.graphics.Bitmap

class ModelClass(
    private var image: Bitmap,
    private var username: String,
    private var password: String,
    private var cpassword: String,
    private var mobile: String,
    private var email: String
) {
    fun getUserName(): String {
        return username
    }

    fun setUserName(username: String) {
        this.username = username
    }
    fun getPassword(): String {
        return password
    }

    fun setPassword(password: String) {
        this.password = password
    }

    fun getCpassword(): String {
        return cpassword
    }

    fun setCpassword(cpassword: String) {
        this.cpassword = cpassword
    }
    fun getMobile(): String {
        return mobile
    }

    fun setMobile(mobile: String) {
        this.mobile = mobile
    }
    fun getEmail(): String {
        return email
    }

    fun setEmail(email: String) {
        this.email = email
    }
    fun getImage(): Bitmap {
        return image
    }

    fun setImage(Image: Bitmap) {
        this.image = image
    }

    companion object {
        fun getImage(): Bitmap {
            return getImage()
        }
    }
}



 /*   public ModelClass(
        image: Bitmap,
        username: String,
        password: String,
        cpassword: String,
        mobile: String,
        email: String
    ) {
        this.image = image
        this.username = username
        this.password = password
        this.cpassword = cpassword
        this.mobile = mobile
        this.email = email
    }*/