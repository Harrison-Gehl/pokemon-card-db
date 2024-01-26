package com.example.pokemoncardapp.ui.theme

import androidx.room.Entity
import androidx.room.PrimaryKey

//https://developer.android.com/training/data-storage/room/defining-data
@Entity(primaryKeys = ["cardNum", "series","lang"])
data class Cards(
    // primary key components
    val cardNum: String?,
    val series: String?,
    val lang: String?,

    // info
    val name: String?,
    val type: String?,
    val evolution: String?,

    // misc attributes
    val normalArt: Int?,
    val holo: Int?,
    val reverseHolo: Int?,
    val fullHolo: Int?,

    val v: Int?,
    val ex: Int?,
    val gx: Int?,
)

