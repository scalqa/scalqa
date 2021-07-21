package scalqa; package gen; package math; import language.implicitConversions

import java.math. { BigInteger => JBigInteger }
import Math.BigInteger

object BigInteger extends Any.Ref.Custom.Data[BigInteger,JBigInteger]("BigInteger"):
  inline   def apply(inline v: JBigInteger) : BigInteger  = v.asOpaque[BigInteger]
  inline   def apply(inline v: Long)        : BigInteger  = JBigInteger.valueOf(v).asOpaque[BigInteger]
  inline   def apply(inline v: String)      : BigInteger  = JBigInteger(v).asOpaque[BigInteger]
  override def tag(v: BigInteger)           : String      = v.real.toString

  given ordering : Ordering[BigInteger] with
    def compare(x: BigInteger, y: BigInteger) = x.Number.compareTo(y.Number)

  extension(inline x: BigInteger | Long)
    private                 inline def mkReal                            : JBigInteger    = inline x match{ case _ : Long => JBigInteger.valueOf(x.cast[Long]); case _ => x.cast[JBigInteger]}

  extension(inline x: BigInteger)
    @tn("greater")          inline def  >  (inline v: Long | BigInteger) : Boolean        = x.real.compareTo(v.mkReal) >  0
    @tn("greaterOrEqual")   inline def  >= (inline v: Long | BigInteger) : Boolean        = x.real.compareTo(v.mkReal) >= 0
    @tn("less")             inline def  <  (inline v: Long | BigInteger) : Boolean        = x.real.compareTo(v.mkReal) <  0
    @tn("lessOrEqual")      inline def  <= (inline v: Long | BigInteger) : Boolean        = x.real.compareTo(v.mkReal) <= 0
    @tn("plus")             inline def  +  (inline v: Long | BigInteger) : BigInteger     = x.real.add(v.mkReal).asOpaque[BigInteger]
    @tn("minus")            inline def  -  (inline v: Long | BigInteger) : BigInteger     = x.real.subtract(v.mkReal).asOpaque[BigInteger]
    @tn("multiply")         inline def  *  (inline v: Long | BigInteger) : BigInteger     = x.real.multiply(v.mkReal).asOpaque[BigInteger]
    @tn("divide")           inline def  /  (inline v: Long | BigInteger) : BigInteger     = x.real.divide(v.mkReal).asOpaque[BigInteger]
    @tn("remainder")        inline def  %  (inline v: Long | BigInteger) : BigInteger     = x.real.remainder(v.mkReal).asOpaque[BigInteger]
    /**/                    inline def abs                               : BigInteger     = x.real.abs().asOpaque[BigInteger]
    /**/                    inline def unary_-                           : BigInteger     = x.real.negate.asOpaque[BigInteger]
    /**/                    inline def sign                              : Int            = x.real.signum
    /**/                    inline def Long                              : Long           = x.real.longValue
    /**/                    inline def Number                            : JBigInteger    = x.real

  object opaque:
    opaque type `type` <: Opaque.Ref = JBigInteger & Opaque.Ref

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object opaque -> ### Big Integer

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
