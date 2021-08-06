package com.ruzzante.businesscard.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class BusinessCard (
    @PrimaryKey(autoGenerate = true) val id:Int = 0,
    val nome:String,
    val nomeEmpresa:String,
    val telefone:String,
    val email:String,
    val corFundo:String
                        ){
}