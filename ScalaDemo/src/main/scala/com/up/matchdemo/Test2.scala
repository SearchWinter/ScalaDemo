package com.up.matchdemo

/**
 * @Description 元组 迭代器
 * @Date 2020/10/13  14:44
 **/
object Test2 {
  def main(args: Array[String]): Unit = {
    val tuple: (Int, Double, Int, String, Char) = Tuple5(100, 23.00, 4, "hello", 'a')
    val iterator: Iterator[Any] = tuple.productIterator
    iterator
    iterator.foreach(x=>{
      x match {
        case 100 =>println("值为100")
        case d:Double if(d>30) =>println(s"double 值：$d ")
        case str:String => println(s"$str")
        case char:Char =>println(s"$char")
        case _ => println("other")
      }
    })
  }

}
