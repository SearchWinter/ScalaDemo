package com.up.spark.rdd

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @Description TODO
 * @Date 2021/7/22  18:46
 **/
object ImplicitDemo {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setAppName("ImplicitDemo").setMaster("local[*]")
    val sc = new SparkContext(conf)
    sc.setLogLevel("ERROR")

    val rdd: RDD[String] = sc.makeRDD(List("demo", "test", "implicit"))
    val rdd2: RDD[(String,Long)] =rdd
    rdd2.foreach(println)
  }

  implicit def trans(rdd:RDD[String]):RDD[(String, Long)]={
    rdd.map(x=>{
      (x,1L)
    })
  }
}
