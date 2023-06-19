package com.red_velvet.repository.utils

fun Int?.orZero(): Int = this ?: 0

fun Double?.orZero(): Double = this ?: 0.0

fun Float?.orZero(): Float = this ?: 0f

fun Long?.orZero(): Long = this ?: 0L

fun Boolean?.orFalse(): Boolean = this ?: false

fun String?.orEmpty(): String = this ?: ""

fun <T> List<T>?.orEmptyList(): List<T> = this ?: emptyList()

inline fun <reified T> Array<T>?.orEmptyArray(): Array<T> = this ?: emptyArray()

fun <T> Set<T>?.orEmptySet(): Set<T> = this ?: emptySet()
