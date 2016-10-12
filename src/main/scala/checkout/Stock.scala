package checkout

/**
  * represents what the shop has and the prices
  */
object Stock {

  /**
    * @return price per item
    */
  def priceByItem = {
    Map(
      "apple" -> 60,
      "orange" -> 25
    )
  }

  def offers = Map(
    "apple" ->(2, 1),
    "orange" ->(3, 2)
  )

  /**
    * parses the user arguments/input to return a map of
    * the item names and amounts
    * @example apple,orange apple would return Map("apple" -> 2, "orange" -> 1)
    * @param args
    * @return a map of item names
    */
  def parseUserArgs(args: Array[String]): Map[String, Int] = {
    val splitArgsLowerCase = args.flatMap(_.split(",", -1)).flatMap(asKey)
    splitArgsLowerCase.groupBy(identity).mapValues(_.length)
  }

  private val SeparatorChars = Set(',', ';')

  /**
    * sanitize the user input
    */
  private def asKey(userArg: String): Option[String] = {
    val key = userArg.filterNot(SeparatorChars.contains).trim.toLowerCase
    Option(key).filterNot(_.isEmpty)
  }

}
