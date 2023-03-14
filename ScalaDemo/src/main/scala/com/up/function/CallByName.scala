package com.up.function

/**
 * @Description
 *  传值调用（call-by-value）：先计算参数表达式的值，再应用到函数内部；
 *  传名调用（call-by-name）：将未计算的参数表达式直接应用到函数内部
 * 在进入函数内部前，传值调用方式就已经将参数表达式的值计算完毕，而传名调用是在函数内部进行参数表达式的值计算的。
 * 这就造成了一种现象，每次使用传名调用时，解释器都会计算一次表达式的值。
 * @Date 2020/6/29  14:48
 **/
object CallByName {
  def main(args:Array[String]): Unit ={
    delayed(time())
  }

  def time()={
    println("获取时间，单位为纳秒")
    System.nanoTime
  }

  //在变量名和变量类型使用 => 符号来设置传名调用
  def delayed(t : =>Long)={
    // t为一个function，出现几次就会调用几次
    println("在delayed方法内")
    println("参数"+t)
    t
  }
}
