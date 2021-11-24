package scalqa; package lang; package long; package z; import language.implicitConversions

object Math extends scala.math.Numeric.LongIsIntegral with Ordering[Long] with Stream.Custom.Ordering[Long] with Gen.Math.Sum[Long]:

  def compare(x:Long, y:Long) = java.lang.Long.compare(x,y)

  def minOpt(s: Stream[Long]): Val.Opt[Long] = s.readOpt.map(v=>
    s match
       case s: Long.Stream => s.FOLD(v)((v,w) => if(v<w) v else w)
       case s              => s.FOLD(v)((v,w) => if(v<w) v else w)
  )

  def maxOpt(s: Stream[Long]): Val.Opt[Long] = s.readOpt.map(v=>
    s match
       case s: Long.Stream => s.FOLD(v)((v,w) => if(v>w) v else w)
       case s              => s.FOLD(v)((v,w) => if(v>w) v else w)
  )

  def rangeOpt(s: Stream[Long]): Val.Opt[Long.Range] = s.readOpt.map(v => {
    var f,l=v
    s match
       case s: Long.Stream => s.FOREACH(v => if(v<f) f=v else if(v>l) l=v)
       case s              => s.FOREACH(v => if(v<f) f=v else if(v>l) l=v)
    new Long.Range(f,l,true)
  })

  def sumOpt(s: Stream[Long]): Val.Opt[Long] = s.readOpt.map(first => {
    var sum: Long = first
    s match
       case s: Long.Stream => s.FOREACH(v => sum = sum + v)
       case s              => s.FOREACH(v => sum = sum + v)
    sum
  })

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
