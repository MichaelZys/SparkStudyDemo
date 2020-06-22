package com.michael.Demo

import com.michael.ScalaStudyDemo.CommonFunction.SparkInit

object flatMapDemo {

  def main(args: Array[String]): Unit = {


    val spark = SparkInit.getSparkSession()
    import spark.implicits._

    val rdd = spark.sparkContext.makeRDD(Array(("michael", 17)))

    //    rdd.collect().foreach(println)
    //    val rdd2 = rdd.map(x=>(x._1+"aaa", x._2))

    val rdd2 = rdd.flatMap {
      x =>
        Seq(
          for (i <- 1 until 10) yield {
            (x._1 + i.toString, x._2)
          }
        )

    }


    rdd2.collect().foreach(println)

    //    rdd.flatMap()
  }

}
