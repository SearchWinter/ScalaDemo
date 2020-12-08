package com.up.function

/**
 * @Description  指定函数参数名，不用按照顺序填写参数
 * @Date 2020/6/29  15:41
 **/
object CrintInt {
  def main(args:Array[String]): Unit ={
    PrintInt(b=10,a=100)
  }

  def PrintInt(a :Int,b:Int): Unit ={
    println("a的值为："+a);
    println("b的值为："+b);
  }
}
