package com.kellymbentes.myfinanceswithmvvm.data.repository

import android.util.Log
import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import com.kellymbentes.myfinanceswithmvvm.data.mapper.FirebaseMapper

abstract class FirebaseRepository<T> (
    val mapper : FirebaseMapper<T>
){
    private val TAG = "FirebaseRepository"
    protected abstract fun getRootNode(): String
    private val db = FirebaseFirestore.getInstance()
    private val collection = db.collection(getRootNode())

    fun create (value : T){

        val map = mapper.fromMap(value)
        if (map != null){
            collection
                .add(map)
                .addOnSuccessListener(OnSuccessListener<DocumentReference> { documentReference ->
                    Log.d(TAG, "DocumentSnapshot written with ID: " + documentReference.id)
                })
                .addOnFailureListener(OnFailureListener { e ->
                    Log.w(TAG, "Error adding document", e)
                })
        }
    }
}