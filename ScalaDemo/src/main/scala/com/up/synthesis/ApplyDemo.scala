package com.up.synthesis

/**
 * @Description class object Apply()
 *             Scala中如果一个Class和一个Object同名，则称Class是Object的伴生类。
 *             Scala没有Java的Static修饰符，Object下的成员和方法都是静态的
 *             类名()调用Object下的Apply()方法，变量名()调用Class下的Apply()方法。
 * @Date 2020/10/13  11:00
 **/
class ApplyTest{
  def apply(): Unit ={
    println("This is a class,apply()……")
  }
}

object ApplyTest{
  def apply(): Unit ={
    println("This is a object,apply()……")
  }
}

object ApplyDemo {
  def main(args: Array[String]): Unit = {
    //apply方法类似于类的初始化方法，在遇到ApplyTest(参数1，参数2，......，参数n)时就会自动调用apply()方法。
    ApplyTest()

    val test = new ApplyTest()
    test()
  }
}
