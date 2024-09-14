package com.dineshdk.clickastro.repo

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.dineshdk.clickastro.models.ProductEntity

@Dao
interface ProductDao {

    // Insert a product into the database
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProduct(product: ProductEntity)

    // Insert a list of products
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProducts(products: List<ProductEntity>)

    // Fetch all products from the database
    @Query("SELECT * FROM products")
    suspend fun getAllProducts(): List<ProductEntity>

    // Fetch a product by ID
    @Query("SELECT * FROM products WHERE id = :productId")
    suspend fun getProductById(productId: String): ProductEntity?

    // Delete a product by ID
    @Query("DELETE FROM products WHERE id = :productId")
    suspend fun deleteProductById(productId: String)

    // Delete all products
    @Query("DELETE FROM products")
    suspend fun deleteAllProducts()
}