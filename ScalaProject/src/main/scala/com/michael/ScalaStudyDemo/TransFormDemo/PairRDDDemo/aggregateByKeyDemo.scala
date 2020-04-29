package com.michael.ScalaStudyDemo.TransFormDemo.PairRDDDemo

import com.michael.ScalaStudyDemo.CommonFunction.SparkInit

object aggregateByKeyDemo {

  def main(args: Array[String]): Unit = {

    val spark = SparkInit.getSparkSession()
    val pairRDD = spark.sparkContext.parallelize(List(("a",3),("a",2),("c",4),("b",3),("c",6),("c",8)), 2)
//    pairRDD.glom().foreach(x=>x.foreach(println))
    //分区内求最大, 分区间相加.
    val res = pairRDD.aggregateByKey(0)(math.max(_,_), _+_)
    res.foreach(println)


    spark.stop()
  }

}
