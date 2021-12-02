package scalqa; package lang; package double; package z; import language.implicitConversions

object Math extends scala.math.Numeric.DoubleIsFractional with Ordering[Double] with Stream.Custom.Ordering[Double] with Gen.Math.Sum[Double] with Gen.Math.Average[Double]:

  def compare(x:Double, y:Double) = java.lang.Double.compare(x,y)

  def minOpt(s: Stream[Double]): Val.Opt[Double] = s.readOpt.map(v=>
    s match
       case s: Double.Stream => s.FOLD(v)((v,w) => if(v<w) v else w)
       case s                => s.FOLD(v)((v,w) => if(v<w) v else w)
  )

  def maxOpt(s: Stream[Double]): Val.Opt[Double] = s.readOpt.map(v=>
    s match
       case s: Double.Stream => s.FOLD(v)((v,w) => if(v>w) v else w)
       case s                => s.FOLD(v)((v,w) => if(v>w) v else w)
  )

  def rangeOpt(s: Stream[Double]): Val.Opt[Double.Range] = s.readOpt.map(v => {
    var f,l=v
    s match
       case s: Double.Stream => s.FOREACH(v => if(v<f) f=v else if(v>l) l=v)
       case s                => s.FOREACH(v => if(v<f) f=v else if(v>l) l=v)
    new Double.Range(f,l,true)
  })

  def sumOpt(s: Stream[Double]): Val.Opt[Double] = s.readOpt.map(first => {
    var sum: Double = first
    s match
       case s: Double.Stream => s.FOREACH(v => sum = sum + v)
       case s                => s.FOREACH(v => sum = sum + v)
    sum
  })

  def average   (s: Stream[Double]) = averageOpt(s) or 0F
  def averageOpt(s: Stream[Double]) = new Calculation().self(l => s match{case s:Double.Stream => s.FOREACH(l.add); case s => s.FOREACH(l.add)}).averageOpt
  def averageCalculation            = new Calculation

  // *******************************************************************
  class Calculation extends Gen.Math.Average.Calculation[Double]:
    private var total : Double      = 0
    private var cnt   : Int         = 0
    def add(v: Double): Unit        = {total += v; cnt+=1}
    def average       : Double      = if(cnt==0) 0  else (total / cnt)
    def averageOpt    : Opt[Double] = if(cnt==0) VOID else (total / cnt)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
