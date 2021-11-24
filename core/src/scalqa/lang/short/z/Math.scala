package scalqa; package lang; package short; package z; import language.implicitConversions

object Math extends scala.math.Numeric.ShortIsIntegral with Ordering[Short] with Stream.Custom.Ordering[Short] with Gen.Math.Sum[Short]:

  def compare(x:Short, y:Short) = java.lang.Short.compare(x,y)

  def minOpt(s: Stream[Short]): Val.Opt[Short] = s.readOpt.map(v=>
    s match
       case s: Short.Stream => s.FOLD(v)((v,w) => if(v<w) v else w)
       case s               => s.FOLD(v)((v,w) => if(v<w) v else w)
  )

  def maxOpt(s: Stream[Short]): Val.Opt[Short] = s.readOpt.map(v=>
    s match
       case s: Short.Stream => s.FOLD(v)((v,w) => if(v>w) v else w)
       case s               => s.FOLD(v)((v,w) => if(v>w) v else w)
  )

  def rangeOpt(s: Stream[Short]): Val.Opt[Short.Range] = s.readOpt.map(v => {
    var f,l=v
    s match
       case s: Short.Stream => s.FOREACH(v => if(v<f) f=v else if(v>l) l=v)
       case s               => s.FOREACH(v => if(v<f) f=v else if(v>l) l=v)
    new Short.Range(f,l-f+1)
  })

  def sumOpt(s: Stream[Short]): Val.Opt[Short] = s.readOpt.map(first => {
    var sum: Int = first
    s match
       case s: Short.Stream => s.FOREACH(v => sum = sum + v)
       case s               => s.FOREACH(v => sum = sum + v)
    sum.toShort
  })

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
