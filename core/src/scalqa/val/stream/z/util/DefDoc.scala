package scalqa; package `val`; package stream; package z; package util; import language.implicitConversions

class DocTag[A](using t: Self.DocTag[A]) extends Self.DocTag[~[A]]:
  def tag(v: ~[A]) : String   = "~(" + v.makeString(", ") + ")"
  def doc(v: ~[A]) : Self.Doc = Able.Doc.doc_?(v) or z.util.MultiDoc(v)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
