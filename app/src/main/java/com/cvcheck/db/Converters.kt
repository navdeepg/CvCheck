package com.cvcheck.db

import androidx.room.TypeConverter
import com.cvcheck.db.entity.ExperienceType
import com.cvcheck.db.entity.SkillType
import com.google.gson.Gson

class Converters {

    @TypeConverter
    fun listToJson(value: List<SkillType>?): String {

        return Gson().toJson(value)
    }

    @TypeConverter
    fun jsonToList(value: String): List<SkillType>? {

        val objects = Gson().fromJson(value, Array<SkillType>::class.java) as Array<SkillType>
        val list = objects.toList()
        return list
    }

    @TypeConverter
    fun listToJsonExp(value: List<ExperienceType>?): String {

        return Gson().toJson(value)
    }

    @TypeConverter
    fun jsonToListExp(value: String): List<ExperienceType>? {

        val objects = Gson().fromJson(value, Array<ExperienceType>::class.java) as Array<ExperienceType>
        val list = objects.toList()
        return list
    }
}