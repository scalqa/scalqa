package scalqa; package api; package _signature

object StandardExtensions:

    def apply(m:Member, x:Signature): Signature = if(x.isEmpty) x else
      var s: Signature = x.dropGenericDef("A")
      m.name match
        case "map"|"MAP"|"flatten"|"flatMap"|"FLAT_MAP"|"collect"     => s.prepended("[B]")
        case "map_?" | "MAP_?"                                        => s.prepended("[B,OPT<:Any.Opt[B]]")
        case "mix"                                                    => s.prepended("[B,C]")
        case "groupWith"                                              => s.prepended("[B]")
        case "groupBy"                                                => s
        case "toLookupBy"                                             => s.prepended("[KEY]")
        case n if n.endsWith("By")||n.endsWith("As")||n.endsWith("AS")=> s.prepended("[B]")
        case "foreach"|"FOREACH"|"foreachIndexed"|"fornil"|"forval"   => s.prepended("[U]")
        case "process"                                                => s.prepended("[U,W]")
        case n if n.endsWith("Few")                                   => s.prepended("[B,C,D,E,F]")
        case "transpose"|"zip"|"zipAll"|"zipKey"|"zipValue"|"takeType"=> s.prepended("[B]")
        case "unzip"                                                  => s.prepended("[B,C]")
        case v if v.startsWith("peek")                                => s.prepended("[U]")
        case _                                                        => s

