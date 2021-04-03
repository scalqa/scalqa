package scalqa; package `val`; package stream; package z; package util; import language.implicitConversions

class DocTag[A](using t: Info.Tag.Doc[A]) extends Info.Tag.Doc[~[A]]:
  def tag(v: ~[A]) : String = "~(" + v.makeString(", ") + ")"
  def info(v: ~[A]) : Info   = Able.Info.doc_?(v) or z.util.MultiDoc(v)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
