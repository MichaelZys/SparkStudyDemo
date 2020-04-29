package com.michael.ScalaStudyDemo.TransFormDemo.PairRDDDemo.RDDDemo

import com.michael.ScalaStudyDemo.CommonFunction.SparkInit

/**
  * @author michael
  * @create 2020-04-27 22:57
  */
object RDDCreateDemo01 {
  def main(args: Array[String]): Unit = {

    val spark = SparkInit.getSparkSession()
    val rdd = spark.sparkContext.makeRDD(List(1,2,3,4))
    rdd.foreach(println)

  }

}
