package com.up.spark.df

import java.util

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.{DataFrame, Dataset, Row, SparkSession}
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark

/**
 * @Description Spark SQL方法
 * 验证spark sql缓存表对程序执行速度的影响
 * @Date 2021/8/6  11:25
 **/
case class LogRecord(ip:String,time:String,uid:String,sType:String)
object SparkSqlCache {
  def main(args: Array[String]): Unit = {
    val start: Long = System.currentTimeMillis()

    val conf: SparkConf = new SparkConf()
      .setAppName("SqlCache")
      .setMaster("local[*]")
      .set("spark.sql.warehouse.dir","D:\\sparkSQL")
      .set("spark.sql.shuffle.partitions","20")
    val sparkSession: SparkSession = SparkSession.builder()
      .config(conf)
      .getOrCreate()
    val sourceRdd: Dataset[String] = sparkSession.read.textFile("data/Base.HttpLogServer_loginloginlogin_20210730.log")
    import sparkSession.implicits._
    val recordDF: Dataset[LogRecord] = sourceRdd.map(x => {
      val arrs: Array[String] = x.split("\\|", -1)
      LogRecord(arrs(0), arrs(1), arrs(3), arrs(5))
    })

    recordDF.createOrReplaceTempView("t_zgb")
    //缓存表 web界面->Storage
    sparkSession.sql("cache table t_zgb")
    val sql="select * from t_zgb"
    val dataFrame: DataFrame = sparkSession.sql(sql)
    val t1: Long = System.currentTimeMillis()
    val list: util.List[Row] = dataFrame.collectAsList()
    println("execute sql1 time:"+ (System.currentTimeMillis()-t1))
    println(list.size())

    val t3: Long = System.currentTimeMillis()
    val sql2 ="select distinct uid from t_zgb where uid like 'zgb00004%'"
    val dataFrame1: DataFrame = sparkSession.sql(sql2)
    val list1: util.List[Row] = dataFrame1.collectAsList()
    println("execute sql2 time:"+ (System.currentTimeMillis()-t3))
    println(list1.size())

    println("execute total time: "+(System.currentTimeMillis()-start) )

  }

}
