package com.up.exceptiondemo

import java.io.{FileNotFoundException, FileReader}

/**
 * @Description 异常处理
 * @Date 2020/10/13  16:58
 **/
object ExDemo {
  def main(args:Array[String]):Unit ={
    try {
      val reader = new FileReader("input.txt")
    }catch {
      case ex:FileNotFoundException =>println("missing file exception")
      case ex:Throwable => println("throwable")
    }finally{
      println("exiting finally……")
    }
  }
}
