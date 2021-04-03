package scalqa; package `def`; package float; package z; import language.implicitConversions

object Math extends g.Math[Float] with math.Numeric.FloatIsFractional with ~~.Custom.Math[Float]:

  @tn("min_Opt")
    def min_?(s: ~[SELF]): Val.Opt[SELF] = s.read_?.map(v=>
      s match
         case s: SELF.~ => s.FOLD(v)((v,w) => if(v<w) v else w)
         case s         => s.FOLD(v)((v,w) => if(v<w) v else w)
    )

  @tn("max_Opt")
    def max_?(s: ~[SELF]): Val.Opt[SELF] = s.read_?.map(v=>
      s match
         case s: SELF.~ => s.FOLD(v)((v,w) => if(v>w) v else w)
         case s         => s.FOLD(v)((v,w) => if(v>w) v else w)
    )

  @tn("range_Opt")
    def range_?(s: ~[SELF]): Val.Opt[SELF.<>] = s.read_?.map(v => {
      var f,l=v
      s match
         case s: SELF.~ => s.FOREACH(v => if(v<f) f=v else if(v>l) l=v)
         case s         => s.FOREACH(v => if(v<f) f=v else if(v>l) l=v)
      new SELF.<>(f,l,true)
    })

  @tn("calculateSum_Opt")
    def calculateSum_?(s: ~[SELF]): Val.Opt[SELF] = s.read_?.map(first => {
      var sum: SELF = first
      s match
         case s: SELF.~ => s.FOREACH(v => sum = sum + v)
         case s         => s.FOREACH(v => sum = sum + v)
      sum
    })

  override def average   (s: ~[Float]): Float          = averageOpt(s) or 0F
  override def averageOpt(s: ~[Float]): Val.Opt[Float] = new AverageLogic().^(l => s match{case s:Float.~ => s.FOREACH(l.add); case s => s.FOREACH(l.add)}).resultOpt
  override def averageLogic = new AverageLogic

// *******************************************************************
private class AverageLogic extends ~~.Custom.Math.Average.Logic[Float]:
  private var sum   : Double     = 0
  private var cnt   : Int        = 0
  def add(v: Float) : Unit       = {sum+=v; cnt+=1}
  def result        : Float      = if(cnt==0) 0  else (sum / cnt).Float
  def resultOpt     : Opt[Float] = if(cnt==0) \/ else (sum / cnt).Float

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/