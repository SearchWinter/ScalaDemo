package com.up.function

import org.apache.avro.TestAnnotation

/**
 * @Description 插入器函数 s   字符串连接
 * @Date 2020/8/27  19:09
 **/
object STest {
  def main(args: Array[String]): Unit = {
    val name = "tom "
    val value = s"hello,$name"
    print(value) //不换行
    println(value) //换行
  }
}
/*
output:
hello,tom
hello,tom */
