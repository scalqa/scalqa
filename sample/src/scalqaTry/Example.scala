package scalqaTry;  import scalqa.{*, given};  import language.implicitConversions

object Example:
  // ----------------------------------------------------------------------------------------
  type  Fahrenheit = Fahrenheit.opaque.`type`

  object Fahrenheit extends Double.Custom.Data.Number[Fahrenheit]("Fahrenheit"):
    inline def apply(v: Double) : Fahrenheit = v.asInstanceOf[Fahrenheit] //opaque
    override def tag(v:Fahrenheit) =  v.toString + "F"

    extension (x: Fahrenheit)
      inline def toCelsius : Celsius    = Celsius((5D/9D) * (x.real - 32D))

    object opaque:
      opaque type `type` <: Any.Opaque.Double = Any.Opaque.Double

  // ----------------------------------------------------------------------------------------
  type Celsius    = Celsius.opaque.`type`

  object Celsius extends Double.Custom.Data.Number[Celsius]("Celsius"):
    inline def apply(inline v: Double) : Celsius = v.asOpaque[Celsius]
    override def tag(v:Celsius) =  v.toString + "C"

    given x : Celsius_Methods = new Celsius_Methods{}

    object opaque:
      opaque type `type` <: Any.Opaque.Double = Any.Opaque.Double

  trait Celsius_Methods:
    extension(x: Celsius) inline def toFahrenheit : Fahrenheit = Fahrenheit(x.real * (9D/5D) + 32D)

  // ----------------------------------------------------------------------------------------
  val SIZE = 10000

  val fahrenheitArray: Array[Fahrenheit] = (1 to SIZE).map(v => Fahrenheit(50 + v % 40D)).toArray

  def main(sa: Array[String]): Unit =
    "*****************************************************************".tp

    val c : Celsius    = Celsius(27)
    val f : Fahrenheit = c.toFahrenheit

    c.tp
    f.tp

    J.Benchmark(
      () => (fahrenheitArray.iterator.map(_.toCelsius).filter(_ < Celsius(27)).sum / SIZE),
      () => (fahrenheitArray.~.map(_.toCelsius).filter(_ < Celsius(27)).sum / SIZE),
      () => (fahrenheitArray.~.MAP(_.toCelsius).TAKE(_ < Celsius(27)).sum / SIZE),
    )
