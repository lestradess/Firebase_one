package com.lestrades.firebase_one

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //FirebaseDatabase.getInstance("https://kotlin-firebase-4fdf0-default-rtdb.europe-west1.firebasedatabase.app")
        val database = Firebase.database.reference
        //findViewById<TextView>(R.id.tvData).text = database.toString()
        val listener = object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val data = snapshot.getValue(String::class.java)
                findViewById<TextView>(R.id.tvData).text = "Firebase remote: $data"
            }
            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        }
        val dataRef = database.child("hola_firebase").child("data")
        dataRef.addValueEventListener(listener)
        //
    }
}