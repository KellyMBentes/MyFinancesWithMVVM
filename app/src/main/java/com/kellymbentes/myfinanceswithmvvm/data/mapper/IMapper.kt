package com.kellymbentes.myfinanceswithmvvm.data.mapper

interface IMapper<From, To> {
    fun toMap (from : From) : To
    fun fromMap (to: To) : From
}