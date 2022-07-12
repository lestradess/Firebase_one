package com.lestrades.firebase_one

import android.app.Application
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class MyApplication : Application() {
    override fun onCreate(){
        super.onCreate()

        //offline guarda los datos introducidos sin conexión.
        Firebase.database.setPersistenceEnabled(true)
    }
}