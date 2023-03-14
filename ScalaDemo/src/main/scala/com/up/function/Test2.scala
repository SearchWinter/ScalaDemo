package com.up.function

/**
 * @Description TODO
 * @Date 2023/1/18  16:55
 **/
object Test2 {
  def main(args: Array[String]): Unit = {
    def add(x:Int,y:Int)=x+y*2
    def add2(x:Int)(y:Int)=x+y

    val function1=(x:Int)=>x*2
    val function: (Int => Int) = new Function[Int, Int] {
      def apply(v1: Int): Int = v1 * 2
    }

    println(add(1,2))
    println(add2(1)(2))
  }
  def add(x:Int,y:Int)=x+y


}
