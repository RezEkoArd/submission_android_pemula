package com.vsga.submissionandroidpemula

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Menu(
    val name : String,
    val duration : String,
    val photo : Int,
) : Parcelable
