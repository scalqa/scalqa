package scalqa; package gen; package request; package z; import language.implicitConversions

private[request] object VOID:
  object Ordering            extends Ordering[Any]                   with Gen.Void { def compare(x: Any, y: Any) = 0 }
  object Filter              extends (Any => Boolean)                with Gen.Void { def apply(v: Any) = true }
  object ToStringFunction    extends (Any => String)                 with Gen.Void { def apply(v: Any) = "" }
  object Function0           extends (() => Unit)                    with Gen.Void { def apply = () }
  object Function1           extends ((Any) => Unit)                 with Gen.Void { def apply(a: Any) = () }
  object Function1Opt       extends ((Any) => Opt[Any])             with Gen.Void { def apply(a: Any) : Opt[Any] = \/ }
  object Function1_Any       extends ((Any) => Any)                  with Gen.Void { def apply(a: Any) = J.unsupportedOperation() }
  object Function2           extends ((Any, Any) => Unit)            with Gen.Void { def apply(a: Any, b: Any) = () }
  object Function3           extends ((Any, Any, Any) => Unit)       with Gen.Void { def apply(a: Any, b: Any, c: Any) = () }
  object Function4           extends ((Any, Any, Any, Any) => Unit)  with Gen.Void { def apply(a: Any, b: Any, c: Any, d: Any) = () }
  object JavaList            extends java.util.AbstractList[Nothing] with Gen.Void { def get(i: Int) = J.illegalArgument(); def size = 0 }
  object Exception           extends Exception("void")               with Gen.Void
  object IntFunToDouble      extends Int.Fun.ToDouble                with Gen.Void { def apply(v:Int) = 0.0 }
  object IntFunToLong        extends Int.Fun.ToLong                  with Gen.Void { def apply(v:Int) = 0L  }

  object Math                extends Numeric[\/] with Gen.Void with Gen.Math.Average[\/]:
    def compare(x: \/, y: \/)    : Int        = 0
    def fromInt(x: Int)          : \/         = \/
    def minus(x: \/, y: \/)      : \/         = \/
    def negate(x: \/)            : \/         = \/
    def parseString(str: String) : Option[\/] = None
    def plus(x: \/, y: \/)       : \/         = \/
    def times(x: \/, y: \/)      : \/         = \/
    def toDouble(x: \/)          : Double     = 0
    def toFloat(x: \/)           : Float      = 0
    def toInt(x: \/)             : Int        = 0
    def toLong(x: \/)            : Long       = 0
    def average(s: Stream[\/])   : \/         = \/
    def averageOpt(s: Stream[\/]): Opt[\/]    = \/
    def averageCalculation = AverageLogic
    object AverageLogic extends Gen.Math.Average.Calculation[\/] { def add(v: \/) = (); def average= \/}

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
