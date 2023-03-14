package com.up.spark.rdd

/**
 * @Description
 *             RDD的函数传递
 *             https://blog.csdn.net/wx1528159409/article/details/87606416
 * @Date 2020/9/30  18:35
 **/
package com.kevin.spark.core

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.RDD

object Spark03_Search {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("Application")

    //构建Spark上下文
    val sc: SparkContext = new SparkContext(conf)

    //创建RDD
    val rdd = sc.makeRDD(Array("abc", "bcd", "cde"))

    //创建需要封装的Search对象
    val s = new Search("b")
    val newRDD: RDD[String] = s.getMatch1(rdd)
    newRDD.collect().foreach(println)

    //释放资源
    sc.stop()
  }
}

//构建查询类
class Search(query: String) extends Serializable {
  //包含字符串query的数据isMatch
  def isMatch(s: String) = {
    s.contains(query)
  }

  //过滤出包含字符串的RDD
  def getMatch1(rdd: RDD[String]) = {
    rdd.filter(isMatch)
  }

  //过滤出包含字符串的RDD
  def getMatch2(rdd: RDD[String]) = {
    rdd.filter(x => x.contains(query))
  }
}