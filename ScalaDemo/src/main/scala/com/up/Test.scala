package com.up

import java.text.SimpleDateFormat
import java.util.Calendar

/**
 * @Description 某些符号和方法的案例
 * @Date 2020/9/20  23:59
 **/
object Test {
  def main(args: Array[String]): Unit = {

    //Scala 代码中$ 符具有在String 中直接拼接 字符串 和数字 等类型 。简化了字符串拼接。
    val name: String = "demo1"
    print(s"name is $name")
    getNextMuttDays("20210620",7).foreach(println)
  }

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
