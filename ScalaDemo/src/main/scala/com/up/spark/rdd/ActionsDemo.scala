package com.up.spark.rdd

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}
import org.testng.annotations.Test

/**
 * @Description RDD 常用ACTION示例
 * @Date 2020/8/28  11:15
 **/
object ActionsDemo {
  def main(args: Array[String]): Unit = {
    System.setProperty("hadoop.home.dir","D:\\hadoop\\")

    val conf: SparkConf = new SparkConf().setMaster("local[2]").setAppName(s"${this.getClass.getSimpleName}")
    val sc: SparkContext = new SparkContext(conf)
    sc.setLogLevel("error")

    //RDD两种构建方法   文件   内存
//    val value: RDD[String] = sc.textFile("file:\\D:\\word.txt")
    val value: RDD[String] = sc.textFile("data/word.txt")
    val rdd1: RDD[Int] = sc.makeRDD(List(1, 2, 3,3,4,5),2)
    val rdd2 = sc.makeRDD(List(3, 4, 5))

    //组合两个rdd
    val value2: RDD[Int] = sc.union(rdd1, rdd2)
    value2.foreach(println)
    println("*************")
    //有一个rdd空/NULL，union的结果
    var rdd3=sc.makeRDD(List(""));
    value.union(rdd3).foreach(println)
    println("******初始为NULL RDD*******")
    var aRdd:RDD[Int]=null
    aRdd=rdd1.union(rdd2)
    aRdd.foreach(println)

    //保留符合条件的元素
    println("******filter*******")
    val filterRDD: RDD[Int] = rdd1.filter(x => x != 1)
    filterRDD.foreach(println)

    //去重
//    val value1: RDD[Int] = rdd1.distinct()

    //去掉rdd1中和rdd2相同的元素
//    val value1: RDD[Int] = rdd1.subtract(rdd2)

    //分组，按照传入函数的返回值进行分组,将相同的key对应的值放到一个迭代器中
    val value1: RDD[(Int, Iterable[Int])] = rdd1.groupBy(_ % 2)
    /*output
    (0,CompactBuffer(2, 4))
    (1,CompactBuffer(1, 3, 3, 5))*/

    //对于k-v  groupByKey和reduceByKey的区别
    val strings: Array[String] = Array("one", "two", "three", "three")
    val prdd: RDD[(String, Int)] = sc.makeRDD(strings).map((_, 1))

    val group: RDD[(String, Iterable[Int])] = prdd.groupByKey()
    val reduce: RDD[(String, Int)] = prdd.reduceByKey((a,b)=>a+b)

    println("*******groupByKey********")
    group.foreach(println)
    println("*******reduceByKey***********")
    reduce.foreach(println)

    //sortByKey  根据key值排序，true 升序
//    val value1: RDD[(Int, String)] = sc.makeRDD(Array((1, "one"), (2, "two"), (1, "one2"), (3, "three"))).sortByKey(true,1)

    val i: Int = rdd1.reduce(_ + _)

    //join (K, V) and (K, W) -> (K, (V, W))   结果中的K,是两个RDD中都存在的K
    println("************join************")
    val value3: RDD[(String, String)] = sc.makeRDD(List("guid1", "guid2", "guid3")).map(x => (x, x.substring(1)))
    val value4: RDD[(String, String)] = sc.makeRDD(List("guid1", "guid2", "guid3","guid4")).map(x => (x, x.substring(4)))
    val value5: RDD[(String, (String, String))] = value3.join(value4)
    value5.foreach(println)

    //union 两个rdd的类型要一致
    println("********union*********")
    val value6: RDD[(String, String)] = value3.union(value4)
    value6.foreach(println)
//    value1.foreach(println)

    sc.stop()
  }
}
