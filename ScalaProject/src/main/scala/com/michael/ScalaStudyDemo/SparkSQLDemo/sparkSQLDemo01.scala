package com.michael.ScalaStudyDemo.SparkSQLDemo

import com.michael.ScalaStudyDemo.CommonFunction.SparkInit

case class Persion(name:String, age:Int)

object sparkSQLDemo01 {



  def main(args: Array[String]): Unit = {


    val spark = SparkInit.getSparkSession()
    import spark.implicits._

    val rdd = spark.sparkContext.makeRDD(Array(("michael",17),("nika",18),("gaga",19)))


    val df = rdd.toDF("name","age")
//


    val ds = df.as[Persion]

    val df1 = ds.toDF()

    df1.createOrReplaceTempView("student")


//    spark.createDataFrame(Array(("michael",17),("nika",18),("gaga",19)))

//
//    df.printSchema()
//
//    val rdd1 = df.rdd
//
//    rdd1
//
    val df2 = spark.sql("select * from student")

    df2.collect()


//    val ds = rdd.map(x => {
//      Persion(x._1, x._2)
//    }).toDS()
//
//
//
//    ds.show()

    spark.stop()
  }


}
