package com.red_velvet.yumhub.repositories.datasources

interface SharedPreferenceService {
    fun saveUserName(name: String)
    fun saveHash(hash: String)
    fun getUserName(): String?
    fun getHash(): String?
    fun clear()

    fun saveLastCachingTimeStamp(key: String, time: Long)

    fun getLastCachingTime(key: String): Long
}
