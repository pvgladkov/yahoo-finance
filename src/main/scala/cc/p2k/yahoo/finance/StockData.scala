package cc.p2k.yahoo.finance


trait StockData {

  def getInt(value: String): BigInt = {
    if(value.toString.trim.matches("N/A")) {
      return 0
    }
    BigInt(value)
  }

  def getDouble(value: String): Double = {
    if(value.toString.trim.matches("N/A")) {
      return 0.0
    }
    value.toDouble
  }
}

class WrongIdException(msg: String) extends Throwable(msg)
