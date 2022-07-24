package com.morse.bosta.data


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class UserResponseItem(
    @SerializedName("address")
    val address: Address = Address(),
    @SerializedName("company")
    val company: Company = Company(),
    @SerializedName("email")
    val email: String = "", // Sincere@april.biz
    @SerializedName("id")
    val id: Int = 0, // 1
    @SerializedName("name")
    val name: String = "", // Leanne Graham
    @SerializedName("phone")
    val phone: String = "", // 1-770-736-8031 x56442
    @SerializedName("username")
    val username: String = "", // Bret
    @SerializedName("website")
    val website: String = "" // hildegard.org
) : Parcelable {
    @Parcelize
    data class Address(
        @SerializedName("city")
        val city: String = "", // Gwenborough
        @SerializedName("geo")
        val geo: Geo = Geo(),
        @SerializedName("street")
        val street: String = "", // Kulas Light
        @SerializedName("suite")
        val suite: String = "", // Apt. 556
        @SerializedName("zipcode")
        val zipcode: String = "" // 92998-3874
    ) : Parcelable {
        @Parcelize
        data class Geo(
            @SerializedName("lat")
            val lat: String = "", // -37.3159
            @SerializedName("lng")
            val lng: String = "" // 81.1496
        ) : Parcelable
    }

    @Parcelize
    data class Company(
        @SerializedName("bs")
        val bs: String = "", // harness real-time e-markets
        @SerializedName("catchPhrase")
        val catchPhrase: String = "", // Multi-layered client-server neural-net
        @SerializedName("name")
        val name: String = "" // Romaguera-Crona
    ) : Parcelable
}
