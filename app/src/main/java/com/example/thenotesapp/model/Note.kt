package com.example.thenotesapp.model

import android.icu.text.CaseMap.Title
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "notes")
@Parcelize//transfer comlex data object simply (easy) formate between activity and fragment
data class Note(
    @PrimaryKey
    val id:String,
    val noteTitle: String,
    val noteDesc: String
):Parcelable
