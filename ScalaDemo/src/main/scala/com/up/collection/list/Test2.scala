package com.up.collection.list

import java.util

/**
 * @Description TODO
 * @Date 2020/12/8  18:31
 **/
object Test2 {
  def main(args: Array[String]): Unit = {
    val map = Map(("java", 100), ("scala", 200), "demo" -> 200)
    val map2 = Map(("java", 100), ("scala", 400), "demo" -> 200)
    (map++map2).foreach(println)
  }

}
