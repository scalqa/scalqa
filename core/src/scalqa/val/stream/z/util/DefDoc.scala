package scalqa; package `val`; package stream; package z; package util; import language.implicitConversions

class DocDef[A](using t: Given.DocDef[A]) extends Given.DocDef[~[A]]:
  def value_tag(v: ~[A]) : String   = "~(" + v.makeString(", ") + ")"
  def value_doc(v: ~[A]) : Doc      = Able.Doc.doc_?(v) or z.util.MultiDoc(v)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
