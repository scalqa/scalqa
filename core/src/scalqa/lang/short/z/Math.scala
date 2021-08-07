package scalqa; package lang; package short; package z; import language.implicitConversions

object Math extends g.Math[Short] with math.Numeric.ShortIsIntegral with ~~.Custom.Math[Short]:

  @tn("min_Opt")
    def min_?(s: ~[Short]): Val.Opt[Short] = s.read_?.map(v=>
      s match
         case s: Short.~ => s.FOLD(v)((v,w) => if(v<w) v else w)
         case s          => s.FOLD(v)((v,w) => if(v<w) v else w)
    )

  @tn("max_Opt")
    def max_?(s: ~[Short]): Val.Opt[Short] = s.read_?.map(v=>
      s match
         case s: Short.~ => s.FOLD(v)((v,w) => if(v>w) v else w)
         case s          => s.FOLD(v)((v,w) => if(v>w) v else w)
    )

  @tn("range_Opt")
    def range_?(s: ~[Short]): Val.Opt[Short.<>] = s.read_?.map(v => {
      var f,l=v
      s match
         case s: Short.~ => s.FOREACH(v => if(v<f) f=v else if(v>l) l=v)
         case s          => s.FOREACH(v => if(v<f) f=v else if(v>l) l=v)
      new Short.<>(f,l-f+1)
    })

  @tn("calculateSum_Opt")
    def calculateSum_?(s: ~[Short]): Val.Opt[Short] = s.read_?.map(first => {
      var sum: Int = first
      s match
         case s: Short.~ => s.FOREACH(v => sum = sum + v)
         case s          => s.FOREACH(v => sum = sum + v)
      sum.toShort
    })

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
