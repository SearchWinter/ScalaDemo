package com.up.function

/**
 * @Description Scala 中允许使用高阶函数, 高阶函数可以使用其他函数作为参数，或者使用函数作为输出结果。
 * @Date 2022/6/2  11:04
 **/
object HighFunc {
  def main(args: Array[String]): Unit = {

    println(apply(layOut, 10))

  }

  // 函数 f 和 值 v 作为参数，而函数 f 又调用了参数 v
  def apply(f: Int => String, v: Int) = f(v)

  def layOut[A](x: A): String = "[" + x.toString() + "]"


}
