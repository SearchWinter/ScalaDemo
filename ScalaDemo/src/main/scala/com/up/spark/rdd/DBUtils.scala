package com.up.spark.rdd

import java.sql.{Connection, DriverManager}

/**
 * @Description TODO
 * @Date 2021/6/9  17:02
 **/
object DBUtils {

  def getConnection():Connection={
    Class.forName("com.mysql.jdbc.Driver");
    val connection = DriverManager.getConnection("jdbc:mysql://172.16.9.251:3306/db_base_stat?rewriteBatchedStatements=true&useUnicode=true&characterEncoding=UTF-8", "taf", "taf2015");
    connection
  }
}
