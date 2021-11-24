package scalqa; package lang; package float; package z; import language.implicitConversions

object Math extends scala.math.Numeric.FloatIsFractional with Ordering[Float] with Stream.Custom.Ordering[Float] with Gen.Math.Sum[Float] with Gen.Math.Average[Float]:

  def compare(x:Float, y:Float) = java.lang.Float.compare(x,y)

  def minOpt(s: Stream[Float]): Val.Opt[Float] = s.readOpt.map(v=>
    s match
       case s: Float.Stream => s.FOLD(v)((v,w) => if(v<w) v else w)
       case s               => s.FOLD(v)((v,w) => if(v<w) v else w)
  )

  def maxOpt(s: Stream[Float]): Val.Opt[Float] = s.readOpt.map(v=>
    s match
       case s: Float.Stream => s.FOLD(v)((v,w) => if(v>w) v else w)
       case s               => s.FOLD(v)((v,w) => if(v>w) v else w)
  )

  def rangeOpt(s: Stream[Float]): Val.Opt[Float.Range] = s.readOpt.map(v => {
    var f,l=v
    s match
       case s: Float.Stream => s.FOREACH(v => if(v<f) f=v else if(v>l) l=v)
       case s               => s.FOREACH(v => if(v<f) f=v else if(v>l) l=v)
    new Float.Range(f,l,true)
  })

  def sumOpt(s: Stream[Float]): Val.Opt[Float] = s.readOpt.map(first => {
    var sum: Float = first
    s match
       case s: Float.Stream => s.FOREACH(v => sum = sum + v)
       case s               => s.FOREACH(v => sum = sum + v)
    sum
  })

  def average   (s: Stream[Float]) = averageOpt(s) or 0F
  def averageOpt(s: Stream[Float]) = new Calculation().self(l => s match{case s:Float.Stream => s.FOREACH(l.add); case s => s.FOREACH(l.add)}).averageOpt
  def averageCalculation           = new Calculation

  // *******************************************************************
  class Calculation extends Gen.Math.Average.Calculation[Float]:
    private var total : Double     = 0
    private var cnt   : Int        = 0
    def add(v: Float) : Unit       = {total += v; cnt+=1}
    def average       : Float      = if(cnt==0) 0  else (total / cnt).toFloat
    def averageOpt    : Opt[Float] = if(cnt==0) \/ else (total / cnt).toFloat

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/