package scalqa; package lang; package double; package z; import language.implicitConversions

object Math extends scala.math.Numeric.DoubleIsFractional with Ordering[Double] with ~~.Custom.Ordering[Double] with Gen.Math.Sum[Double] with Gen.Math.Average[Double]:

  def compare(x:Double, y:Double) = java.lang.Double.compare(x,y)

  @tn("min_Opt")
    def min_?(s: ~[Double]): Val.Opt[Double] = s.read_?.map(v=>
      s match
         case s: Double.~ => s.FOLD(v)((v,w) => if(v<w) v else w)
         case s           => s.FOLD(v)((v,w) => if(v<w) v else w)
    )

  @tn("max_Opt")
    def max_?(s: ~[Double]): Val.Opt[Double] = s.read_?.map(v=>
      s match
         case s: Double.~ => s.FOLD(v)((v,w) => if(v>w) v else w)
         case s           => s.FOLD(v)((v,w) => if(v>w) v else w)
    )

  @tn("range_Opt")
    def range_?(s: ~[Double]): Val.Opt[Double.<>] = s.read_?.map(v => {
      var f,l=v
      s match
         case s: Double.~ => s.FOREACH(v => if(v<f) f=v else if(v>l) l=v)
         case s           => s.FOREACH(v => if(v<f) f=v else if(v>l) l=v)
      new Double.<>(f,l,true)
    })

  @tn("sum_Opt")
    def sum_?(s: ~[Double]): Val.Opt[Double] = s.read_?.map(first => {
      var sum: Double = first
      s match
         case s: Double.~ => s.FOREACH(v => sum = sum + v)
         case s           => s.FOREACH(v => sum = sum + v)
      sum
    })

  /**/               def average  (s: ~[Double]) = average_?(s) or 0F
  @tn("average_Opt") def average_?(s: ~[Double]) = new Calculation().^(l => s match{case s:Double.~ => s.FOREACH(l.add); case s => s.FOREACH(l.add)}).averageOpt
  /**/               def averageCalculation      = new Calculation

  // *******************************************************************
  class Calculation extends Gen.Math.Average.Calculation[Double]:
    private var total : Double      = 0
    private var cnt   : Int         = 0
    def add(v: Double): Unit        = {total += v; cnt+=1}
    def average       : Double      = if(cnt==0) 0  else (total / cnt)
    def averageOpt    : Opt[Double] = if(cnt==0) \/ else (total / cnt)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
