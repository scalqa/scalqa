package scalqa; package gen; package math; package z; import language.implicitConversions

import java.{ math as M }

object Rounding:

  object Up extends Rounding(M.RoundingMode.UP, M.BigDecimal.ROUND_CEILING):
    def apply(v: Int,    s: Int)    = { var w=v - v % s; if(w<v) w+=s; w }
    def apply(v: Long,   s: Long)   = { var w=v - v % s; if(w<v) w+=s; w }
    def apply(v: Double, s: Double) = { var w=v - v % s; if(w<v) w+=s; w }
    def extra(v: Double)            = if(v > 0) 1 else 0

  object Down extends Rounding(M.RoundingMode.DOWN, M.BigDecimal.ROUND_FLOOR):
    def apply(v: Int,    s: Int)    = v - v % s
    def apply(v: Long,   s: Long)   = v - v % s
    def apply(v: Double, s: Double) = v - v % s
    def extra(v: Double)            = if(v < 0) -1 else 0

  object HalfUp extends Rounding(M.RoundingMode.HALF_UP, M.BigDecimal.ROUND_HALF_UP):
    def apply(v: Int,    s: Int)    = { val r=v%s; var w=v-r; if(w<v && r>=s/2) w+=s; w }
    def apply(v: Long,   s: Long)   = { val r=v%s; var w=v-r; if(w<v && r>=s/2) w+=s; w }
    def apply(v: Double, s: Double) = { val r=v%s; var w=v-r; if(w<v && r>=s/2) w+=s; w }
    def extra(v: Double)            = if(v >= 0D){ if(v >= 0.5D) 1 else 0 } else if(v <= -0.5D) 0 else -1

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
