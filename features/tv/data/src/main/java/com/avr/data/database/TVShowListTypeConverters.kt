package com.avr.data.database

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.*

class ListOfStringToStringTypeConvertor {
    @TypeConverter
    fun listOfStringToString(str: List<String>): String {
        return Gson().toJson(str)
    }

    @TypeConverter
    fun strToListString(str: String): List<String> {
        return Gson().fromJson(str, object : TypeToken<List<String>>() {}.type)
    }

}

class ListOfIntToIntTypeConvertor {
    @TypeConverter
    fun someObjectListToString(intList: List<Int>): String {
        return Gson().toJson(intList);
    }

    @TypeConverter
    fun stringToIntegerList(str: String): List<Int> {

        return Gson().fromJson(str, object : TypeToken<List<Int>>() {}.type)
    }
}