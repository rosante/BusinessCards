package com.ruzzante.businesscard.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


// Segundo a aula, o Room fornece essa implementação, então não foi detalhado o que cada chamada faz
// Mas basicamente está sendo instanciado o banco Room para uso na aplicação
@Database(entities = [BusinessCard::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun businessDao(): BusinessCardDao
    companion object{
        @Volatile
        private var INSTANCE : AppDatabase? = null

        fun getDatabase(context: Context):AppDatabase{
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "businesscard_db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}