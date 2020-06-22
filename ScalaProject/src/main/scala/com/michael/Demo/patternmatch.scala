package com.michael.Demo

import javax.rmi.CORBA.Util

object patternmatch {

  def main(args: Array[String]): Unit = {

    var a: List[String] = scala.collection.immutable.List(("--class org.com.bala"), ("--name test"))

    //    a+=("--class org.com.bala")
    //    a+=("--name test")

    a.foreach(println)
    //
    while (!a.isEmpty) {
      a match {
        case ("--name") :: value :: tail =>
          println(value)
          println(tail)
      }
    }




    //    a match {
    //      case ("--name") :: value :: tail =>
    //        println(value)
    //        println(tail)
    //    }
  }

}
