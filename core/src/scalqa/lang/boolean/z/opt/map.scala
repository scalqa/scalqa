package scalqa; package lang; package boolean; package z; package opt; import language.implicitConversions

import gen.`given`.OptTag

object map:

  inline def apply[A<:RAW,B,OPT<:Opt.AnyType[B]](x:G.Opt[A], inline f: A=>B, inline s:OptTag[B,OPT] ): OPT =
    inline s match
      case _ : OptTag[B,Boolean.G.Opt[B]] => {var o:Boolean.G.Opt[B & Raw.Boolean]= \/; if(x.nonEmpty) o=f(x.`val`).cast[B & Raw.Boolean]; o.cast[OPT]}
      case _ : OptTag[B,Byte   .G.Opt[B]] => {var o:Byte   .G.Opt[B & Raw.Byte   ]= \/; if(x.nonEmpty) o=f(x.`val`).cast[B & Raw.Byte   ]; o.cast[OPT]}
      case _ : OptTag[B,Char   .G.Opt[B]] => {var o:Char   .G.Opt[B & Raw.Char   ]= \/; if(x.nonEmpty) o=f(x.`val`).cast[B & Raw.Char   ]; o.cast[OPT]}
      case _ : OptTag[B,Short  .G.Opt[B]] => {var o:Short  .G.Opt[B & Raw.Short  ]= \/; if(x.nonEmpty) o=f(x.`val`).cast[B & Raw.Short  ]; o.cast[OPT]}
      case _ : OptTag[B,Int    .G.Opt[B]] => {var o:Int    .G.Opt[B & Raw.Int    ]= \/; if(x.nonEmpty) o=f(x.`val`).cast[B & Raw.Int    ]; o.cast[OPT]}
      case _ : OptTag[B,Long   .G.Opt[B]] => {var o:Long   .G.Opt[B & Raw.Long   ]= \/; if(x.nonEmpty) o=f(x.`val`).cast[B & Raw.Long   ]; o.cast[OPT]}
      case _ : OptTag[B,Float  .G.Opt[B]] => {var o:Float  .G.Opt[B & Raw.Float  ]= \/; if(x.nonEmpty) o=f(x.`val`).cast[B & Raw.Float  ]; o.cast[OPT]}
      case _ : OptTag[B,Double .G.Opt[B]] => {var o:Double .G.Opt[B & Raw.Double ]= \/; if(x.nonEmpty) o=f(x.`val`).cast[B & Raw.Double ]; o.cast[OPT]}
      case _ : OptTag[B,      Val.Opt[B]] => {var o:      Val.Opt[B              ]= \/; if(x.nonEmpty) o=f(x.`val`).cast[B              ]; o.cast[OPT]}

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
