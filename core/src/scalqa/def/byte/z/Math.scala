package scalqa; package `def`; package byte; package z; import language.implicitConversions

object Math extends g.Math[Byte] with math.Numeric.ByteIsIntegral with ~~.Custom.Math[Byte]:

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
      new SELF.<>(f,l-f+1)
    })

  @tn("calculateSum_Opt")
    def calculateSum_?(s: ~[SELF]): Val.Opt[SELF] = s.read_?.map(first => {
      var sum: Int = first
      s match
         case s: SELF.~ => s.FOREACH(v => sum = sum + v)
         case s         => s.FOREACH(v => sum = sum + v)
      sum.Byte
    })

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
