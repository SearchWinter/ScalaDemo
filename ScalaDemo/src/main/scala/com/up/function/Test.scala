package com.up.function

/**
 * @Description 可变参数,参数的个数不确定
 * @Date 2020/6/29  15:51
 **/
object Test {
  def main(args:Array[String]): Unit ={
//    printStrings("hello","cat","dog");

    val Array(dateStr) = args

  }
  //Scala 通过在参数的类型之后放一个星号来设置可变参数(可重复的参数)
  def printStrings(str : String*): Unit ={
    val string=null;
    for(string <- str){
      println(string)
    }
  }

}
