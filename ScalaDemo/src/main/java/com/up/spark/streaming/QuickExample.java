package com.up.spark.streaming;

import org.apache.spark.SparkConf;
import org.apache.spark.streaming.Durations;
import org.apache.spark.streaming.api.java.JavaDStream;
import org.apache.spark.streaming.api.java.JavaPairDStream;
import org.apache.spark.streaming.api.java.JavaReceiverInputDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;
import scala.Tuple2;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by anjunli on  2021/3/2
 * http://spark.apache.org/docs/2.2.0/streaming-programming-guide.html#a-quick-example
 **/
public class QuickExample {
    public static void main(String[] args) {
        //创建一个StreamingContext
        SparkConf sparkConf = new SparkConf().setMaster("local[2]").setAppName("NewWorkWordCount");
        JavaStreamingContext jssc = new JavaStreamingContext(sparkConf, Durations.seconds(5));

        //创建一个DStream
        JavaReceiverInputDStream<String> lines = jssc.socketTextStream("172.16.8.137", 9999);

        JavaDStream<String> words = lines.flatMap(x -> Arrays.asList(x.split(" ")).iterator());
        words.print();

        JavaPairDStream<String,Integer> pairs = words.mapToPair(x -> new Tuple2(x, 1));
        JavaPairDStream<String, Integer> wordCounts = pairs.reduceByKey((a, b) -> a + b);

        wordCounts.print();

        jssc.start();
        try {
            jssc.awaitTermination();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
