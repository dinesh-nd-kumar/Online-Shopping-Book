package com.dineshdk.clickastro.repo

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dineshdk.clickastro.models.ProductEntity

@Database(entities = [ProductEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun productDao(): ProductDao
}

