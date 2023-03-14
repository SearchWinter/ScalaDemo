package com.up.function

/**
 * @Description 递归调用 计算阶乘
 * @Date 2020/6/29  15:58
 **/
object Factorial {
  def main(args:Array[String]): Unit ={
    println(factor(3))
  }
  def factor(num : Int): Int ={
    if(num<=1){
      1
    }else{
      num * factor(num-1)
    }
  }
}
