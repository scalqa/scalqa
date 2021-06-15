package scalqa; package lang; package float; package z; package opt; import language.implicitConversions

import G.Opt

abstract class _base:
  self: Opt.type =>

  given givenCanEqualOpt[A<:RAW,B<:RAW](using CanEqual[A,B]) : CanEqual[Opt[A],Opt[B]] = CanEqual.derived
  given givenVoidTag [A<:RAW]                                : Given.VoidTag[Opt[A]]        with { def isVoid( v:Opt[A]) = v.isEmpty }
  given givenEmptyTag[A<:RAW]                                : Given.EmptyTag[Opt[A]]       with { def isEmpty(v:Opt[A]) = v.isEmpty }
  given givenNameTag [A<:RAW]      (using t :Given.NameTag[A]): Given.NameTag[Opt[A]]        with { def name              = t.name + ".Opt"}
  given givenDocTag  [A<:RAW :Given.DocTag](using t :Given.NameTag[A]): Given.DocTag[Opt[A]]  with { def tag( v: Opt[A])   = t.name + ".Opt(" + v.map(_.tag).or("\\/") + ")"
                                                                                                   def doc(v: Opt[A])   = Doc(t.name + ".Opt") += ("value", v.map(_.tag).or("\\/"))}

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
