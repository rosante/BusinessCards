package com.ruzzante.businesscard

import android.app.Application
import com.ruzzante.businesscard.data.AppDatabase
import com.ruzzante.businesscard.data.BusinessCardRepository

class App : Application() {
    val database by lazy { AppDatabase.getDatabase(this)}
    val repository by lazy { BusinessCardRepository(database.businessDao())}
}