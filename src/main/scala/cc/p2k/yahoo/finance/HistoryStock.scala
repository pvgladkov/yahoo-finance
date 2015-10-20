package cc.p2k.yahoo.finance

import scala.io.Source
import com.github.nscala_time.time.Imports._

case class HistoryStock(date: String, open: Double, High: Double, low: Double,
                        close: Double, volume: Int, adjClose: Double)

object HistoryStock extends StockData {

  def apply(symbol: String, from: String, to: String, interval: String): Map[String, HistoryStock] = {

    val start = DateTime.parse(from)
    val end = DateTime.parse(to)

    val url = "http://ichart.finance.yahoo.com/table.csv?s=%s&a=%d&b=%d&c=%d&d=%d&e=%d&f=%d&g=%s".format(
      symbol, start.getMonthOfYear - 1, start.getDayOfMonth, start.getYear,
      end.getMonthOfYear - 1, end.getDayOfMonth, end.getYear, interval)

    val s = Source.fromURL(url)

    val data = s.getLines().drop(1).map( s => {
      val a = s.split(",")
      (a(0), new HistoryStock(a(0), getDouble(a(1)), getDouble(a(2)),
        getDouble(a(3)), getDouble(a(4)), getInt(a(5)), getDouble(a(6))))
    })

    data.toMap
  }
}
