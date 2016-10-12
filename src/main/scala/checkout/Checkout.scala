package checkout

/**
  * Represents something which can price items
  * @tparam T the type of the item being priced
  * @tparam Price the resulting Price (which could be
  *               e.g. a simple Double, a price and currency,
  *               or even an Either[PriceError, Double] to represent potential failures
  */
trait Checkout[T, Price] {

  def price(item: T, amount: Int): Price

  def calculateCartTotal(cart: Map[T, Int])(implicit ev: Numeric[Price]): Price = {
    val prices = cart.map {
      case (item, amount) => price(item, amount)
    }
    prices.sum
  }
}

object Checkout {

  class Pricer[Price: Numeric](priceByItem: Map[String, Price]) extends Checkout[String, Price] {
    def price(item: String, amount: Int) = {
      val price = priceByItem(item)
      val n = implicitly[Numeric[Price]]
      n.times(price, n.fromInt(amount))
    }
  }

  def apply[Price: Numeric](prices: Map[String, Price]): Checkout[String, Price] = new Pricer[Price](prices)
}
