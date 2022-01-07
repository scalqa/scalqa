package scalqa; package `val`; package stream; package z; package util; import language.implicitConversions

class DocDef[A](using t: Any.Def.Tag[A]) extends Any.Def.Doc[Stream[A]]:
  def value_tag(v: Stream[A]): String   = "Stream(" + v.makeString(", ") + ")"
  def value_doc(v: Stream[A]): Doc      = Able.Doc.docOpt(v) or MultiDoc(v)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
