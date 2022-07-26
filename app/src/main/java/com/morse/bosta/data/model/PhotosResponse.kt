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
) : Parcelable {
    companion object {
        fun createFakeOne() = PhotosResponseItem(
            title = "Fake Image ",
            id = 1,
            albumId = 1,
            thumbnailUrl = "https://www.google.com/images/branding/googlelogo/2x/googlelogo_color_92x30dp.png",
            url = "https://www.wrike.com/blog/project-estimation-techniques/"
        )
    }
}
