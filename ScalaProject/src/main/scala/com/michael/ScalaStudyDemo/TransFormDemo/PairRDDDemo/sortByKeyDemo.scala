package com.michael.ScalaStudyDemo.TransFormDemo.PairRDDDemo

import com.michael.ScalaStudyDemo.CommonFunction.SparkInit

object sortByKeyDemo {

  def main(args: Array[String]): Unit = {

    val spark = SparkInit.getSparkSession()
    val pairRDD = spark.sparkContext.parallelize(List(("a",3),("a",2),("c",4),("b",3),("c",6),("c",8)), 2)

    // 这个貌似是区内有序
    val res = pairRDD.sortByKey(true)

    res.foreach(println)

    val res1 = pairRDD.sortByKey(false)

    res1.foreach(println)


    spark.stop()
  }

}
