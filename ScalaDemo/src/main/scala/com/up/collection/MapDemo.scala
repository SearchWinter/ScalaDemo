package com.up.collection

/**
 * @Description TODO
 * @Date 2020/9/21  14:06
 **/
object MapDemo {
  def main(args: Array[String]): Unit = {
    //Map键值对演示
    //定义 Map 时，需要为键值对定义类型。如果需要添加 key-value 对，可以使用 + 号
    var stringToString: Map[String, String] = Map("red" -> "#FF0000", "peru" -> "#CD853F")
    stringToString+=("azure"->"#F0FFFF")

//    val i: Int = stringToString.count()
    //通过key获取Value
    val str: String = stringToString("azure")
    println(str)
  }

}
