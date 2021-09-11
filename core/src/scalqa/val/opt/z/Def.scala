package scalqa; package `val`; package opt; package z; import language.implicitConversions;

object Def extends Any.Def.Void[Opt[Any]] with Any.Def.Empty[Opt[Any]]:
  inline def value_isVoid( v:Opt[Any]) = v.isEmpty
  inline def value_isEmpty(v:Opt[Any]) = v.isEmpty

  class Doc[A :Any.Def.Doc] extends Any.Def.Doc[Opt[A]]:
    def value_tag(v: Opt[A]) = "Opt(" + v.map(_.tag).or("\\/") + ")"
    def value_doc(v: Opt[A]) = Gen.Doc("Opt") += ("value", v.map(_.tag).or("\\/"))

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
