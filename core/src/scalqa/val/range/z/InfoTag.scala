package scalqa; package `val`; package range; package z; import language.implicitConversions

class InfoTag[A: Info.Tag] extends Info.Tag[Range[A]] :

  def tag (v: Range[A]) : String = String.Builder(20).^(b => { b += v.start += " <>"; if(!v.endIsIn) b += ">"; b += " " += v.end }).tag
  def info(v: Range[A]) : Info   = Info(v) += ("start", v.start) += (if(v.endIsIn) "endIn" else "endX", v.end)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
