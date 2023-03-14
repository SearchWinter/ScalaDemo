package com.up.function

/**
 * @Description TODO
 * @Date 2020/6/29  14:27
 **/
object Add {
  def main(args:Array[String]): Unit ={
    println(addInt(10,20));
  }
  def addInt(a:Int,b:Int):Int={
    (a+100)*b
  }

}
