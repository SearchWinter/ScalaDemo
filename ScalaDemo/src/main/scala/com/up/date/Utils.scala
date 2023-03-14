package com.up.date

import java.text.SimpleDateFormat
import java.util.{Calendar, Date}

import org.apache.spark.sql.catalyst.expressions.DayOfYear

/**
 * @Description Date相关方法
 * @Date 2021/6/2  13:58
 **/
object Utils {
  def main(args: Array[String]): Unit = {
    val strings: Array[String] = getBeforeDays("20200916", 6)
    val strings1: Array[String] = strings.:+("20200916")
    strings.foreach(println)
    strings1.foreach(println)
  }

  def getBeforeDays(dateString:String,beforeDay:Int):Array[String]={
    val dateFormat = new SimpleDateFormat("yyyyMMdd")
    val date: Date = dateFormat.parse(dateString)
    val calendar: Calendar = Calendar.getInstance()
    calendar.setTime(date)
    val array = new Array[String](beforeDay)
    1.to(beforeDay).foreach { x =>
      calendar.add(Calendar.DAY_OF_YEAR, -1)
      val str: String = dateFormat.format(calendar.getTime)
      array(beforeDay-x)=str
    }
    array
  }
}
