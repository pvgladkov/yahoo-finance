package cc.p2k.yahoo.finance

import org.scalatest._
import org.scalatest.Matchers._

class ApiTest extends FunSuite {

  test("apple") {

    val s = Stock("aapl")
    s.price shouldBe a [java.lang.Double]
    s.volume shouldBe a [java.lang.Integer]
    s.pe shouldBe a [java.lang.Double]
    s.eps shouldBe a [java.lang.Double]
    s.week52low shouldBe a [java.lang.Double]
    s.week52high shouldBe a [java.lang.Double]
    s.dayLow shouldBe a [java.lang.Double]
    s.dayHigh shouldBe a [java.lang.Double]
    s.movingAv50day shouldBe a [java.lang.Double]
    s.marketCap shouldBe a [java.lang.Double]
  }
}
