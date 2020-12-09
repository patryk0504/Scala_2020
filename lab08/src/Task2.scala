import java.awt.Taskbar.Feature

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent._
import scala.concurrent.duration._
import scala.util._
import math.{max, min}



object Task2 {
  def mapReduce(s: List[Int]): Future[(Int, Int)] = {
    val splitted = s.grouped(s.length / 10).toSeq // This splits list of Numbers into 10 sequences of numbers - it's first point from plan
    // TODO: Create sequence of features for each chunk, where each future will find tuple of (min, max) inside single chunk (map).
    val tmp = Future.sequence(
      splitted.map(
        x => Future[(Int,Int)]{(x.min,x.max)}
      )
    )
    // TODO: Combine results of all chunks to single tuple (min, max) - (reduce).


    tmp.map(x => x.foldLeft(Int.MaxValue,Int.MinValue){
      case (k,v) => (min(k._1,v._1), max(k._2,v._2))
    })

  }

  def main(args: Array[String]): Unit = {
    val rNumbers = List.fill(100)(Random.nextInt())

    println((rNumbers.min, rNumbers.max)) // You can check if the result is correct
    val r = mapReduce(rNumbers)

    r onComplete {
      case Success(res) => println(res) // Should be tuple: (MinNumber, MaxNumber)
    }
    Await.ready(r, Duration(10, SECONDS))
  }
}