package com.changui.android_mvvm_cleanarch_kotlin_flow.data.persistence

import androidx.room.TypeConverter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

class QuestionTagConverter {
    val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()
    val type = Types.newParameterizedType(List::class.java, String::class.java)
    val adapter = moshi.adapter<List<String>>(type)

    @TypeConverter
    fun fromJson(tags: List<String>): String {
        return adapter.toJson(tags)
    }

    @TypeConverter
    fun toJson(tagsInStrings: String): List<String> {
        return adapter.fromJson(tagsInStrings) ?: listOf()
    }
}