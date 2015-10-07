package cc.p2k.yahoo.finance

import scala.io.Source

case class Stock(symbol: String, price: Double, volume: Int, pe: Double, eps: Double, week52low: Double,
                 week52high: Double, dayLow: Double, dayHigh: Double, movingAv50day: Double, marketCap: Double)


object Stock {

  def getInt(value: String): Int = {
    if(value.toString.trim.matches("N/A")) {
      return 0
    }
    value.toInt
  }

  def getDouble(value: String): Double = {
    if(value.toString.trim.matches("N/A")) {
      return 0.0
    }
    value.toDouble
  }

  def apply(symbol: String) : Stock = {
    val sym = symbol.toUpperCase

    val s = Source.fromURL("http://finance.yahoo.com/d/quotes.csv?s="+ symbol + "&f=l1vr2ejkghm3j3").mkString
    val info = s.split(",")

    val price = getDouble(info(0))
    val volume = getInt(info(1))
    val pe = getDouble(info(2))
    val eps = getDouble(info(3))
    val week52low = getDouble(info(4))
    val week52high = getDouble(info(5))
    val dayLow = getDouble(info(6))
    val dayHigh = getDouble(info(7))
    val movingAv50day = getDouble(info(8))
    val marketCap = getDouble(info(9))

    new Stock(sym, price, volume, pe, eps, week52low, week52high, dayLow, dayHigh, movingAv50day, marketCap)
  }
}