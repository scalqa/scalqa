package scalqa; package lang; package float; package z; import language.implicitConversions

object Math extends scala.math.Numeric.FloatIsFractional with Ordering[Float] with ~~.Custom.Ordering[Float] with Gen.Math.Sum[Float] with Gen.Math.Average[Float]:

  def compare(x:Float, y:Float) = java.lang.Float.compare(x,y)

  @tn("min_Opt")
    def min_?(s: ~[Float]): Val.Opt[Float] = s.read_?.map(v=>
      s match
         case s: Float.~ => s.FOLD(v)((v,w) => if(v<w) v else w)
         case s          => s.FOLD(v)((v,w) => if(v<w) v else w)
    )

  @tn("max_Opt")
    def max_?(s: ~[Float]): Val.Opt[Float] = s.read_?.map(v=>
      s match
         case s: Float.~ => s.FOLD(v)((v,w) => if(v>w) v else w)
         case s          => s.FOLD(v)((v,w) => if(v>w) v else w)
    )

  @tn("range_Opt")
    def range_?(s: ~[Float]): Val.Opt[Float.<>] = s.read_?.map(v => {
      var f,l=v
      s match
         case s: Float.~ => s.FOREACH(v => if(v<f) f=v else if(v>l) l=v)
         case s          => s.FOREACH(v => if(v<f) f=v else if(v>l) l=v)
      new Float.<>(f,l,true)
    })

  @tn("sum_Opt")
    def sum_?(s: ~[Float]): Val.Opt[Float] = s.read_?.map(first => {
      var sum: Float = first
      s match
         case s: Float.~ => s.FOREACH(v => sum = sum + v)
         case s          => s.FOREACH(v => sum = sum + v)
      sum
    })

  /**/               def average  (s: ~[Float]) = average_?(s) or 0F
  @tn("average_Opt") def average_?(s: ~[Float]) = new Calculation().^(l => s match{case s:Float.~ => s.FOREACH(l.add); case s => s.FOREACH(l.add)}).averageOpt
  /**/               def averageCalculation     = new Calculation

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