package scalqa; package `def`; package double; package z; package opt; import language.implicitConversions

import G.Opt
import Info.Tag

abstract class _base:
  self: Opt.type =>

  given xxCanEqual[A<:RAW,B<:RAW](using CanEqual[A,B]) : CanEqual[Opt[A],Opt[B]] = CanEqual.derived
  given xxTagVoid [A<:RAW]                             : Tag.Void[Opt[A]]        with { def isVoid( v:Opt[A]) = v.isEmpty }
  given xxTagEmpty[A<:RAW]                             : Tag.Empty[Opt[A]]       with { def isEmpty(v:Opt[A]) = v.isEmpty }
  given xxTagType  [A<:RAW]        (using t:Tag.Type[A]): Tag.Type[Opt[A]]        with { def name              = t.name + ".Opt"}
  given xxInfoTag  [A<:RAW:Tag]    (using t:Tag.Type[A]): Tag[Opt[A]]             with { def tag( v: Opt[A])   = t.name + ".Opt(" + v.map(_.tag).or("\\/") + ")"
                                                                                        def info(v: Opt[A])   = Info(t.name + ".Opt") += ("value", v.map(_.tag).or("\\/"))}

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
