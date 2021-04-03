package scalqa; package j; package util; import language.implicitConversions

object Random:
  private val source = J.Setup.randomSource_*()

  def boolean             : Boolean   = int % 2 == 0
  def boolean_~           : Boolean.~ = {class BooleanStream extends Boolean.~ { @tn("readRaw_Opt") def readRaw_? = boolean}; new BooleanStream}
  def chance(p: Percent)  : Boolean   = p > fraction * 100

  def int                 : Int       = source.nextInt
  def int_~               : Int.~     = {class IntStream extends Int.~ { @tn("readRaw_Opt") def readRaw_? = source.nextInt}; new IntStream}

  def int(r: Int.<>)      : Int       = source.nextInt.abs % r.size + r.start
  def int_~(r: Int.<>)    : Int.~     = {class IntWithinIntervalStream extends Int.~ { @tn("readRaw_Opt") def readRaw_? = int(r)}; new IntWithinIntervalStream}

  def fraction            : Double    = source.nextDouble
  def fraction_~          : Double.~  = {class FractionStream extends Double.~ { @tn("readRaw_Opt") def readRaw_? = source.nextDouble}; new FractionStream}

// ********************************************************************
  trait Source:
    def nextInt    : Int
    def nextDouble : Double

  // ********************************************************************
  private[j] object Z:

    object JavaUtilSource extends Source:
      val v = new java.util.Random
      def nextInt    = v.nextInt
      def nextDouble = v.nextDouble

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
