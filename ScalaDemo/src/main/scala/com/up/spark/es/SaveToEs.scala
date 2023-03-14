package com.up.spark.es

import org.apache.spark.{SparkConf, SparkContext}
import org.elasticsearch.spark._

/**
 * @Description es-spark简单示例
 *             https://www.elastic.co/guide/en/elasticsearch/hadoop/7.11/spark.html#spark-write
 * @Date 2023/3/13  16:43
 **/

object SaveToEs {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf()
      .setAppName("SaveToEs")
      .setMaster("local[*]")
      .set("es.nodes", "172.16.8.156")
      .set("es.port", "9200")
      .set("es.nodes.wan.only", "true")
      .set("es.batch.size.bytes", "1024000")
      .set("es.batch.size.entries", "20000")
      .set("es.batch.write.refresh", "false")
      .set("es.batch.write.retry.count", "50")
      .set("es.batch.write.retry.wait", "500s")
      .set("es.http.timeout", "5m")
      .set("es.http.retries", "50")
      .set("es.nodes.wan.only", "false")
      .set("es.action.heart.beat.lead", "50s")
      .set("es.index.auto.create", "true")

    val sparkContext = new SparkContext(conf)

    //官网示例
    val numbers = Map("one" -> 1, "two" -> 2, "three" -> 3)
    val airports = Map("arrival" -> "Otopeni", "SFO" -> "San Fran")
    sparkContext.makeRDD(Seq(numbers, airports)).saveToEs("spark/docs")


    sparkContext.stop()

  }

}
