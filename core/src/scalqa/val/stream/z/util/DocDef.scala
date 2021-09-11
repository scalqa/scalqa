package scalqa; package `val`; package stream; package z; package util; import language.implicitConversions

class DocDef[A](t: Any.Def.Doc[A]) extends Any.Def.Doc[~[A]]:
  def value_tag(v: ~[A]) : String   = "~(" + v.makeString(", ") + ")"
  def value_doc(v: ~[A]) : Doc      = Able.Doc.doc_?(v) or MultiDoc(v)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
