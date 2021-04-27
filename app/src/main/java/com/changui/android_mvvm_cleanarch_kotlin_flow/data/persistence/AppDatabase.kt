package com.changui.android_mvvm_cleanarch_kotlin_flow.data.persistence

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.changui.android_mvvm_cleanarch_kotlin_flow.data.model.QuestionDataModel

@Database(entities = [QuestionDataModel::class], version = 1)
@TypeConverters(QuestionTagConverter::class, QuestionOwnerConverter::class)
abstract class AppDataBase : RoomDatabase() {
    abstract fun getQuestionsDao(): QuestionDao

    companion object {
        const val DB_VERSION = 1
        private const val DB_NAME = "stackoverflow.db"
        @Volatile
        private var INSTANCE: AppDataBase? = null

        fun getInstance(context: Context): AppDataBase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: build(context).also { INSTANCE = it }
            }

        private fun build(context: Context) =
            Room.databaseBuilder(context, AppDataBase::class.java, DB_NAME)
                .addMigrations(MIGRATION_1_TO_2)
                .build()

        //In case app has to migrate to a new DBDao
        private val MIGRATION_1_TO_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {

            }
        }
    }
}