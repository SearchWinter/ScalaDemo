package com.up.matchdemo

/**
 * @Description 样例类：使用case关键字定义的类
 * @Date 2020/10/13  15:15
 **/

case class Person(name:String ,age:Int)

object Test3 {
  def main(args: Array[String]): Unit = {
    val tom: Person = Person("TOM", 20)
    val cat: Person = Person("CAT", 30)

    for(person <- List(tom,cat)){
      person.name match {
        case "TOM" =>println(person.name+","+person.age)
        case _ =>println("other")
      }
    }


  }
}
