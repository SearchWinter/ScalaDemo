package com.up.circulation

/**
 * @Description TODO
 * @Date 2020/6/29  14:07
 **/
object ForYield {
  def main(args: Array[String]): Unit = {
    val a = 0
    val numList = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val retVal = for (a <- numList
                      if a != 3; if a < 8
                      ) yield a
    for (a <- retVal) {
      print(a + ",")
    }
  }

}
