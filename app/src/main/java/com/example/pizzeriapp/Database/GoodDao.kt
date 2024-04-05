package com.example.pizzeriapp.Database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface GoodDao {

    @Insert
    suspend fun insert(item : GoodItem)

    @Update
    suspend fun update(item : GoodItem)

    @Query("DELETE FROM GoodTable WHERE id = :id")
    suspend fun  delete(id : Int)

    @Query("DELETE FROM GoodTable")
    suspend fun  deleteAll()
    @Query("SELECT * FROM GoodTable")
    fun getAllItems() : Flow<List<GoodItem>>


    @Query("SELECT * FROM GoodTable WHERE id == :id")
    fun getItem(id : Int) : Flow<GoodItem>

}