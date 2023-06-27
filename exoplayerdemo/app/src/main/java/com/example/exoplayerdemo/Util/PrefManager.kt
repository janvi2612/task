package com.example.exoplayerdemo.Util

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object PrefManager {

    private lateinit var prefs: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor

    private const val PREFS_NAME = "params"
    const val IS_LOGIN = "IS_LOGIN"
    const val ACCESS_TOKEN = "ACCESS_TOKEN"


    @SuppressLint("CommitPrefEdits")
    fun init(context: Context) {
        prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        editor = prefs.edit()
    }

    fun setString(key: String?, value: String?) {
        editor.putString(key, value)
        editor.commit()
    }

    fun setStringSet(key: String?, value: MutableSet<String>?) {
        editor.putStringSet(key, value)
        editor.commit()
    }

    fun getString(key: String?, default: String = ""): String {
        return prefs.getString(key, default) ?: ""
    }

    fun getStringSet(key: String?, default: MutableSet<String>): MutableSet<String> {
        return prefs.getStringSet(key, default) ?: default
    }

    fun setBoolean(key: String?, value: Boolean) {
        editor.putBoolean(key, value)
        editor.commit()
    }

    fun getBoolean(key: String?, default: Boolean = false): Boolean {
        return prefs.getBoolean(key, default)
    }

    fun removeValue(key: String?) {
        with(editor) {
            remove(key)
            commit()
        }
    }

    fun saveHashMap(key: String?, obj: Any?) {
        val editor = prefs.edit()
        val gson = Gson()
        val json = gson.toJson(obj)
        editor.putString(key, json)
        editor.apply() // This line is IMPORTANT !!!
    }

    fun getHashMap(key: String?): HashMap<String?, String?>? {
        val gson = Gson()
        val json = prefs.getString(key, "")
        val type = object : TypeToken<HashMap<String?, String?>?>() {}.type
        return gson.fromJson(json, type)
    }

    fun clearAll() {
        with(editor) {
            clear()
            apply()
        }
    }

    fun clearExcept(keyList: List<String?>) {
        val keys: Map<String?, *> = prefs.all
        for ((key) in keys) {
            if (!keyList.contains(key)) {
                removeValue(key)
            }
        }
    }
}