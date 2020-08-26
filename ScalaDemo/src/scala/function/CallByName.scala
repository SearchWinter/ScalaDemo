package scala.function

/**
 * @Description TODO
 * @Date 2020/6/29  14:48
 **/
object CallByName {
  def main(args:Array[String]): Unit ={
    delayed(time())
  }

  def time()={
    println("获取时间，单位为纳秒")
    System.nanoTime
  }

  def delayed(t : =>Long)={
    println("在delayed方法内")
    println("参数"+t)
    t
  }
}
