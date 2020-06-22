package com.michael.ScalaStudyDemo.TransFormDemo.PairRDDDemo.RDDDemo

import com.michael.ScalaStudyDemo.CommonFunction.SparkInit

object reduceDemo {

  def main(args: Array[String]): Unit = {

    // Reduce函数, 返回的是泛型. 对于单值来说, 对所有数据操作func,
    //对于多值函数来说, 相同位置进行相同操作. x._1+y._1, x._2+y._2. 类似
    val spark = SparkInit.getSparkSession()
    val rdd = spark.sparkContext.parallelize(1 to 10, 2)
    //    下面的foreach, 其实是scala的foreach
    //    rdd.collect().foreach(println)
    //    下面的foreach, 是RDD的foreach
    //    rdd.foreach(println)
    //    println(rdd.partitions.size)
    //    rdd.glom().collect().foreach(println)
    println(rdd.reduce(_+_))

    val rdd1 = spark.sparkContext.makeRDD(Array(("a",1),("a",3),("c",3),("d",5)))

    rdd.collect()
    println(rdd1.reduce((x, y) => (x._1 + y._1, x._2 + y._2)))

  }

}
