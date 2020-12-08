package com.up.circulation

/**
 * @Description do...while循环
 * @Date 2020/6/29  11:58
 **/
object DoWhile {
    def main(args:Array[String]): Unit ={
      var i=10;
      do{
        println(i);
        i=i+1;
      }while(i<20)
    }
}
