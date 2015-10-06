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
    s.daylow shouldBe a [java.lang.Double]
    s.dayhigh shouldBe a [java.lang.Double]
    s.movingav50day shouldBe a [java.lang.Double]
    s.marketcap shouldBe a [java.lang.Double]
  }
}
