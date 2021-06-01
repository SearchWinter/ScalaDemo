package com.up.spark.rdd

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}
import org.testng.annotations.{BeforeClass, Test}

/**
 * @Description mapValues() 示例
 * @Date 2021/3/2  19:00
 **/
object KvTransDemo {

  def main(args: Array[String]): Unit = {
    val sparkConf=new SparkConf().setMaster("local[*]").setAppName("Demo")
    val sparkContext=new SparkContext(sparkConf)

    val rdd: RDD[String] = sparkContext.parallelize(List("dog", "tiger", "lion", "cat", "panda"))
    val rdd2: RDD[(String, Int)] = rdd.map(x => new Tuple2(x, x.length))
    rdd2.mapValues(x=>x+1).collect().foreach(println)
  }
}
@Test
class CrawTest{
  @Test
  def hello(): Unit ={
    print("scala test")
  }
}

