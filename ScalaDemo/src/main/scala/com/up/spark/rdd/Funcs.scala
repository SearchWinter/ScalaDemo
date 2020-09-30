package com.up.spark.rdd

import org.apache.spark.SparkContext
import org.apache.spark.rdd.RDD

/**
 * @Description TODO
 * @Date 2020/9/30  17:54
 **/
class Funcs extends Serializable {
  def exist(sc:SparkContext,str:Int,rdd:RDD[Int]):Long={
    val rdd1: RDD[Int] = sc.makeRDD(List(str))
    val rdd3: RDD[Int] = rdd1.intersection(rdd)
    rdd3.count()
  }
}
