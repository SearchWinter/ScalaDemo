package com.up.spark.rdd

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @Description
 * 一个stage的task的数量是由输入文件的切片个数来决定的， 如果修改了RDD的分区数，task数量也会同步修改
 * @Date 2021/8/9  13:54
 **/
object TaskNum {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("TaskNum").setMaster("local[*]")
    val sc = new SparkContext(conf)

    //分区数4
    val sourceRdd: RDD[String] = sc.parallelize(Seq("spark", "job", "stage", "task"))
    println(sourceRdd.getNumPartitions)

    val sourceRdd2: RDD[String] = sc.parallelize(Seq("spark2", "job2", "stage2", "task2")).repartition(2)
    println(sourceRdd2.getNumPartitions)

    //union操作后得到的RDD,分区数是两个RDD分区数之和
    println(sourceRdd.union(sourceRdd2).getNumPartitions)

  }

}
