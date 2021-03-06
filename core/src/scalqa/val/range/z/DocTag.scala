package scalqa; package `val`; package range; package z; import language.implicitConversions

class DocTag[A: Given.DocTag] extends Given.DocTag[Range[A]] :

  def tag(v: Range[A]) : String   = String.Builder(20).^(b => { b += v.start += " <>"; if(!v.endIsIn) b += ">"; b += " " += v.end }).tag
  def doc(v: Range[A]) : Doc      = Doc(v) += ("start", v.start) += (if(v.endIsIn) "endIn" else "endX", v.end)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
