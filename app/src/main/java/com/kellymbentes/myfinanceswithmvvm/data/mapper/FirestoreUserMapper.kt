package com.kellymbentes.myfinanceswithmvvm.data.mapper

import com.kellymbentes.myfinanceswithmvvm.data.model.FirestoreUser
import java.util.HashMap

class FirestoreUserMapper : FirebaseMapper<FirestoreUser>() {

    val USERNAME: String = "username"
    val EMAIL: String = "email"

    override fun toMap(from: MutableMap<String, Any>?): FirestoreUser? {

        if (from == null) return FirestoreUser()

        return FirestoreUser(
            from[USERNAME] as String?,
            from[EMAIL] as String?
        )
    }

    override fun fromMap(to: FirestoreUser?): MutableMap<String, Any>? {

        if (to == null) return null;

        val result : MutableMap<String, Any> = HashMap<String, Any>()

        result[USERNAME] = to.username as Any
        result[EMAIL] = to.email as Any

        return result;
    }
}