package scalqa; package lang; package any; package z; import language.implicitConversions

import scala.quoted.*

object containsMacro:

  infix inline def apply[A,C](inline c: C, inline v: A, inline d: Def.Contains[C,A]): Boolean  = ${ applyMacro('c,'v,'d) }

  private def applyMacro[A:Type,C:Type](c: Expr[C], x: Expr[A],d: Expr[Def.Contains[C,A]])(using Quotes): Expr[Boolean] =
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
       case _                                                        => '{ $d.contains($c,$x) }

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
