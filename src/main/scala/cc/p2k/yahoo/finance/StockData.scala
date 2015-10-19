package cc.p2k.yahoo.finance


trait StockData {

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
}
