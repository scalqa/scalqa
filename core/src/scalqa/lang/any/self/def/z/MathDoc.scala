package scalqa; package lang; package any; package self; package `def`; package z; import language.implicitConversions

class MathDoc extends Def.Doc[Math[Any]]:
    def tag (v: Math[Any]) = doc(v).tag
    def doc(v: Math[Any]) = Self.Doc(v match
                                     case null                      => "null"
                                     case v if v eq Lang.Byte.math   => "Byte.math"
                                     case v if v eq Lang.Char.math   => "Char.math"
                                     case v if v eq Lang.Short.math  => "Short.math"
                                     case v if v eq Lang.Int.math    => "Int.math"
                                     case v if v eq Lang.Long.math   => "Long.math"
                                     case v if v eq Lang.Float.math  => "Float.math"
                                     case v if v eq Lang.Double.math => "Double.math"
                                     case v                         => v.^.kind)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
