package scalqa; package Util

class BigInteger private (val real: java.math.BigInteger) extends AnyVal with Any.Datum.BigInteger[BigInteger] {
  protected def setup = BigInteger

  override def toString = real.toString

}

object BigInteger extends Any.Datum.BigInteger.Setup[BigInteger] {

  def make(v: java.math.BigInteger) = new BigInteger(v)

  def make(v: Long): BigInteger = make(java.math.BigInteger.valueOf(v))
}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @class BigInteger -> `Big Integer`
 *
 *    [[BigInteger]] is used for really large integer calculations
 *
 *    {{{
 *       val Max = 58.I.repeat(35).foldAs(1.Big)(_ * _)
 *
 *       "Largest Bitcoin address= " + Max + ", digits=" + Max.toString.length + "\n" lp;
 *
 *       val TenB = 10.Big * 1000 * 1000 * 1000
 *       val YearSecs = 60.Big * 60 * 24 * 365
 *
 *       "Suppose, there is 10 billion computers in the world capable counting 10 billion numbers a second each\n" lp;
 *       "  Together they will count " + (TenB * TenB) + " a second\n" lp;
 *       "  Together they will count " + (TenB * TenB * YearSecs) + " a year\n" lp;
 *       "  Together they will count " + (TenB * TenB * YearSecs * TenB) + " in 10 billions years - the 'Age of Universe'\n" lp;
 *       "It is required "   +   (Max / ((TenB * TenB * YearSecs * TenB))) + " 'Ages of Universe'" lp;
 *       "for all todays computers together to just simply count all Bitcoin adresses" lp;
 *
 *       // Output ****************************************************************************************************************
 *
 *       Largest Bitcoin address= 52478302028992644968172978478148648556151605660894866578604032, digits=62
 *
 *       Suppose, there is 10 billion computers in the world capable counting 10 billion numbers a second each
 *
 *       Together they will count 100000000000000000000 a second
 *
 *       Together they will count 3153600000000000000000000000 a year
 *
 *       Together they will count 31536000000000000000000000000000000000 in 10 billions years - the 'Age of Universe'
 *
 *       It is required 1664076041000527808478341 'Ages of Universe'
 *       for all todays computers together to just simply count all Bitcoin adresses
 *    }}}
 */
