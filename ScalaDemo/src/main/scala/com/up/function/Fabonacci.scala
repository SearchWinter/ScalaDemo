package com.up.function

/**
 * @Description 使用for循环输出斐波拉契数列
 * @Date 2020/6/29  16:22
 **/
object Fabonacci {
  def main(args: Array[String]): Unit = {
    faBonacci(8);
  }

  def faBonacci(d: Int): Unit = {
    var a: Int = 1;
    var b: Int = 1;
    var c: Int = 0;
    println(a);
    println(b);
    var i = 0;
    for (i <- 1 to d) {
      c = a + b;
      a = b;
      b = c;
      println(c)
    }
  }

}
