package scalqa; package lang; package int; package z; package opt; import language.implicitConversions

import Shape.OfOpt.Any

object map:

  inline def apply[A<:RAW,B,OPT<:Any[B]](x:G.Opt[A], inline f: A=>B, inline s:Any.Def[B,OPT] ): OPT =
    inline s match
      case _ : Any.Def[B,Boolean.G.Opt[B]] => {var o:Boolean.G.Opt[B & Raw.Boolean]= \/; if(x.nonEmpty) o=f(x.`val`).cast[B & Raw.Boolean]; o}
      case _ : Any.Def[B,Byte   .G.Opt[B]] => {var o:Byte   .G.Opt[B & Raw.Byte   ]= \/; if(x.nonEmpty) o=f(x.`val`).cast[B & Raw.Byte   ]; o}
      case _ : Any.Def[B,Char   .G.Opt[B]] => {var o:Char   .G.Opt[B & Raw.Char   ]= \/; if(x.nonEmpty) o=f(x.`val`).cast[B & Raw.Char   ]; o}
      case _ : Any.Def[B,Short  .G.Opt[B]] => {var o:Short  .G.Opt[B & Raw.Short  ]= \/; if(x.nonEmpty) o=f(x.`val`).cast[B & Raw.Short  ]; o}
      case _ : Any.Def[B,Int    .G.Opt[B]] => {var o:Int    .G.Opt[B & Raw.Int    ]= \/; if(x.nonEmpty) o=f(x.`val`).cast[B & Raw.Int    ]; o}
      case _ : Any.Def[B,Long   .G.Opt[B]] => {var o:Long   .G.Opt[B & Raw.Long   ]= \/; if(x.nonEmpty) o=f(x.`val`).cast[B & Raw.Long   ]; o}
      case _ : Any.Def[B,Float  .G.Opt[B]] => {var o:Float  .G.Opt[B & Raw.Float  ]= \/; if(x.nonEmpty) o=f(x.`val`).cast[B & Raw.Float  ]; o}
      case _ : Any.Def[B,Double .G.Opt[B]] => {var o:Double .G.Opt[B & Raw.Double ]= \/; if(x.nonEmpty) o=f(x.`val`).cast[B & Raw.Double ]; o}
      case _ : Any.Def[B,      Val.Opt[B]] => {var o:      Val.Opt[B              ]= \/; if(x.nonEmpty) o=f(x.`val`).cast[B              ]; o}

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
