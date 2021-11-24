package scalqa; package lang; package int; package z; import language.implicitConversions

object Math extends scala.math.Numeric.IntIsIntegral with Ordering[Int] with Stream.Custom.Ordering[Int] with Gen.Math.Sum[Int]:

  def compare(x:Int, y:Int) = java.lang.Integer.compare(x,y)

  def minOpt(s: Stream[Int]): Val.Opt[Int] = s.readOpt.map(v=>
    s match
       case s: Int.Stream  => s.FOLD(v)((v,w) => if(v<w) v else w)
       case s              => s.FOLD(v)((v,w) => if(v<w) v else w)
  )

  def maxOpt(s: Stream[Int]): Val.Opt[Int] = s.readOpt.map(v=>
    s match
       case s: Int.Stream  => s.FOLD(v)((v,w) => if(v>w) v else w)
       case s              => s.FOLD(v)((v,w) => if(v>w) v else w)
  )

  def rangeOpt(s: Stream[Int]): Val.Opt[Int.Range] = s.readOpt.map(v => {
    var f,l=v
    s match
       case s: Int.Stream  => s.FOREACH(v => if(v<f) f=v else if(v>l) l=v)
       case s              => s.FOREACH(v => if(v<f) f=v else if(v>l) l=v)
    new Int.Range(f,l-f+1)
  })

  def sumOpt(s: Stream[Int]): Val.Opt[Int] = s.readOpt.map(first => {
    var sum: Int = first
    s match
       case s: Int.Stream  => s.FOREACH(v => sum = sum + v)
       case s              => s.FOREACH(v => sum = sum + v)
    sum
  })

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/