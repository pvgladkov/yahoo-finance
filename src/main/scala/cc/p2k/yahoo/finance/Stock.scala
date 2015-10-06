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
    var price = 0.0
    var volume = 0
    var pe = 0.0
    var eps = 0.0
    var week52low = 0.0
    var week52high = 0.0
    var dayLow = 0.0
    var dayHigh = 0.0
    var movingAv50day = 0.0
    var marketCap = 0.0

    val s = Source.fromURL("http://finance.yahoo.com/d/quotes.csv?s="+ symbol + "&f=l1vr2ejkghm3j3").mkString
    val info = s.split(",")

    price = getDouble(info(0))
    volume = getInt(info(1))
    pe = getDouble(info(2))
    eps = getDouble(info(3))
    week52low = getDouble(info(4))
    week52high = getDouble(info(5))
    dayLow = getDouble(info(6))
    dayHigh = getDouble(info(7))
    movingAv50day = getDouble(info(8))
    marketCap = getDouble(info(9))

    new Stock(sym, price, volume, pe, eps, week52low, week52high, dayLow, dayHigh, movingAv50day, marketCap)
  }
}