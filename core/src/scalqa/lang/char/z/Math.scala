package scalqa; package lang; package char; package z; import language.implicitConversions

object Math extends Ordering[Char] with Stream.Custom.Ordering[Char]:

  def compare(x:Char, y:Char) = java.lang.Character.compare(x,y)

  def minOpt(s: Stream[Char]): Val.Opt[Char] = s.readOpt.map(v=>
    s match
       case s: Char.Stream => s.FOLD(v)((v,w) => if(v<w) v else w)
       case s              => s.FOLD(v)((v,w) => if(v<w) v else w)
  )

  def maxOpt(s: Stream[Char]): Val.Opt[Char] = s.readOpt.map(v=>
    s match
       case s: Char.Stream => s.FOLD(v)((v,w) => if(v>w) v else w)
       case s              => s.FOLD(v)((v,w) => if(v>w) v else w)
  )

  def rangeOpt(s: Stream[Char]): Val.Opt[Char.Range] = s.readOpt.map(v => {
    var f,l=v
    s match
       case s: Char.Stream => s.FOREACH(v => if(v<f) f=v else if(v>l) l=v)
       case s              => s.FOREACH(v => if(v<f) f=v else if(v>l) l=v)
    new Char.Range(f,l-f+1)
  })

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
