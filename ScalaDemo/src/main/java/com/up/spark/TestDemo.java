package com.up.spark;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;

import java.util.List;
/**
 * @Description 使用java语言编写spark
 * @Date 2020/9/10  14:44
 **/
public class TestDemo {
    public static void main(String[] args) {
        SparkConf sparkConf = new SparkConf().setMaster("local[*]").setAppName("filterDemo");

        JavaSparkContext javaSparkContext = new JavaSparkContext(sparkConf);
        JavaRDD<String> javaRDD = javaSparkContext.textFile("data/filterDemo.txt",1);
        javaSparkContext.setLogLevel("ERROR");

        //没有输出所有数据的方法，只能输出一部分
        List<String> take = javaRDD.take(10);
        System.out.println(take);

        FilterDemo filterDemo = new FilterDemo();
        JavaRDD<String> filter = javaRDD.filter(new Function<String, Boolean>() {
            @Override
            public Boolean call(String v1) throws Exception {
                return v1.length()>5;
            }
        });

        System.out.println(filter.take(10));
        javaSparkContext.close();
    }
}
