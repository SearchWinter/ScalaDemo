package com.up.function


/**
 * @Description 柯里化(Currying)指的是将原来接受两个参数的函数变成新的接受一个参数的函数的过程。新的函数返回一个以原有第二个参数为参数的函数
 * @Date 2022/6/2  11:47
 **/
object CurryTest {
  def main(args: Array[String]): Unit = {
    val res: Int = add(2)(1)
    println(res)

    val intToInt: Int => Int = add(2)
    val function: Int => Int = add(2)
    val res3: Int = function(10)
    println(res3)

    val function1: Int => Int = add2(2)
    val res4: Int = function1(10)
    println(res4)

    val numbers = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val res2: Int = numbers.foldLeft(0)(_ + _)
    println(res2)

    //返回一个新的函数，以第二个参数为参数
    val function2: ((Int, Int) => Int) => Int = numbers.foldLeft(10)
    val func = (x: Int, y: Int) => x + y
    val res5: Int = function2(func)
    println(res5)


  }

  //add(1)(2) 实际上是依次调用两个普通函数（非柯里化函数），第一次调用使用一个参数 x，返回一个函数类型的值，第二次使用参数y调用这个函数类型的值
  def add(x: Int)(y: Int) = x + y

  //实质上最先演变成这样一个方法：
  // 接收一个x为参数，返回一个匿名函数，该匿名函数的定义是：接收一个Int型参数y，函数体为x+y
  def add2(x: Int) = (y: Int) => (x + y)

}
