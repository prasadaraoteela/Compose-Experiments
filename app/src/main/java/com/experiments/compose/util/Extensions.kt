package com.experiments.compose.util

import android.content.Context
import android.os.Build
import java.text.NumberFormat
import java.util.*

import com.google.gson.Gson
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit
import java.util.concurrent.TimeUnit

/**
 * Created by Prasada Rao on 26/11/21 1:16 PM
 **/
const val SERVER_DATE_FORMAT = "dd/MM/yyyy"
const val DATE_DISPLAY_FORMAT = "dd MMM yyyy"

fun Double.formatAsAmount(locale: Locale = Locale.US): String {
  val format: NumberFormat = NumberFormat.getCurrencyInstance(locale)
  format.maximumFractionDigits = 2
  return format.format(this)
}

fun Context.readJsonAsset(fileName: String): String {
  val inputStream = assets.open(fileName)
  val size = inputStream.available()
  val buffer = ByteArray(size)
  inputStream.read(buffer)
  inputStream.close()
  return String(buffer, Charsets.UTF_8)
}

inline fun <reified T> String.parse(): T {
  val gson = Gson()
  return gson.fromJson(this, T::class.java)
}

fun String.dateToDisplayFormat(): String {
  val serverDateFormat = SimpleDateFormat(SERVER_DATE_FORMAT, Locale.getDefault())
  val dateDisplayFormat = SimpleDateFormat(DATE_DISPLAY_FORMAT, Locale.getDefault())

  val serverDate = serverDateFormat.parse(this) ?: return ""

  return dateDisplayFormat.format(serverDate)
}

fun String.numberOfDaysAgo(): String {
  val date: Date = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).parse(this) ?: return ""
  val duration = Calendar.getInstance().timeInMillis - date.time

  val yearsAgo = duration / TimeUnit.DAYS.toMillis(365)
  if (yearsAgo > 0) return "$yearsAgo years ago"

  val monthsAgo = duration / TimeUnit.DAYS.toMillis(30)
  if (monthsAgo > 0) return "$monthsAgo months ago"

  val daysAgo = duration / TimeUnit.DAYS.toMillis(1)
  if (daysAgo > 1) return "$daysAgo days ago"

  if (daysAgo == 0L) return "Today"
  return "Yesterday"
}