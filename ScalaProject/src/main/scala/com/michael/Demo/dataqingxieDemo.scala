package com.michael.Demo

import com.michael.ScalaStudyDemo.CommonFunction.SparkInit

object dataqingxieDemo {

  case class Persion(id:String)
  def main(args: Array[String]): Unit = {

    val spark = SparkInit.getSparkSession()
    import spark.implicits._

//    val rdd = spark.sparkContext.makeRDD(Array(1, 2, 3, 1)).map {
//      x => Persion(x.toString)
//    }
//    rdd.toDF().createOrReplaceTempView("ddd")

    val df = spark.sql("select id from dwd_sftm.dwd_order_dt")
//    val df = spark.sql("select id from ddd")
    val rdd1 = df.sample(false,0.4).rdd
//
    rdd1.map(x=>(x,1)).reduceByKey((x,y)=>x+y).sortBy(x=>x._2, false).take(100).foreach(println)

    spark.stop()

  }

}
