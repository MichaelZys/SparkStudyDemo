package com.michael.ScalaStudyDemo.TransFormDemo.PairRDDDemo

import com.michael.ScalaStudyDemo.CommonFunction.SparkInit

object foldByKeyDemo {

  def main(args: Array[String]): Unit = {

    val spark = SparkInit.getSparkSession()
    val pairRDD = spark.sparkContext.parallelize(List(("a",3),("a",2),("c",4),("b",3),("c",6),("c",8)), 2)
//    pairRDD.glom().foreach(x=>x.foreach(println))

    //分区内和分区间都是相加
    val res = pairRDD.foldByKey(0)(_+_)
    res.foreach(println)


    spark.stop()
  }

}
