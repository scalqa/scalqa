package scalqa; import language.implicitConversions

object Example:
  // ----------------------------------------------------------------------------------------
  type  Price = Price.opaque.`type`

  extension (inline x: Double) inline def Dollars : Price = x.asOpaque[Price]

  object Price extends Double.Custom.Data.Number[Price]("Price"):
    inline   def apply(inline v: Double): Price  = v.asInstanceOf[Price]
    override def tag(v:Price)          : String =  "$"+v.roundTo(0.01.Dollars).toString

    extension (x: Price)
      inline def discount(inline p: Percent): Price  = x - p(x)
      def isExpensive                : Boolean = x >= 10

    object opaque:
      opaque type `type` <: Opaque.Double = Opaque.Double


  def main(sa: Array[String]): Unit =
    "*****************************************************************".tp

    var p: Price = 12.99.Dollars

    if(p > 10.0 && p < 20.0.Dollars) p.tp

    p = p  + 10.0 + 20.0.Dollars

    p.tp

    p = p.discount(5.Percent)

    p.tp

    val SIZE = 1000
    val array: Array[Price] = (1 to SIZE).map(v => (v % 100 + 0.99).Dollars).toArray

    J.Benchmark(
      ("Scala ",      () => (1 to 10_000).iterator.map(v => (v % 200 + 0.99).Dollars).toList.iterator.map(_.discount(5.Percent)).filter(! _.isExpensive).sum),
      ("Scalqa",      () => (1 <> 10_000).~       .map(v => (v % 200 + 0.99).Dollars).><.~       .map(_.discount(5.Percent)).filter(! _.isExpensive).sum),
      ("Scalqa Heavy",() => (1 <> 10_000).~       .MAP(v => (v % 200 + 0.99).Dollars).><.~       .MAP(_.discount(5.Percent)).FILTER(! _.isExpensive).sum)
    )


//    J.Benchmark(
//      () => array         .map(_.discount(5.Percent)).filter(_.isExpensive).sum ,
//      () => array.iterator.map(_.discount(5.Percent)).filter(_.isExpensive).sum ,
//      () => array.~       .map(_.discount(5.Percent)).filter(_.isExpensive).sum ,
//      () => array.~       .MAP(_.discount(5.Percent)).FILTER(_.isExpensive).sum ,
//    )

//    J.Benchmark(
//      () => array         .map(_.Float).filter(_ < 60).map(_.Dollars).sum ,
//      () => array.iterator.map(_.Float).filter(_ < 60).map(_.Dollars).sum ,
//      () => array.~       .map(_.Float).filter(_ < 60).map(_.Dollars).sum ,
//      () => array.~       .MAP(_.Float).FILTER(_ < 60).MAP(_.Dollars).sum ,
//    )
