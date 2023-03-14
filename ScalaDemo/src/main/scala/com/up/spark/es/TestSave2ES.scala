package com.up.spark.es


import org.apache.spark.{SparkConf, SparkContext}
import org.elasticsearch.spark._
import org.elasticsearch.spark.rdd.EsSpark

case class Test(name: String, age: String)

/**
 * 使用样例类将数据写入es
 * */
object TestSave2ES {
  def appName = "SaveToEs"

  def esIndexName = "test_20230313"

  def main(args: Array[String]) {
    val sparkConf = new SparkConf()
      .setAppName(appName)
      .setMaster("local[2]")
      .set("es.nodes", "172.16.8.156")
      .set("es.http.timeout", "10m")
      .set("es.batch.size.entries", "1")
    val sc = new SparkContext(sparkConf)
    val seq = Seq("foo2");
    val rdd = sc.parallelize(seq, 1).map(x => Test(x, "vJYe34YBlpZLAj1QE8rj22"))
    rdd.foreach(println)
    //方法1
    EsSpark.saveToEs(rdd, s"${esIndexName}/docs")
    //方法2
    //rdd.saveToEs("spark/docs")
    sc.stop()
  }

}