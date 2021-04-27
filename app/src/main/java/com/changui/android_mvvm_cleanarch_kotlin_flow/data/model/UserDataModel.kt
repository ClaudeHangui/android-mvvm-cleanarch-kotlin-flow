package com.changui.android_mvvm_cleanarch_kotlin_flow.data

import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parceler
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserDataModel(
    val accept_rate: Int,
    val display_name: String,
    val link: String,
    val profile_image: String,
    val reputation: Int,
    val user_id: Int,
    val user_type: String
): Parcelable

object UserParceler : Parceler<UserDataModel> {
    override fun create(parcel: Parcel) = UserDataModel(
        parcel.readInt(),
        parcel.readString().orEmpty(),
        parcel.readString().orEmpty(),
        parcel.readString().orEmpty(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString().orEmpty()
    )

    override fun UserDataModel.write(parcel: Parcel, flags: Int) {
        parcel.writeInt(accept_rate)
        parcel.writeString(display_name)
        parcel.writeString(link)
        parcel.writeString(profile_image)
        parcel.writeInt(reputation)
        parcel.writeInt(user_id)
        parcel.writeString(user_type)
    }
}