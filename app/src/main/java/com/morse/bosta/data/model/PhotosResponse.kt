package com.morse.bosta.data


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable


@Parcelize
data class PhotosResponseItem(
    @SerializedName("albumId")
    val albumId: Int = 0, // 1
    @SerializedName("id")
    val id: Int = 0, // 1
    @SerializedName("thumbnailUrl")
    val thumbnailUrl: String = "", // https://via.placeholder.com/150/92c952
    @SerializedName("title")
    val title: String = "", // accusamus beatae ad facilis cum similique qui sunt
    @SerializedName("url")
    val url: String = "" // https://via.placeholder.com/600/92c952
) : Parcelable
