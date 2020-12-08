package com.up.spark

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @Description com.up.spark wordCount
 * @Date 2020/8/27  9:52
 **/
object WordCount {
  def main(args: Array[String]): Unit = {

    System.setProperty("hadoop.home.dir","D:\\hadoop\\")
    val conf = new SparkConf().setMaster("local[*]").setAppName("WordCount")
    val sc = new SparkContext(conf)

    sc.setLogLevel("WARN")
    val lines = sc.textFile("data/word.txt")    //项目中的文件
//    val lines: RDD[String] = sc.textFile("file:\\E:\\word.txt")       //本地文件

    val tuples: RDD[(String, Int)] = lines.flatMap(lines => lines.split(" "))
      .map(word => (word, 1))
      .reduceByKey((a, b) => a + b)

//    val tuples2: RDD[(String, Int)] = lines.flatMap(_.split(" ")).map((_, 1)).reduceByKey(_ + _)
//    tuples2.foreach(println)
    tuples.foreach(println)
    println("******")
    //指定输出的总行数
    tuples.take(1).foreach(print)
    sc.stop()
  }
}
