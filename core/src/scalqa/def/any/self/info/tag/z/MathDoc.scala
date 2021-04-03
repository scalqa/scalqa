package scalqa; package `def`; package any; package self; package info; package tag; package z; import language.implicitConversions

class MathDoc extends Doc[Math[Any]]:
    def tag (v: Math[Any]) = info(v).tag
    def info(v: Math[Any]) = Info(v match
                                     case null                      => "null"
                                     case v if v eq Def.Byte.math   => "Byte.math"
                                     case v if v eq Def.Char.math   => "Char.math"
                                     case v if v eq Def.Short.math  => "Short.math"
                                     case v if v eq Def.Int.math    => "Int.math"
                                     case v if v eq Def.Long.math   => "Long.math"
                                     case v if v eq Def.Float.math  => "Float.math"
                                     case v if v eq Def.Double.math => "Double.math"
                                     case v                         => v.^.kind)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
