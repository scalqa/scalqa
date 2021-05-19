package scalqa; package lang; package byte; package z; package opt; import language.implicitConversions

import G.Opt

abstract class _base:
  self: Opt.type =>

  given givenCanEqualOpt[A<:RAW,B<:RAW](using CanEqual[A,B]) : CanEqual[Opt[A],Opt[B]] = CanEqual.derived
  given givenVoidTag [A<:RAW]                                : Self.VoidTag[Opt[A]]        with { def isVoid( v:Opt[A]) = v.isEmpty }
  given givenEmptyTag[A<:RAW]                                : Self.EmptyTag[Opt[A]]       with { def isEmpty(v:Opt[A]) = v.isEmpty }
  given givenNameTag [A<:RAW]      (using t :Self.NameTag[A]): Self.NameTag[Opt[A]]        with { def name              = t.name + ".Opt"}
  given givenDocTag  [A<:RAW :Self.DocTag](using t :Self.NameTag[A]): Self.DocTag[Opt[A]]  with { def tag( v: Opt[A])   = t.name + ".Opt(" + v.map(_.tag).or("\\/") + ")"
                                                                                                   def doc(v: Opt[A])   = Self.Doc(t.name + ".Opt") += ("value", v.map(_.tag).or("\\/"))}

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
