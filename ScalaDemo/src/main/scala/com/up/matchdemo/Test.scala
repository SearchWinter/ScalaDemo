

/**
 * @Description 模式匹配，可以类比java中的switch（）{case……}
 * @Date 2020/10/13  14:26
 **/
object Test {
  def main(args: Array[String]): Unit = {
    println(matchTest(3))
  }
  def matchTest(x:Int): String =x match{
    case 1 => "one"
    case 2 =>"two"
    case y:Int =>"Scala.Int"
    case _ => "many"
  }

}
