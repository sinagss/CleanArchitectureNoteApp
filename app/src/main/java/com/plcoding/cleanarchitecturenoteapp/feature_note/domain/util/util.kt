package com.plcoding.cleanarchitecturenoteapp.feature_note.domain.util

import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.*

private const val DECIMAL_FORMAT = "###,###,###.00"
private const val TIME_STAMP_FORMAT = "EEEE,MMMM d, yyyy - hh:mm:ss a"
private const val DATE_FORMAT = "yyy-MM-dd"

fun Any?.isNull() = this == null

fun String.toPrice(): String {
    val dec = DecimalFormat(DECIMAL_FORMAT)
    return dec.format(this.toDouble())
}

fun Double.toPriceAmount(): String {
    val dec = DecimalFormat(DECIMAL_FORMAT)
    return dec.format(this)
}

fun Long.getTimeStamp(): String {
    val date = Date(this)
    val simpleDateFormat = SimpleDateFormat(DATE_FORMAT, Locale.getDefault())
    simpleDateFormat.timeZone = TimeZone.getDefault()
    return simpleDateFormat.format(date)
}

fun String.getDateUnixTime(): Long {
    val simpleDateFormat = SimpleDateFormat(DATE_FORMAT, Locale.getDefault())
    simpleDateFormat.timeZone = TimeZone.getDefault()
    return simpleDateFormat.parse(this)!!.time
}

