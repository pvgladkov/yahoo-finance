package cc.p2k.yahoo.finance


case class Stock(symbol: String, price: Double, volume: Int, pe: Double, eps: Double, week52low: Double,
                 week52high: Double, daylow: Double, dayhigh: Double, movingav50day: Double, marketcap: Double);
