package scalqa; package lang; package string; package z; import language.implicitConversions

class CharStream(s: CharSequence) extends Char.Stream with Able.Size:
  private            var i         = 0
  private            val sz        = s.length
  def readRawOpt = { var o: Char.Opt = \/; if(i<sz) { o = s.charAt(i); i+=1 };  o}
  /**/               def size      = sz - i

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
