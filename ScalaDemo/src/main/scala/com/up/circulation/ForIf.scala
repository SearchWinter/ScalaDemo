package com.up.circulation

/**
 * @Description for循环过滤
 * @Date 2020/6/29  14:01
 **/
object ForIf {
  def main(args:Array[String]): Unit ={
    var a=0;
    val numlist=List(1,2,3,4,5,6)
    for(a <- numlist
        if a!=3; if a<5
        ){
      print(a+",")
    }
  }

}
