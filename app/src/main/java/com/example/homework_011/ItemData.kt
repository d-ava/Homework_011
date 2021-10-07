package com.example.homework_011

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ItemData(
    var image: Int,
    var title: String,
    var description: String
):Parcelable
