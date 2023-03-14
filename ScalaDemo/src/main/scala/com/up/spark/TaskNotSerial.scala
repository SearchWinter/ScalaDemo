package com.up.spark

import org.apache.spark.{SparkConf, SparkContext}

/**
 * @Description TODO
 * @Date 2023/2/8  16:49
 **/
class TaskNotSerial(conf:String) extends Serializable {
  val list = List("a.com", "www.b.com", "a.cn", "a.com.cn", "a.org");
  private val sparkConf = new SparkConf().setAppName("AppName").setMaster("local[*]")
  private val sc = new SparkContext(sparkConf);
  val rdd = sc.parallelize(list);

  private val rootDomain = conf

  def getResult(): Array[(String)] = {
    val result = rdd.filter(item => item.contains(rootDomain))
    result.foreach(println)
    result.take(result.count().toInt)
  }
}

object Test{
  def main(args: Array[String]): Unit = {
    val taskNotSerial = new TaskNotSerial("a")
    taskNotSerial.getResult()
  }
}
