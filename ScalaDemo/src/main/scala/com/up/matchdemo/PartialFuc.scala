package com.up.matchdemo

/**
 * @Description 偏函数：一个方法没有match，只有case    后面没有（）
 * @Date 2020/10/13  15:31
 **/
object PartialFuc {
  def main(args: Array[String]): Unit = {
    // new 一个偏函数的话，要实现其两个方法
    // apply 对数据如何操作， idDefinedAt 这个偏函数所接受参数的范围，可以是类型、值
    val inc: PartialFunction[String, String] = new PartialFunction[String, String] {

      override def isDefinedAt(x: String): Boolean = if (x.isInstanceOf[String]) true else false

      override def apply(v1: String): String = v1 + "demo"
    }
    println(inc("partial function "))

    //通过case实现偏函数更加简洁，常用
    println(PartialFucTest("scala"))
    println(PartialFucTest("good"))
  }
  def PartialFucTest:PartialFunction[String,String] ={
    case "scala"=> "hello scala"
    case "java"=>"hello java"
    case str:String => "this is string"
    case _ =>"other"
  }
}
