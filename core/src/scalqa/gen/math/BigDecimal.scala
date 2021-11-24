package scalqa; package gen; package math; import language.implicitConversions

import java.math. { BigDecimal => REAL, BigInteger => JBigInteger }
import Math.BigDecimal

object BigDecimal extends AnyRef.Opaque.Data[BigDecimal,REAL]("BigDecimal"):
  inline   def apply(inline v: REAL)                     : BigDecimal = v.toOpaque
  inline   def apply(inline v: JBigInteger | BigInteger) : BigDecimal = REAL(v.cast[JBigInteger]).toOpaque
  inline   def apply(inline v: Double)                   : BigDecimal = REAL.valueOf(v).toOpaque
  inline   def apply(inline v: String)                   : BigDecimal = REAL(v).toOpaque
  override def value_tag(v: BigDecimal)                  : String     = v.real.toString

  given ordering : Ordering[BigDecimal] with
    def compare(x: BigDecimal, y: BigDecimal) = x.toNumber.compareTo(y.toNumber)

  extension(x: BigDecimal | Double)
    private                 inline def mkReal                               : REAL          = inline x match{ case _ : Double => REAL.valueOf(x.cast[Double]); case _ => x.cast[REAL]}

  extension(inline x: BigDecimal)
    @tn("greater")          inline def  >  (inline v: Double | BigDecimal)  : Boolean       = x.real.compareTo(v.mkReal) >  0
    @tn("greaterOrEqual")   inline def  >= (inline v: Double | BigDecimal)  : Boolean       = x.real.compareTo(v.mkReal) >= 0
    @tn("less")             inline def  <  (inline v: Double | BigDecimal)  : Boolean       = x.real.compareTo(v.mkReal) <  0
    @tn("lessOrEqual")      inline def  <= (inline v: Double | BigDecimal)  : Boolean       = x.real.compareTo(v.mkReal) <= 0
    @tn("plus")             inline def  +  (inline v: Double | BigDecimal)  : BigDecimal    = x.real.add(v.mkReal).toOpaque
    @tn("minus")            inline def  -  (inline v: Double | BigDecimal)  : BigDecimal    = x.real.subtract(v.mkReal).toOpaque
    @tn("multiply")         inline def  *  (inline v: Double | BigDecimal)  : BigDecimal    = x.real.multiply(v.mkReal).toOpaque
    @tn("divide")           inline def  /  (inline v: Double | BigDecimal)
                                                 (using inline r: Rounding) : BigDecimal    = x.real.divide(v.mkReal, J.Setup.bigDecimalDefaultScale, r.mode).toOpaque
    @tn("remainder")        inline def  %  (inline v: Double | BigDecimal)  : BigDecimal    = x.real.remainder(v.mkReal).toOpaque
    /**/                    inline def abs                                  : BigDecimal    = x.real.abs().toOpaque
    /**/                    inline def unary_-                              : BigDecimal    = x.real.negate.toOpaque
    /**/                    inline def sign                                 : Int           = x.real.signum
    /**/                    inline def toDouble                             : Double        = x.real.doubleValue
    /**/                    inline def toNumber                             : REAL          = x.real
    /**/                    inline def BigInteger                           : BigInteger    = Gen.BigInteger(x.real.toBigInteger)
    /**/                    inline def roundToDecimal(inline v:Int)
                                                   (using inline r:Rounding): BigDecimal    = x.real.round(java.math.MathContext(v,r.mode)).toOpaque

  object TYPE:
    opaque type DEF <: AnyRef.Opaque = REAL & AnyRef.Opaque

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@type DEF  -> ### Big BigDecimal

     [[BigDecimal]] is an opaque value holding java.math.BigDecimal

     [[BigDecimal]] is used for really large floating point calculations

     ```
       // Calculate number Pi using Nilakantha series

       Stream(2.0.Big)
         .unfold(_.last + 4)
         .takeFirst(1000) // the more - the better
         .map(v => (4.0.Big / (v * (v + 1) * (v + 2)) - 4.0.Big / ((v + 2) * (v + 3) * (v + 4))))
         .fold(3.0.Big)(_ + _)
         .TP

       // Prints: 3.1415926535585900763679167025419016466613791096007613231066955478
     ```

@def roundToDecimal -> Round to decimal \n\n  Rounds current value to specified decimal position of fractional value

*/
