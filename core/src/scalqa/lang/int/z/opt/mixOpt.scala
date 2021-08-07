package scalqa; package lang; package int; package z; package opt; import language.implicitConversions

import gen.`given`.OptShape
import `val`.opt.z.AnyTypeOps.*

object mixOpt:

  inline def apply[A<:Raw,B,C,OPT<:Opt.AnyType[C]](x:G.Opt[A], bo: Opt.AnyType[B], inline f: (A,B)=>C, inline s:OptShape[C,OPT]): OPT =
    inline s match
      case _ : OptShape[C,Boolean.G.Opt[C]] => {var o:Boolean.G.Opt[C & Boolean.Raw]= \/; if(x.nonEmpty && bo.SOME) o=f(x.`val`,bo.VAL).cast[C & Boolean.Raw]; o.cast[OPT]}
      case _ : OptShape[C,Byte   .G.Opt[C]] => {var o:Byte   .G.Opt[C & Byte.Raw   ]= \/; if(x.nonEmpty && bo.SOME) o=f(x.`val`,bo.VAL).cast[C & Byte.Raw   ]; o.cast[OPT]}
      case _ : OptShape[C,Char   .G.Opt[C]] => {var o:Char   .G.Opt[C & Char.Raw   ]= \/; if(x.nonEmpty && bo.SOME) o=f(x.`val`,bo.VAL).cast[C & Char.Raw   ]; o.cast[OPT]}
      case _ : OptShape[C,Short  .G.Opt[C]] => {var o:Short  .G.Opt[C & Short.Raw  ]= \/; if(x.nonEmpty && bo.SOME) o=f(x.`val`,bo.VAL).cast[C & Short.Raw  ]; o.cast[OPT]}
      case _ : OptShape[C,Int    .G.Opt[C]] => {var o:Int    .G.Opt[C & Int.Raw    ]= \/; if(x.nonEmpty && bo.SOME) o=f(x.`val`,bo.VAL).cast[C & Int.Raw    ]; o.cast[OPT]}
      case _ : OptShape[C,Long   .G.Opt[C]] => {var o:Long   .G.Opt[C & Long.Raw   ]= \/; if(x.nonEmpty && bo.SOME) o=f(x.`val`,bo.VAL).cast[C & Long.Raw   ]; o.cast[OPT]}
      case _ : OptShape[C,Float  .G.Opt[C]] => {var o:Float  .G.Opt[C & Float.Raw  ]= \/; if(x.nonEmpty && bo.SOME) o=f(x.`val`,bo.VAL).cast[C & Float.Raw  ]; o.cast[OPT]}
      case _ : OptShape[C,Double .G.Opt[C]] => {var o:Double .G.Opt[C & Double.Raw ]= \/; if(x.nonEmpty && bo.SOME) o=f(x.`val`,bo.VAL).cast[C & Double.Raw ]; o.cast[OPT]}
      case _ : OptShape[C,      Val.Opt[C]] => {var o:      Val.Opt[C              ]= \/; if(x.nonEmpty && bo.SOME) o=f(x.`val`,bo.VAL).cast[C              ]; o.cast[OPT]}

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
