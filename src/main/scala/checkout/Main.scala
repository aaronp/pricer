package checkout

object Main {

  /**
    * prices the user arguments (shopping cart input) using the default prices
    * @param userArgs
    * @return the total for the cart
    */
  def price[Price : Numeric](userArgs: Array[String], priceByItem: Map[String, Price]) = {
    val cart = Stock.parseUserArgs(userArgs)
    val checkout = Checkout(priceByItem)
    checkout.calculateCartTotal(cart)
  }

  def main(a: Array[String]): Unit = {
    val total = price(a, Stock.priceByItem)
    println(total)
  }

}
