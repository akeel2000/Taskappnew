package com.example.thenotesapp.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.thenotesapp.model.Note

@Dao
interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)//If data is already in the table replace the data
    suspend fun insertNote(note:Note)//note- table name ,Note-column

    @Update
    suspend fun updateNote(note:Note)

    @Delete
    suspend fun deleteNote(note:Note)

    @Query("SELECT * FROM NOTES ORDER BY id DESC")//NOTE- table name
    fun getAllNotes():LiveData<List<Note>>

    @Query("SELECT * FROM NOTES WHERE noteTitle LIKE :query OR noteDesc LIKE :query") //noteTile - column name
    fun searchNote(query: String?): LiveData<List<Note>>

}