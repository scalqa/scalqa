package scalqa; package gen; package math; import language.implicitConversions

import java.math. { BigInteger => REAL }
import Math.BigInteger

object BigInteger extends AnyRef.Opaque.Data[BigInteger,REAL]("BigInteger"):
  inline   def apply(inline v: REAL)   : BigInteger  = v.toOpaque
  inline   def apply(inline v: Long)   : BigInteger  = REAL.valueOf(v).toOpaque
  inline   def apply(inline v: String) : BigInteger  = REAL(v).toOpaque
  override def value_tag(v: BigInteger): String      = v.real.toString

  given ordering : Ordering[BigInteger] with
    def compare(x: BigInteger, y: BigInteger) = x.toNumber.compareTo(y.toNumber)

  extension(x: BigInteger | Long)
    private                 inline def mkReal                            : REAL           = inline x match{ case _ : Long => REAL.valueOf(x.cast[Long]); case _ => x.cast[REAL]}

  extension(inline x: BigInteger)
    @tn("greater")          inline def  >  (inline v: Long | BigInteger) : Boolean        = x.real.compareTo(v.mkReal) >  0
    @tn("greaterOrEqual")   inline def  >= (inline v: Long | BigInteger) : Boolean        = x.real.compareTo(v.mkReal) >= 0
    @tn("less")             inline def  <  (inline v: Long | BigInteger) : Boolean        = x.real.compareTo(v.mkReal) <  0
    @tn("lessOrEqual")      inline def  <= (inline v: Long | BigInteger) : Boolean        = x.real.compareTo(v.mkReal) <= 0
    @tn("plus")             inline def  +  (inline v: Long | BigInteger) : BigInteger     = x.real.add(v.mkReal).toOpaque
    @tn("minus")            inline def  -  (inline v: Long | BigInteger) : BigInteger     = x.real.subtract(v.mkReal).toOpaque
    @tn("multiply")         inline def  *  (inline v: Long | BigInteger) : BigInteger     = x.real.multiply(v.mkReal).toOpaque
    @tn("divide")           inline def  /  (inline v: Long | BigInteger) : BigInteger     = x.real.divide(v.mkReal).toOpaque
    @tn("remainder")        inline def  %  (inline v: Long | BigInteger) : BigInteger     = x.real.remainder(v.mkReal).toOpaque
    /**/                    inline def abs                               : BigInteger     = x.real.abs().toOpaque
    /**/                    inline def unary_-                           : BigInteger     = x.real.negate.toOpaque
    /**/                    inline def sign                              : Int            = x.real.signum
    /**/                    inline def toLong                            : Long           = x.real.longValue
    /**/                    inline def toNumber                          : REAL           = x.real

  object TYPE:
    opaque type DEF <: AnyRef.Opaque = REAL & AnyRef.Opaque

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@type DEF  -> ### Big Integer

      [[BigInteger]] is an opaque value holding java.math.BigInteger

      [[BigInteger]] is used for really large integer calculations

      ```
      val max: BigInteger = ~~(58).repeat(35).foldAs(1.Big)(_ * _)

      "Largest Bitcoin address= " + max + ", digits=" + max.toString.length TP()

      val TenB = 10.Big * 1000 * 1000 * 1000
      val YearSecs = 60.Big * 60 * 24 * 365

      "Suppose, there is 10 billion computers in the world capable counting 10 billion numbers per second each" TP()
      "  Together they will count " + (TenB * TenB) + " in a second" TP()
      "  Together they will count " + (TenB * TenB * YearSecs) + " in a year" TP()
      "  Together they will count " + (TenB * TenB * YearSecs * TenB) + " in 10 billions years - the 'Age of Universe'" TP()
      "It is required "   +   (max / ((TenB * TenB * YearSecs * TenB))) + " 'Ages of Universe'" TP()
      "for all todays computers together to just simply count all Bitcoin adresses" TP()

      // Output ****************************************************************************************************************
      Largest Bitcoin address= 52478302028992644968172978478148648556151605660894866578604032, digits=62
      Suppose, there is 10 billion computers in the world capable counting 10 billion numbers per second each
        Together they will count 100000000000000000000 in a second
        Together they will count 3153600000000000000000000000 in a year
        Together they will count 31536000000000000000000000000000000000 in 10 billions years - the 'Age of Universe'
      It is required 1664076041000527808478341 'Ages of Universe'
      for all todays computers together to just simply count all Bitcoin adresses
      ```
*/
