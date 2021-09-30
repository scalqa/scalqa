package scalqa; package lang; package any; package z; import language.implicitConversions

import scala.quoted.*

object inMacro:

  infix inline def apply[A,C](inline v: A, inline c: C, inline d: Def.Within[A,C]): Boolean  = ${ applyMacro('v,'c,'d) }

  private def applyMacro[A:Type,C:Type](x: Expr[A], c: Expr[C], d: Expr[Def.Within[A,C]])(using Quotes): Expr[Boolean] =
    c match
       case '{ ($v1,$v2)                                           } => '{ val v=$x; v != null && (v.equals($v1) || v.equals($v2) ) }
       case '{ ($v1,$v2,$v3)                                       } => '{ val v=$x; v != null && (v.equals($v1) || v.equals($v2) || v.equals($v3) ) }
       case '{ ($v1,$v2,$v3,$v4)                                   } => '{ val v=$x; v != null && (v.equals($v1) || v.equals($v2) || v.equals($v3) || v.equals($v4)) }
       case '{ ($v1,$v2,$v3,$v4,$v5)                               } => '{ val v=$x; v != null && (v.equals($v1) || v.equals($v2) || v.equals($v3) || v.equals($v4) || v.equals($v5)) }
       case '{ ($v1,$v2,$v3,$v4,$v5,$v6)                           } => '{ val v=$x; v != null && (v.equals($v1) || v.equals($v2) || v.equals($v3) || v.equals($v4) || v.equals($v5) || v.equals($v6)) }
       case '{ ($v1,$v2,$v3,$v4,$v5,$v6,$v7)                       } => '{ val v=$x; v != null && (v.equals($v1) || v.equals($v2) || v.equals($v3) || v.equals($v4) || v.equals($v5) || v.equals($v6) || v.equals($v7)) }
       case '{ ($v1,$v2,$v3,$v4,$v5,$v6,$v7,$v8)                   } => '{ val v=$x; v != null && (v.equals($v1) || v.equals($v2) || v.equals($v3) || v.equals($v4) || v.equals($v5) || v.equals($v6) || v.equals($v7) || v.equals($v8)) }
       case '{ ($v1,$v2,$v3,$v4,$v5,$v6,$v7,$v8,$v9)               } => '{ val v=$x; v != null && (v.equals($v1) || v.equals($v2) || v.equals($v3) || v.equals($v4) || v.equals($v5) || v.equals($v6) || v.equals($v7) || v.equals($v8) || v.equals($v9)) }
       case '{ ($v1,$v2,$v3,$v4,$v5,$v6,$v7,$v8,$v9,$v10)          } => '{ val v=$x; v != null && (v.equals($v1) || v.equals($v2) || v.equals($v3) || v.equals($v4) || v.equals($v5) || v.equals($v6) || v.equals($v7) || v.equals($v8) || v.equals($v9) || v.equals($v10)) }
       case '{ ($v1,$v2,$v3,$v4,$v5,$v6,$v7,$v8,$v9,$v10,$v11)     } => '{ val v=$x; v != null && (v.equals($v1) || v.equals($v2) || v.equals($v3) || v.equals($v4) || v.equals($v5) || v.equals($v6) || v.equals($v7) || v.equals($v8) || v.equals($v9) || v.equals($v10) || v.equals($v11)) }
       case '{ ($v1,$v2,$v3,$v4,$v5,$v6,$v7,$v8,$v9,$v10,$v11,$v12)} => '{ val v=$x; v != null && (v.equals($v1) || v.equals($v2) || v.equals($v3) || v.equals($v4) || v.equals($v5) || v.equals($v6) || v.equals($v7) || v.equals($v8) || v.equals($v9) || v.equals($v10) || v.equals($v11) || v.equals($v12)) }
       case _                                                        => '{ $d.value_isWithin($x,$c) }

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
