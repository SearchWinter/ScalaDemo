package com.up.circulation

/**
 * @Description for循环集合
 * @Date 2020/6/29  13:54
 **/
object ForList {
  def main(args:Array[String]){
    var a=0;
    var numList=List(1,2,3,4,5);
    for(a <- numList){
      println(a)
    }
  }

}
