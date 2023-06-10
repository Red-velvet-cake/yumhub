package com.red_velvet.yumhub.local

interface SharedPreferenceService {
    fun saveUserName(name: String)
    fun saveHash(hash: String)
    fun getUserName(): String?
    fun getHash(): String?
    fun clear()
}