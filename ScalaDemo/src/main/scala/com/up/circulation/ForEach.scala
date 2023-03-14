package com.up.circulation

/**
 * @Description 1.to().foreach{}  用法
 * @Date 2020/9/30  10:04
 **/
object ForEach {
  def main(args: Array[String]): Unit = {
    val n=10;
    val result: Array[Int] = new Array[Int](n)

    1.to(n).foreach { x =>
      result(x-1) = x
    }

    result.foreach(a=>
      println(a)
    )
  }
}
