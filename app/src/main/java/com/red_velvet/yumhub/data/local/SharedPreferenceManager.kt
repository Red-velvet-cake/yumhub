package com.red_velvet.yumhub.data.local

import android.content.SharedPreferences
import javax.inject.Inject

class SharedPreferenceManager @Inject constructor(
    private val shearedPreferences: SharedPreferences,
) {

    fun saveUserName(name: String) {
        shearedPreferences.edit {
            putString("name", name)
        }
    }

    fun saveHash(hash: String) {
        shearedPreferences.edit {
            putString("hash", hash)
        }
    }

    fun getUserName(): String? {
        return shearedPreferences.getString("name", null)
    }

    fun getHash(): String? {
        return shearedPreferences.getString("hash", null)
    }

    fun clear() {
        shearedPreferences.edit {
            clear()
        }
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