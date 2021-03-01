package com.up.spark;

import java.io.Serializable;

import org.apache.spark.api.java.function.Function;

/**
 * @Description com.up.spark function的使用方法
 * @Date 2020/9/10  14:40
 **/
//验证filter方法
    /** spark中，filter方法时保留满足条件的值*/
    class FilterDemo implements Function<String,Boolean>, Serializable{
        public FilterDemo() {
        }
        @Override
        public Boolean call(String s) throws Exception {
            if (s.length()>5){
                return true;
            }
            return false;
        }
    }
