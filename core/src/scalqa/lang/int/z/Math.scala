package scalqa; package lang; package int; package z; import language.implicitConversions

object Math extends scala.math.Numeric.IntIsIntegral with Ordering[Int] with ~~.Custom.Ordering[Int] with Gen.Math.Sum[Int]:

  def compare(x:Int, y:Int) = java.lang.Integer.compare(x,y)

  @tn("min_Opt")
    def min_?(s: ~[Int]): Val.Opt[Int] = s.read_?.map(v=>
      s match
         case s: Int.~  => s.FOLD(v)((v,w) => if(v<w) v else w)
         case s         => s.FOLD(v)((v,w) => if(v<w) v else w)
    )

  @tn("max_Opt")
    def max_?(s: ~[Int]): Val.Opt[Int] = s.read_?.map(v=>
      s match
         case s: Int.~  => s.FOLD(v)((v,w) => if(v>w) v else w)
         case s         => s.FOLD(v)((v,w) => if(v>w) v else w)
    )

  @tn("range_Opt")
    def range_?(s: ~[Int]): Val.Opt[Int.<>] = s.read_?.map(v => {
      var f,l=v
      s match
         case s: Int.~  => s.FOREACH(v => if(v<f) f=v else if(v>l) l=v)
         case s         => s.FOREACH(v => if(v<f) f=v else if(v>l) l=v)
      new Int.<>(f,l-f+1)
    })

  @tn("sum_Opt")
    def sum_?(s: ~[Int]): Val.Opt[Int] = s.read_?.map(first => {
      var sum: Int = first
      s match
         case s: Int.~  => s.FOREACH(v => sum = sum + v)
         case s         => s.FOREACH(v => sum = sum + v)
      sum
    })

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/