package scalqa; package j; package util; import language.implicitConversions

object Random:
  private val source = J.Setup.randomSourcePro()

  def boolean             : Boolean        = int % 2 == 0
  def booleanStream           : Boolean.Stream = {class BooleanStream extends Boolean.Stream { def readRawOpt = boolean}; new BooleanStream}
  def chance(p: Percent)  : Boolean        = p > fraction * 100

  def int                 : Int            = source.nextInt
  def intStream               : Int.Stream     = {class IntStream extends Int.Stream { def readRawOpt = source.nextInt}; new IntStream}

  def int(r: Int.Range)   : Int            = source.nextInt.abs % r.size + r.start
  def intStream(r: Int.Range) : Int.Stream     = {class IntWithinIntervalStream extends Int.Stream { def readRawOpt = int(r)}; new IntWithinIntervalStream}

  def fraction            : Double         = source.nextDouble
  def fractionStream          : Double.Stream  = {class FractionStream extends Double.Stream { def readRawOpt = source.nextDouble}; new FractionStream}

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
