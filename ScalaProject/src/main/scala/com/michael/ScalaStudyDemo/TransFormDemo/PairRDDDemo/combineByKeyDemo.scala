package com.michael.ScalaStudyDemo.TransFormDemo.PairRDDDemo

import com.michael.ScalaStudyDemo.CommonFunction.SparkInit

object combineByKeyDemo {

  def main(args: Array[String]): Unit = {

    val spark = SparkInit.getSparkSession()
    val pairRDD = spark.sparkContext.parallelize(List(("a",3),("a",2),("c",4),("b",3),("c",6),("c",8)), 2)

    val res = pairRDD.combineByKey((_,1),(acc:(Int,Int), v)=>(acc._1+v, acc._2+1),(acc1:(Int,Int),acc2:(Int,Int))=>(acc1._1+acc2._1, acc1._2+acc2._2))

    val finalres = res.map {
      case (key, value) => (key, value._1 / value._2.toDouble)
    }

    finalres.foreach(println)


    spark.stop()
  }

}
