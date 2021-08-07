package scalqa; package lang; package boolean; package z; package opt; import language.implicitConversions

import gen.`given`.OptShape

object map:

  inline def apply[A<:Raw,B,OPT<:Opt.AnyType[B]](x:G.Opt[A], inline f: A=>B, inline s:OptShape[B,OPT] ): OPT =
    inline s match
      case _ : OptShape[B,Boolean.G.Opt[B]] => {var o:Boolean.G.Opt[B & Boolean.Raw]= \/; if(x.nonEmpty) o=f(x.`val`).cast[B & Boolean.Raw]; o.cast[OPT]}
      case _ : OptShape[B,Byte   .G.Opt[B]] => {var o:Byte   .G.Opt[B & Byte.Raw   ]= \/; if(x.nonEmpty) o=f(x.`val`).cast[B & Byte.Raw   ]; o.cast[OPT]}
      case _ : OptShape[B,Char   .G.Opt[B]] => {var o:Char   .G.Opt[B & Char.Raw   ]= \/; if(x.nonEmpty) o=f(x.`val`).cast[B & Char.Raw   ]; o.cast[OPT]}
      case _ : OptShape[B,Short  .G.Opt[B]] => {var o:Short  .G.Opt[B & Short.Raw  ]= \/; if(x.nonEmpty) o=f(x.`val`).cast[B & Short.Raw  ]; o.cast[OPT]}
      case _ : OptShape[B,Int    .G.Opt[B]] => {var o:Int    .G.Opt[B & Int.Raw    ]= \/; if(x.nonEmpty) o=f(x.`val`).cast[B & Int.Raw    ]; o.cast[OPT]}
      case _ : OptShape[B,Long   .G.Opt[B]] => {var o:Long   .G.Opt[B & Long.Raw   ]= \/; if(x.nonEmpty) o=f(x.`val`).cast[B & Long.Raw   ]; o.cast[OPT]}
      case _ : OptShape[B,Float  .G.Opt[B]] => {var o:Float  .G.Opt[B & Float.Raw  ]= \/; if(x.nonEmpty) o=f(x.`val`).cast[B & Float.Raw  ]; o.cast[OPT]}
      case _ : OptShape[B,Double .G.Opt[B]] => {var o:Double .G.Opt[B & Double.Raw ]= \/; if(x.nonEmpty) o=f(x.`val`).cast[B & Double.Raw ]; o.cast[OPT]}
      case _ : OptShape[B,      Val.Opt[B]] => {var o:      Val.Opt[B              ]= \/; if(x.nonEmpty) o=f(x.`val`).cast[B              ]; o.cast[OPT]}

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
