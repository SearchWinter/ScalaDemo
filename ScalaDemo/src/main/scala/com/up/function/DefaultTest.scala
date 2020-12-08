package com.up.function

/**
 * @Description 为方法设置默认参数值
 * @Date 2020/6/29  16:50
 **/
object DefaultTest {
  def main(args: Array[String]): Unit = {
    //使用默认的参数值
    println(add())
    //使用给定的参数值
    print(add(100, 200))
  }

  def add(a: Int = 10, b: Int = 20): Int = {
    a + b
  }
}
