package com.example.RecycleView

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Chara(
    val name: String = "",
    val description: String = "",
    val photo: Int,
    val detaildecs: String =""
) : Parcelable
