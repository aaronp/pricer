package checkout

import org.scalatest.{Matchers, WordSpec}


class CheckoutTest extends WordSpec with Matchers {

  "Checkout.price" should {
    val defaultCheckout = Checkout(Stock.priceByItem)
    "return 0 for empty carts" in {
      defaultCheckout.calculateCartTotal(Map.empty) shouldBe 0
    }
    "price an apple at 60p" in {
      defaultCheckout.calculateCartTotal(Map("apple" -> 1)) shouldBe 60
    }
    "price an orange at 25p" in {
      defaultCheckout.calculateCartTotal(Map("orange" -> 1)) shouldBe 25
    }
    "price an apple and orange at 85p" in {
      defaultCheckout.calculateCartTotal(Map("apple" -> 1, "orange" -> 1)) shouldBe 85
    }
    "price two apples at 120p" in {
      defaultCheckout.calculateCartTotal(Map("apple" -> 2)) shouldBe 120
    }
    "price two apples and negative one oranges at 95p" in {
      defaultCheckout.calculateCartTotal(Map("apple" -> 2, "orange" -> -1)) shouldBe 95
    }
    "throw an exception if an item isn't recognized" in {
      a[Exception] shouldBe thrownBy {
        defaultCheckout.calculateCartTotal(Map("banana" -> 2, "orange" -> -1))
      }
    }
  }
}