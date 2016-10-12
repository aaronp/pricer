package checkout

import org.scalatest.{Matchers, WordSpec}

import scala.math.BigDecimal

class MainTest extends WordSpec with Matchers {

  "Main.price" should {

    "price an array of user arguments with the given prices" in {
      val total = Main.price(Array("carrot,", "CARROT,", "Banana", ",", "steak", "carrot", "steak"),
        Map("carrot" -> BigDecimal(1),
          "banana" -> BigDecimal(10),
          "steak" -> BigDecimal(100)
        ))
      //3 carrots = 3p
      //1 banana  = 10p
      //2 steaks  = 200p
      total shouldBe BigDecimal(213)
    }
  }
}
