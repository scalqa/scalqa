package scalqa; package gen; package math; import language.implicitConversions

import java.math. { BigDecimal => JBigDecimal, BigInteger => JBigInteger }
import Math.BigDecimal

object BigDecimal extends Any.Ref.Custom.Data[BigDecimal,JBigDecimal]("BigDecimal"):
  inline   def apply(inline v: JBigDecimal)              : BigDecimal = v.asOpaque[BigDecimal]
  inline   def apply(inline v: JBigInteger | BigInteger) : BigDecimal = JBigDecimal(v.cast[JBigInteger]).asOpaque[BigDecimal]
  inline   def apply(inline v: Double)                   : BigDecimal = JBigDecimal.valueOf(v).asOpaque[BigDecimal]
  inline   def apply(inline v: String)                   : BigDecimal = JBigDecimal(v).asOpaque[BigDecimal]
  override def tag(v: BigDecimal)                        : String     = v.real.toString

  given ordering : Ordering[BigDecimal] with
    def compare(x: BigDecimal, y: BigDecimal) = x.Number.compareTo(y.Number)

  extension(inline x: BigDecimal | Double)
    private                 inline def mkReal                               : JBigDecimal   = inline x match{ case _ : Double => JBigDecimal.valueOf(x.cast[Double]); case _ => x.cast[JBigDecimal]}

  extension(inline x: BigDecimal)
    @tn("greater")          inline def  >  (inline v: Double | BigDecimal)  : Boolean       = x.real.compareTo(v.mkReal) >  0
    @tn("greaterOrEqual")   inline def  >= (inline v: Double | BigDecimal)  : Boolean       = x.real.compareTo(v.mkReal) >= 0
    @tn("less")             inline def  <  (inline v: Double | BigDecimal)  : Boolean       = x.real.compareTo(v.mkReal) <  0
    @tn("lessOrEqual")      inline def  <= (inline v: Double | BigDecimal)  : Boolean       = x.real.compareTo(v.mkReal) <= 0
    @tn("plus")             inline def  +  (inline v: Double | BigDecimal)  : BigDecimal    = x.real.add(v.mkReal).asOpaque[BigDecimal]
    @tn("minus")            inline def  -  (inline v: Double | BigDecimal)  : BigDecimal    = x.real.subtract(v.mkReal).asOpaque[BigDecimal]
    @tn("multiply")         inline def  *  (inline v: Double | BigDecimal)  : BigDecimal    = x.real.multiply(v.mkReal).asOpaque[BigDecimal]
    @tn("divide")           inline def  /  (inline v: Double | BigDecimal)
                                                 (using inline r: Rounding) : BigDecimal    = x.real.divide(v.mkReal, J.Setup.bigDecimalDefaultScale, r.mode).asOpaque[BigDecimal]
    @tn("remainder")        inline def  %  (inline v: Double | BigDecimal)  : BigDecimal    = x.real.remainder(v.mkReal).asOpaque[BigDecimal]
    /**/                    inline def abs                                  : BigDecimal    = x.real.abs().asOpaque[BigDecimal]
    /**/                    inline def unary_-                              : BigDecimal    = x.real.negate.asOpaque[BigDecimal]
    /**/                    inline def sign                                 : Int           = x.real.signum
    /**/                    inline def Double                               : Double        = x.real.doubleValue
    /**/                    inline def Number                               : JBigDecimal   = x.real
    /**/                    inline def BigInteger                           : BigInteger    = Gen.BigInteger(x.real.toBigInteger)
    /**/                    inline def roundDecimal(v:Int)(using r:Rounding): BigDecimal    = x.real.round(java.math.MathContext(v,r.mode)).asOpaque[BigDecimal]

  object opaque:
    opaque type `type` <: Opaque.Ref = JBigDecimal & Opaque.Ref

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**

@object opaque -> ### Big BigDecimal

     [[BigDecimal]] is an opaque value holding java.math.BigDecimal

     [[BigDecimal]] is used for really large floating point calculations

     ```
       // Calculate number Pi using Nilakantha series

       ~~(2.0.Big)
         .unfold(_.last + 4)
         .takeFirst(1000) // the more - the better
         .map(v => (4.0.Big / (v * (v + 1) * (v + 2)) - 4.0.Big / ((v + 2) * (v + 3) * (v + 4))))
         .fold(3.0.Big)(_ + _)
         .TP

       // Prints: 3.1415926535585900763679167025419016466613791096007613231066955478
     ```
*/
