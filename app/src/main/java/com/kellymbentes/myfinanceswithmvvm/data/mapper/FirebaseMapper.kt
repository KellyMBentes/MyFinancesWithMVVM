package com.kellymbentes.myfinanceswithmvvm.data.mapper

import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.QueryDocumentSnapshot
import com.google.firebase.firestore.QuerySnapshot
import java.util.ArrayList

abstract class FirebaseMapper <Model> :
    IMapper<MutableMap<String, Any>?, Model?> {

    fun toMap(documentSnapshot: DocumentSnapshot): Model? {
        return toMap(documentSnapshot.data)
    }

    fun toMap(queryDocumentSnapshot: QueryDocumentSnapshot): Model? {
        return toMap(queryDocumentSnapshot.data)
    }

    fun mapList(result: QuerySnapshot?): List<Model?> {

        val list = ArrayList<Model?>()

        result?.forEach { item ->
            list.add(toMap(item))
        }

        return list
    }
}