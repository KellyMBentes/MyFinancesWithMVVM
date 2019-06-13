package com.kellymbentes.myfinanceswithmvvm.data.repository

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.auth.FirebaseAuthCredentialsProvider
import com.kellymbentes.myfinanceswithmvvm.data.mapper.FirestoreUserMapper
import com.kellymbentes.myfinanceswithmvvm.data.model.FirestoreUser

class FirebaseUserRepository : FirebaseRepository<FirestoreUser>(
    FirestoreUserMapper()
) {

    private val TAG = "FirebaseUserRepository"
    private val firebaseAuth = FirebaseAuth.getInstance()

    override fun getRootNode(): String {
        return "Users"
    }

    fun registerUser (user : FirestoreUser, password: String) {
        firebaseAuth.createUserWithEmailAndPassword(user.email!!, password).addOnCompleteListener() { task ->
            if (task.isSuccessful) {
                // Sign in success, update UI with the signed-in user's information
                Log.d(TAG, "signInWithEmail:success")
                create(user)
            } else {
                // If sign in fails, display a message to the user.
                Log.w(TAG, "signInWithEmail:failure", task.exception)
            }
        }
    }

    fun loginUser (email : String, password: String){
        firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener() { task ->
            if (task.isSuccessful) {
                // Sign in success, update UI with the signed-in user's information
                Log.d(TAG, "signInWithEmail:success")
            } else {
                // If sign in fails, display a message to the user.
                Log.w(TAG, "signInWithEmail:failure", task.exception)
            }
        }

    }
}