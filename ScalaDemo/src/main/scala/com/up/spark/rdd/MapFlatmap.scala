package com.up.spark.rdd

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @Description TODO
 * @Date 2021/6/9  11:27
 **/
object MapFlatmap {
  def main(args: Array[String]): Unit = {
//    System.setProperty("hadoop.home.dir","D:\\hadoop\\")
    val conf: SparkConf = new SparkConf().setMaster("local[2]").setAppName(s"${this.getClass.getSimpleName}")
    val sc: SparkContext = new SparkContext(conf)
    sc.setLogLevel("error")

//  map()是将函数用于RDD中的每个元素，将返回值构成新的RDD。
//  flatmap()是将函数应用于RDD中的每个元素，将返回的迭代器的所有内容构成新的RDD
    val rdd: RDD[String] = sc.makeRDD(List("hello|scala", "hello|spark"))
    val value: RDD[Array[String]] = rdd.map(x => x.split("\\|"))
    value.foreach(println)
    val value1: RDD[String] = rdd.flatMap(x => x.split("\\|"))
    value1.foreach(println)
  }

}
/**
 * [Ljava.lang.String;@3435094a
 * [Ljava.lang.String;@2da08836
 * hello
 * spark
 * hello
 * scala
 * */
