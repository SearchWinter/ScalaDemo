package com.up.collection

/**
 * @Description TODO
 * @Date 2020/10/13  10:06
 **/
object OptionDemo {
  def main(args: Array[String]): Unit = {
    val a1: Some[Int] = Some(5)
    val a: Some[(Int, Int)] = Some(5,10)
    val b: None.type = None

    //通过get得到元组中的数据
    val value: Int = a.get._1
//    println(value)

    //获取元组中存在的元素或者使用其默认的值
//    println(a1.getOrElse(0))
//    println(b.getOrElse(10))

    //返回元素的个数
    val arity: Int = a.productArity
//    println(arity)

    //如果可选值是 Some 的实例返回 true，否则返回 false。
    println(a.isDefined)

  }

}
