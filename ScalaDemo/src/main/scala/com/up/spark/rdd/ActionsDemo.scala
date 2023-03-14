package com.up.spark.rdd

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @Description RDD 常用ACTION示例
 * @Date 2020/8/28  11:15
 **/
object ActionsDemo {
  def main(args: Array[String]): Unit = {
    System.setProperty("hadoop.home.dir", "D:\\hadoop\\")

    val conf: SparkConf = new SparkConf().setMaster("local[2]").setAppName(s"${this.getClass.getSimpleName}")
    //.set("spark.hadoop.fs.defaultFS", "hdfs://master9102:8020")
    //      .setMaster("spark://172.16.9.141:7077")
    val sc: SparkContext = new SparkContext(conf)
    sc.setLogLevel("error")

    //测试RDD filter过后没有数据的情况
    val testRdd1: RDD[(String, Int)] = sc.makeRDD(Array(("a", 1), ("b", 2), ("c", 3)))
    val nullRdd: RDD[(String, Int)] = testRdd1.filter(x => x._2 > 10)
    nullRdd.foreach(x => println("输出nullRdd" + x))
    val testRdd2: RDD[(String, Int)] = sc.makeRDD(Array(("a", 1), ("b", 2), ("c", 3)))
    testRdd2.join(nullRdd).foreach(x => println("join null Rdd " + x))

    val l: Long = nullRdd.count()
    println("nullRdd count: " + l)
    val l1: Long = testRdd2.count()
    println("testRdd2 count: " + l1)

    //RDD两种构建方法   文件   内存
    //    val value: RDD[String] = sc.textFile("file:\\D:\\word.txt")
    val value: RDD[String] = sc.textFile("data/word.txt")
    val rdd1: RDD[Int] = sc.makeRDD(List(1, 2, 3, 3, 4, 5), 2)

    //创建一个空的RDD，数据类型为字符
    val emptyRdd: RDD[String] = sc.emptyRDD[String]

    val rdd2 = sc.makeRDD(List(3, 4, 5))
    val emptyRdd2: RDD[Int] = sc.emptyRDD[Int]
    emptyRdd2.union(rdd2).foreach(x=>println("emptyRdd:"+x))

    //组合两个rdd
    val value2: RDD[Int] = sc.union(rdd1, rdd2)
    value2.foreach(println)
    println("*************")
    //有一个rdd空/NULL，union的结果
    var rdd3 = sc.makeRDD(List(""));
    value.union(rdd3).foreach(println)
    println("******初始为NULL RDD*******")
    var aRdd: RDD[Int] = null
    aRdd = rdd1.union(rdd2)
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
    val reduce: RDD[(String, Int)] = prdd.reduceByKey((a, b) => a + b)

    println("*******groupByKey********")
    group.foreach(println)
    println("*******reduceByKey***********")
    reduce.foreach(println)

    //sortByKey  根据key值排序，true 升序
    //    val value1: RDD[(Int, String)] = sc.makeRDD(Array((1, "one"), (2, "two"), (1, "one2"), (3, "three"))).sortByKey(true,1)

    val i: Int = rdd1.reduce(_ + _)

    //join (K, V) and (K, W) -> (K, (V, W))   结果中的K,是两个RDD中都存在的K
    println("************join************")
    val value3: RDD[(String, String)] = sc.makeRDD(List("guid1", "guid2", "guid3", "guid1", "guid5")).map(x => (x, x.substring(1)))
    val value4: RDD[(String, String)] = sc.makeRDD(List("guid1", "guid2", "guid3", "guid4")).map(x => (x, x.substring(4)))
    val value5: RDD[(String, (String, String))] = value3.join(value4)
    value5.foreach(println)

    //leftOuterJoin  (k,v) and (k,w) -> (k, (v, Some(w))) or (k, (v, None)
    println("************leftOuterJoin***********")
    val leftOutJoinRdd: RDD[(String, (String, Option[String]))] = value3.leftOuterJoin(value4)
    leftOutJoinRdd.foreach(x => println(x))

    //fullOuterJoin  (k,v) and (k,w) -> (k, (Some(v)|none, Some(w)|none))  所有的key都有，对应的值 none和some 排列组合
    println("************fullOuterJoin***********")
    val fullOuterJoinRdd: RDD[(String, (Option[String], Option[String]))] = value3.fullOuterJoin(value4)
    fullOuterJoinRdd.foreach(println)

    //leftOuterJoin  (k,v) and (k,w) -> (k, (v, Some(w))) or (k, (v, None)
    println("************rightOuterJoin***********")
    val rightOuterJoin: RDD[(String, (Option[String], String))] = value3.rightOuterJoin(value4)
    rightOuterJoin.foreach(println)

    //union 两个rdd的类型要一致
    println("********union*********")
    val value6: RDD[(String, String)] = value3.union(value4)
    value6.foreach(println)
    //    value1.foreach(println)

    println("********mapPartitions*********")
    //mapPartitions:针对每一个分区来操作[map方法针对每一元素都会执行一个，但mapPartitions只针对一个分区执行一次]分区遍历
    val list = sc.makeRDD(1 to 10)
    val value7: RDD[Int] = list.mapPartitions((datas: Iterator[Int]) => {
      datas.map(x => x * 2)
    })
    value7.foreach(println)

    val coRdd1 = sc.makeRDD(Array((1, "a"), (2, "b"), (3, "C")))
    val coRdd2 = sc.makeRDD(Array((1, 4), (2, 5), (3, 6)))
    val value8: RDD[(Int, (Iterable[String], Iterable[Int]))] = coRdd1.cogroup(coRdd2)


    println("********combineByKey*********")
    var scores = Array(("lucy", 89), ("jack", 77), ("lucy", 100), ("james", 65), ("jack", 99), ("james", 44))
    val input: RDD[(String, Int)] = sc.makeRDD(scores)
    val value9: RDD[(String, (Int, Int))] = input.combineByKey((v) => (v, 1),
      (acc: (Int, Int), v) => (acc._1 + v, acc._2 + 1),
      (acc1: (Int, Int), acc2: (Int, Int)) => (acc1._1 + acc2._1, acc1._2 + acc2._2)
    )
    value9.foreach(println)


    sc.stop()
  }
}
