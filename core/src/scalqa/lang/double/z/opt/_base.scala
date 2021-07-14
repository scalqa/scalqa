package scalqa; package lang; package double; package z; package opt; import language.implicitConversions

import G.Opt

abstract class _base:
  self: Opt.type =>

  given givenCanEqualOpt[A<:RAW,B<:RAW](using CanEqual[A,B]) : CanEqual[Opt[A],Opt[B]] = CanEqual.derived
  given givenVoidTag [A<:RAW]                                : Given.VoidTag[Opt[A]]        with { def isVoid( v:Opt[A]) = v.isEmpty }
  given givenEmptyTag[A<:RAW]                                : Given.EmptyTag[Opt[A]]       with { def isEmpty(v:Opt[A]) = v.isEmpty }
  given givenTypeTag [A<:RAW]     (using t :Given.TypeTag[A]): Given.TypeTag[Opt[A]]        with { def typeName          = t.typeName + ".Opt"}
  given givenDocTag  [A<:RAW :Given.DocTag](using t :Given.TypeTag[A]):Given.DocTag[Opt[A]] with { def tag( v: Opt[A])   = t.typeName + ".Opt(" + v.map(_.tag).or("\\/") + ")"
                                                                                                   def doc(v: Opt[A])    = Doc(t.typeName + ".Opt") += ("value", v.map(_.tag).or("\\/"))}

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
