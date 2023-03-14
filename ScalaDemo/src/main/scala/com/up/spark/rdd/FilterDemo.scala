/*
package com.up.spark.rdd

import org.apache.spark.rdd.RDD
import org.apache.spark.storage.StorageLevel
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @Description TODO
 * @Date 2020/9/30  17:38
 **/
object FilterDemo {
  def main(args: Array[String]): Unit = {
    System.setProperty("hadoop.home.dir", "D:\\hadoop\\")

    val conf: SparkConf = new SparkConf().setMaster("local[2]").setAppName(s"${this.getClass.getSimpleName}")
    val sc: SparkContext = new SparkContext(conf)

    val rdd1: RDD[Int] = sc.makeRDD(List(1, 2, 3, 3, 4, 5)).persist(StorageLevel.DISK_ONLY)
    val rdd2: RDD[Int] = sc.makeRDD(List(2,2,5,6,7,7,8,9)).persist(StorageLevel.DISK_ONLY)

    val demo = new func()
    val result: RDD[Int] = rdd1.filter(
      (new func().exist(sc,2,rdd1))
    )
    result.foreach(println)
  }

  }

class func(){
  def exist(sc: SparkContext, str: Int, rdd: RDD[Int]): Long = {
    val rdd1: RDD[Int] = sc.makeRDD(List(str))
    val rdd3: RDD[Int] = rdd1.intersection(rdd)
    rdd3.count()
  }
}

*/
