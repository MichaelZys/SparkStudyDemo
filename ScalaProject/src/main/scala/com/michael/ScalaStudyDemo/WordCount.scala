package com.michael.ScalaStudyDemo

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, sql}
import org.apache.spark.sql.SparkSession

object WordCount {


  def main(args: Array[String]): Unit = {

//    val conf = new SparkConf

    val spark = SparkSession
      .builder().appName("wordcount").master("local[*]")
        .config("spark.executor.heartbeatInterval","119")
//      .config(conf)
      .enableHiveSupport()
      .getOrCreate()


    val rdd : RDD[String] = spark.sparkContext.makeRDD(Array("Hello word","Hello scala")

//
//    val pairRDD = rdd.flatMap(x=>x.split(" "))
//    val mapRDD = pairRDD.map(x=>(x,1))
//
//    val reduceRDD = mapRDD.reduceByKey(_+_)
//
//    reduceRDD.collect()

    rdd.flatMap(x=>x.split(" ")).map(x=>(x,1)).reduceByKey((x,y)=>x+y).collect().foreach(println)

    spark.stop()
  }

}


