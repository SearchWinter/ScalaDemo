package com.up.collection

/**
 * @Description TODO
 * @Date 2020/9/21  14:06
 **/
object MapDemo {
  def main(args: Array[String]): Unit = {
    //Map键值对演示
    //定义Map时，需要为键值对定义类型。如果需要添加 key-value 对，可以使用 + 号
    //第一种
    var map: Map[String, String] = Map()
    //第二种
    var stringToString: Map[String, String] = Map("red" -> "#FF0000", "peru" -> "#CD853F")
    /** 添加值 */
    stringToString += ("azure" -> "#F0FFFF")

    //通过key获取Value
    val str: String = stringToString("azure")
    println(str)

    val option: Option[String] = stringToString.get("azure")

    //如果 Map 中存在指定 key，返回 true，否则返回 false。
    val bool: Boolean = stringToString.contains("red")
    println(bool)

  }

}
