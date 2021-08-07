package scalqa; package lang; package byte; package z; package opt; import language.implicitConversions

import G.Opt

abstract class _base:
  self: Opt.type =>

  given givenCanEqualOpt[A<:Raw,B<:Raw](using CanEqual[A,B]) : CanEqual[Opt[A],Opt[B]] = CanEqual.derived
  given givenTypeDef [A<:Raw]     (using t :Given.TypeDef[A]): Given.TypeDef[Opt[A]]        with { def typeName                = t.typeName + ".Opt"}
  given givenVoidDef [A<:Raw]                                : Given.VoidDef[Opt[A]]        with { def value_isVoid( v:Opt[A]) = v.isEmpty }
  given givenEmptyDef[A<:Raw]                                : Given.EmptyDef[Opt[A]]       with { def value_isEmpty(v:Opt[A]) = v.isEmpty }
  given givenDocDef  [A<:Raw :Given.DocDef](using t :Given.TypeDef[A]):Given.DocDef[Opt[A]] with { def value_tag(v: Opt[A])    = t.typeName + ".Opt(" + v.map(_.tag).or("\\/") + ")"
                                                                                                   def value_doc(v: Opt[A])    = Doc(t.typeName + ".Opt") += ("value", v.map(_.tag).or("\\/"))}

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
