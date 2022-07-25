package com.morse.bosta.data

import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class AlbumsResponseItem(
    @SerializedName("id")
    val id: Int = 0, // 1
    @SerializedName("title")
    val title: String = "", // quidem molestiae enim
    @SerializedName("userId")
    val userId: Int = 0 // 1
) : Parcelable {
    companion object {
        fun createFakeOne() = AlbumsResponseItem(id = 1, title = "Fake Album Name", userId = 1)
    }
}
