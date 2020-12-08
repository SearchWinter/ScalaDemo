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
  def printStrings(str : String*): Unit ={
    val string=null;
    for(string <- str){
      println(string)
    }
  }

}
