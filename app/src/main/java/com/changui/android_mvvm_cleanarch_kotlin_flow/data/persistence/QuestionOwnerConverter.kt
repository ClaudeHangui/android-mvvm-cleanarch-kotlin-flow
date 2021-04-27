package com.changui.android_mvvm_cleanarch_kotlin_flow.data.persistence

import androidx.room.TypeConverter
import com.changui.android_mvvm_cleanarch_kotlin_flow.data.UserDataModel
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

class QuestionOwnerConverter {
    val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()
    val jsonAdapter: JsonAdapter<UserDataModel> = moshi.adapter(UserDataModel::class.java)

    @TypeConverter
    fun fromJson(owner: UserDataModel): String {
        return jsonAdapter.toJson(owner)
    }

    @TypeConverter
    fun toOwner(ownerInString: String): UserDataModel? {
        return jsonAdapter.fromJson(ownerInString)
    }
}