package com.up

import java.text.SimpleDateFormat
import java.util.{Calendar, Date}

/**
 * @Description TODO
 * @Date 2020/9/18  19:14
 **/
object Utils {
  def main(args: Array[String]): Unit = {
    //当前时间转换为指定格式
    val format2 = new SimpleDateFormat("yyyyMMdd")
    val str1: String = format2.format(new Date())
    println(str1)

    //
    val str2: String = getNextDay("20200921", 2)
    println(str2)
    val addTimestamp: Long = parseTimestamp2(str2)
    println(addTimestamp)

    println(parseTimestamp2("20200920"))
    val string: String = (parseTimestamp2("20200920") + 24 * 60 * 60 * 1000).toString
    println(getTimestampToTime(string))


    println("****************")
    val strings: Array[String] = getNextMuttDays("20200920", 3)
    for(x<-strings){
      println(x)
    }
  }

  /**
   * 解析指定格式的时间转换为时间戳
   * @param ts
   * @return
   */
  def parseTimestamp(ts: String): Long = {
    val format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    format.parse(ts).getTime
  }
  def parseTimestamp2(ts:String):Long={
    val format = new SimpleDateFormat("yyyyMMdd")
    format.parse(ts).getTime
  }

  /**
   * 获取指定格式的当前时间
   * @return
   */
  def getNowDateFormat() ={
    val format = new SimpleDateFormat("yyyyMMdd")
    format.format(new Date())
  }

  /**
   * 时间戳转换为指定格式的日期
   * @param tamp
   * @return
   */
  def getTimestampToTime(tamp:String):String={
    val format = new SimpleDateFormat("yyyyMMdd")
    format.format(new Date(tamp.toLong))
  }


  /**
   *获取指定天数的前多少天的日期
   * @param dateStr
   * @param beforeDay
   * @return
   */
  def getBeforeDay(dateStr: String, beforeDay: Int): String = {
    val dateFormat = new SimpleDateFormat("yyyyMMdd")
    val calendar = Calendar.getInstance;
    val date = dateFormat.parse(dateStr)
    calendar.setTime(date)
    calendar.add(Calendar.DAY_OF_YEAR, -beforeDay)
    val tmpDateStr = dateFormat.format(calendar.getTime)
    tmpDateStr
  }

  /**
   *
   * @param dateStr
   * @param beforeDay
   * @return
   */
  def getBeforeTimeStamp(dateStr: String, beforeDay: Int): Long = {
    val dateFormat = new SimpleDateFormat("yyyyMMdd")
    val calendar = Calendar.getInstance;
    val date = dateFormat.parse(dateStr)
    calendar.setTime(date)
    calendar.add(Calendar.DAY_OF_YEAR, -beforeDay)
    calendar.getTime.getTime

  }

  /**
   *
   * @param dateStr
   * @param nextDay
   * @return
   */
  def getNextDay(dateStr: String, nextDay: Int): String = {
    val dateFormat = new SimpleDateFormat("yyyyMMdd")
    val calendar = Calendar.getInstance;
    val date = dateFormat.parse(dateStr)
    calendar.setTime(date)
    calendar.add(Calendar.DAY_OF_YEAR, nextDay)
    val tmpDateStr = dateFormat.format(calendar.getTime)
    tmpDateStr
  }

  /**
   *
   * @param dateStr
   * @param beforeDay
   * @return
   */
  def getBeforeMuttDays(dateStr: String, beforeDay: Int): Array[String] = {
    val dateFormat = new SimpleDateFormat("yyyyMMdd")
    val calendar = Calendar.getInstance;
    val date = dateFormat.parse(dateStr)
    calendar.setTime(date)
    val result = new Array[String](beforeDay)

    1.to(beforeDay).foreach { x =>
      calendar.add(Calendar.DAY_OF_YEAR, -1)
      val tmpDateStr = dateFormat.format(calendar.getTime)
      result(x - 1) = tmpDateStr
    }
    result
  }

  /**
   *
   * @param dateStr
   * @param nextDay
   * @return
   */
  def getNextMuttDays(dateStr: String, nextDay: Int): Array[String] = {
    val dateFormat = new SimpleDateFormat("yyyyMMdd")
    val calendar = Calendar.getInstance;
    val date = dateFormat.parse(dateStr)
    calendar.setTime(date)
    val result = new Array[String](nextDay)
    1.to(nextDay).foreach { x =>
      calendar.add(Calendar.DAY_OF_YEAR, 1)
      val tmpDateStr = dateFormat.format(calendar.getTime)
      result(x - 1) = tmpDateStr
    }
    result
  }
}
