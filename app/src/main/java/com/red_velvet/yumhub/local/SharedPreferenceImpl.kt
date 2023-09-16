package com.red_velvet.yumhub.local

import android.content.SharedPreferences
import com.red_velvet.yumhub.repositories.datasources.SharedPreferenceService
import javax.inject.Inject

class SharedPreferenceImpl @Inject constructor(
    private val shearedPreferences: SharedPreferences
) : SharedPreferenceService {

    override fun saveUserName(name: String) {
        shearedPreferences.edit {
            putString("name", name)
        }
    }

    override fun saveHash(hash: String) {
        shearedPreferences.edit {
            putString("hash", hash)
        }
    }

    override fun getUserName(): String? {
        return shearedPreferences.getString("name", null)
    }

    override fun getHash(): String? {
        return shearedPreferences.getString("hash", null)
    }

    override fun clear() {
        shearedPreferences.edit {
            clear()
        }
    }

    override fun saveLastCachingTimeStamp(key: String, time: Long) {
        shearedPreferences.edit {
            putLong(key, time)
        }
    }

    override fun getLastCachingTime(key: String): Long {
        return shearedPreferences.getLong(key, 0)
    }

    override fun saveApiKey(apiKey: String) {
        shearedPreferences.edit {
            putString("apiKey", apiKey)
        }
    }

    override fun getApiKey(): String? {
        return shearedPreferences.getString("apiKey", null)
    }

    private fun SharedPreferences.edit(
        commit: Boolean = false,
        action: SharedPreferences.Editor.() -> Unit
    ) {
        val editor = edit()
        action(editor)
        if (commit) {
            editor.commit()
        } else {
            editor.apply()
        }
    }


}