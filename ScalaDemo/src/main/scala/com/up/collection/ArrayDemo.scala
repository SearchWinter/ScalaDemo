package com.up.collection

/**
 * @Description TODO
 * @Date 2021/6/1  18:56
 **/
object ArrayDemo {
  def main(args: Array[String]): Unit = {
    //构造数组的方法
    val empty: Array[String] = Array.empty
    val strings = new Array[String](10)
    val array: Array[Int] = Array(1, 2, 3, 4)
    //在数组末尾添加数据
    val ints: Array[Int] = array :+ (10)
    array.:+(10)
    array.foreach(println)
    println("********")
    ints.foreach(println)

    //参数组成的数组
    val Array(dateStr, guidOrImei, dateType) = args
    for(x<-Array(dateStr)){
      println(x)
    }
    println(guidOrImei)
  }

}
