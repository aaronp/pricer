package checkout

import org.scalatest.{Matchers, WordSpec}


class StockTest extends WordSpec with Matchers {


  "Stock.parseUserArgs" should {
    "parse case insensitive['APPLE'] " in {
      Stock.parseUserArgs(Array("APPLE")) shouldBe Map("apple" -> 1)
    }
    "parse comma separated strings ['apple,orange'] " in {
      Stock.parseUserArgs(Array("apple, orange")) shouldBe Map("apple" -> 1, "orange" -> 1)
    }
    "parse ['apple','orange']" in {
      Stock.parseUserArgs(Array("apple", "orange")) shouldBe Map("apple" -> 1, "orange" -> 1)
    }
    "parse ['apple,','orange']" in {
      Stock.parseUserArgs(Array("apple,", "orange")) shouldBe Map("apple" -> 1, "orange" -> 1)
    }
    "parse ['apple',',orange']" in {
      Stock.parseUserArgs(Array("apple", ",orange")) shouldBe Map("apple" -> 1, "orange" -> 1)
    }
    "parse ['apple', ',', 'orange']" in {
      Stock.parseUserArgs(Array("apple", ",", "orange")) shouldBe Map("apple" -> 1, "orange" -> 1)
    }
  }

}
