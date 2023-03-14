package com.up.circulation

import org.testng.annotations.Test

/**
 * @Description TODO
 * @Date 2020/6/29  11:44
 **/
object If {
  def main(args:Array[String]): Unit ={
    println(ifDemo())

    val str: String = demo(10, 10)
    println(str)
  }

  def ifDemo():Boolean ={
    val x=10
    val y=20
    if(x<20){
       true
    }else {
      false
    }
  }

  def demo(n:Int,startTimestamp:Int)= {
    var sql = "";
    if (n == 0) {
      sql =
        s"""select   t1.username ,count(*)  from t_new_sync_order  t1
      where  t1.otime >$startTimestamp and t1.otime <$startTimestamp +24*60*60*1000
      and t1.paytotal >100
      and t1.status in (220,80)
      and  (1=1 or ?=? ) group by t1.username"""
    } else {
      sql =
        s"""select   t1.username ,count(*)  from t_new_sync_order  t1
      where  t1.otime >$startTimestamp and t1.otime <$startTimestamp +24*60*60*1000*($n+1)
      and t1.paytotal >100
      and t1.status in (220,80)
      and  (1=1 or ?=? ) group by t1.username"""
    }
    sql
  }
}
