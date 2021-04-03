package scalqa; package `def`; package double; package z; import language.implicitConversions

object Math extends g.Math[Double] with math.Numeric.DoubleIsFractional with ~~.Custom.Math[Double]:

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

  override def average   (s: ~[Double]): Double          = averageOpt(s) or 0F
  override def averageOpt(s: ~[Double]): Val.Opt[Double] = new AverageLogic().^(l => s match{case s:Double.~ => s.FOREACH(l.add); case s => s.FOREACH(l.add)}).resultOpt
  override def averageLogic = new AverageLogic

// *******************************************************************
private class AverageLogic extends ~~.Custom.Math.Average.Logic[Double]:
  private var sum    : Double      = 0
  private var cnt    : Int         = 0
  def add(v: Double) : Unit        = {sum+=v; cnt+=1}
  def result         : Double      = if(cnt==0) 0  else sum / cnt
  def resultOpt      : Opt[Double] = if(cnt==0) \/ else sum / cnt

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
