package com.michael.ScalaStudyDemo.CommonFunction

import java.net.InetAddress

import org.apache.spark.{SparkConf, sql}
import org.apache.spark.sql.SparkSession


/**
  * @author michael
  * @create 2020-04-27 22:59
  */
class SparkInit {

}


object SparkInit{

//  def getSparkSession:SparkSession={
//
//
//
//  }

  def getSparkSession(): SparkSession ={

//    System.setProperty("HADOOP_USER_NAME", "hadoop")
//    System.setProperty("user.name", "root")

    val conf = new SparkConf

    conf.set("spark.sql.adaptive.enabled", "true")
    conf.set("spark.sql.adaptive.shuffle.targetPostShuffleInputSize", "128M")
    conf.set("spark.sql.adaptive.join.enabled", "true")
    conf.set("spark.sql.autoBroadcastJoinThreshold", "20971520")
    conf.set("spark.sql.warehouse.dir", "/warehouse/tablespace/managed/hive")
    conf.set("spark.debug.maxToStringFields", "300")
    conf.set("spark.app.name","the lowest level spark")
//    conf.set("hive.execution.engine", "mr")

    println(System.getProperty("os.name"))



    //如果运行在本地, 就是local[*]
    //
    if (System.getProperty("os.name") == "Windows 10") {
      conf.set("spark.master", "local[*]")
    }
    else {
      //      conf.set("spark.master","local[*]")
    }

//    println(InetAddress.getLocalHost.getHostName.contains("SMART"))
    //
    if (InetAddress.getLocalHost.getHostName.contains("SMART")) {
      conf.set("hive.metastore.uris", "thrift://10.10.17.11:9083")
    }
//    else if(InetAddress.getLocalHost.getHostName.contains("gaialab")){
      else{
      conf.set("hive.metastore.uris", "thrift://192.168.0.103:9083")
    }

    SparkSession
      .builder()
      .config(conf)
      .enableHiveSupport()
      .getOrCreate()
  }
}
