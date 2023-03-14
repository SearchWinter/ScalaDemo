package com.up.spark.rdd

import java.sql.{Connection, DriverManager}

import org.apache.spark.rdd.JdbcRDD
import org.apache.spark.sql.SparkSession
import org.apache.spark.{SparkConf, SparkContext, sql}

/**
 * @Description 构造JdbcRDD时，各个参数的含义及用法
 * @Date 2021/6/9  16:57
 **/
object JdbcRddDemo {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf()
      .setAppName(this.getClass.getName)
      .setMaster("local[*]")
    val sc = new SparkContext(conf)
    sc.setLogLevel("error")

    //sql语句中必须有两个占位符
    val sql="select username from db_huxing.t_profile_user where (?=?)"
    // 带括号的是函数调用，直接执行函数；不带括号的是绑定事件，事件触发再执行。
    // _可以将方法转换为函数
    val jdbcRdd = new JdbcRDD(
      sc,
      DBUtils.getConnection _,
      sql,
      0,
      0,
      1,
      r => {
        r.getString("username")
      }
    )
    jdbcRdd.foreach(println)

  }

  def getConnection():Connection={
    Class.forName("com.mysql.jdbc.Driver");
    val connection = DriverManager.getConnection("jdbc:mysql://xxx.xxx.xxx.xxx:3306/db_base_stat?rewriteBatchedStatements=true&useUnicode=true&characterEncoding=UTF-8", "xxx", "xxx");
    connection
  }
}
