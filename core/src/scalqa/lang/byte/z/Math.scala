package scalqa; package lang; package byte; package z; import language.implicitConversions

object Math extends scala.math.Numeric.ByteIsIntegral with Stream.Custom.Ordering[Byte] with Gen.Math.Sum[Byte]:

  def compare(x:Byte, y:Byte) = java.lang.Byte.compare(x,y)

  def minOpt(s: Stream[Byte]): Val.Opt[Byte] = s.readOpt.map(v=>
    s match
       case s: Byte.Stream => s.FOLD(v)((v,w) => if(v<w) v else w)
       case s              => s.FOLD(v)((v,w) => if(v<w) v else w)
  )

  def maxOpt(s: Stream[Byte]): Val.Opt[Byte] = s.readOpt.map(v=>
    s match
       case s: Byte.Stream => s.FOLD(v)((v,w) => if(v>w) v else w)
       case s              => s.FOLD(v)((v,w) => if(v>w) v else w)
  )

  def rangeOpt(s: Stream[Byte]): Val.Opt[Byte.Range] = s.readOpt.map(v => {
    var f,l=v
    s match
       case s: Byte.Stream => s.FOREACH(v => if(v<f) f=v else if(v>l) l=v)
       case s              => s.FOREACH(v => if(v<f) f=v else if(v>l) l=v)
    new Byte.Range(f,l-f+1)
  })

  def sumOpt(s: Stream[Byte]): Val.Opt[Byte] = s.readOpt.map(first => {
    var sum: Int = first
    s match
       case s: Byte.Stream => s.FOREACH(v => sum = sum + v)
       case s              => s.FOREACH(v => sum = sum + v)
    sum.toByte
  })

  def sum(s: Stream[Byte]) = sumOpt(s) or 0


/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
