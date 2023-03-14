package com.up.spark;

import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.storage.StorageLevel;

import java.util.Arrays;
import java.util.List;

/**
 * Created by anjunli on  2021/3/1
 * 体会RDD persist()方法的作用: 将计算的中间结果保存到内存或磁盘中
 * http://spark.apache.org/docs/2.2.0/rdd-programming-guide.html#rdd-persistence
 * RDD的懒加载模式：执行Action后才会开始计算
 * http://spark.apache.org/docs/2.2.0/rdd-programming-guide.html#rdd-operations
 **/
public class PersistDemo {
    public static void main(String[] args) {
        SparkConf sparkConf = new SparkConf().setAppName("spark-test").setMaster("local[*]");
        SparkContext sparkContext = new SparkContext(sparkConf);
        sparkContext.setLogLevel("error");
        JavaSparkContext javaSparkContext = new JavaSparkContext(sparkContext);

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        JavaRDD<Integer> javaRDD = javaSparkContext.parallelize(list);

        JavaRDD<Integer> filter = javaRDD.map(x -> x * 2).filter(x -> {
            System.out.println("filter:"+x);
            return x > 5;
        })
        .persist(StorageLevel.MEMORY_ONLY());

        System.out.println("******1*****");
        filter.collect().forEach(System.out::println);

        System.out.println("*******2*********");
        filter.collect().forEach(System.out::println);
    }
}
