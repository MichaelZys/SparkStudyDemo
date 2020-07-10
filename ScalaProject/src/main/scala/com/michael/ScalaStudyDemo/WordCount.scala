package com.michael.ScalaStudyDemo

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, sql}
import org.apache.spark.sql.SparkSession

object WordCount {


  def main(args: Array[String]): Unit = {

    //    val conf = new SparkConf

    val spark = SparkSession
      .builder().appName("wordcount").master("local[1]")
      //        .config("spark.executor.heartbeatInterval","119")
      //      .config(conf)
      .enableHiveSupport()
      .getOrCreate()

    import spark.implicits._


    val rdd = spark.sparkContext.makeRDD(Array("Hello word", "Hello scala"))

    val mapRDD = rdd.flatMap(x => x.split(" ")).map(x => (x, 1)).reduceByKey((x, y) => x + y)

    mapRDD.collect().foreach(println)

    spark.stop()
  }

}


