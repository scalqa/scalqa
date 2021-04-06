package scalqa; package lang; package int; package z; package opt; import language.implicitConversions

import G.Opt

abstract class _base:
  self: Opt.type =>

  given xxCanEqual[A<:RAW,B<:RAW](using CanEqual[A,B]) : CanEqual[Opt[A],Opt[B]] = CanEqual.derived
  given xxDefVoid [A<:RAW]                             : Def.Void[Opt[A]]        with { def isVoid( v:Opt[A]) = v.isEmpty }
  given xxDefEmpty[A<:RAW]                             : Def.Empty[Opt[A]]       with { def isEmpty(v:Opt[A]) = v.isEmpty }
  given xxDefName  [A<:RAW]        (using t:Def.Name[A]): Def.Name[Opt[A]]        with { def name              = t.name + ".Opt"}
  given xxDefDoc  [A<:RAW:Def.Doc]    (using t:Def.Name[A]): Def.Doc[Opt[A]]             with { def tag( v: Opt[A])   = t.name + ".Opt(" + v.map(_.tag).or("\\/") + ")"
                                                                                        def doc(v: Opt[A])   = Doc(t.name + ".Opt") += ("value", v.map(_.tag).or("\\/"))}

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
