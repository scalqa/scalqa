package scalqa; package `val`; package opt; package z; import language.implicitConversions;

import Gen.Given.OptTag

object map:

  inline def apply[A,B,OPT<:Opt.AnyType[B]](x:Opt[A], inline f: A=>B, inline s:OptTag[B,OPT] ): OPT =
    inline s match
      case _ : OptTag[B,Boolean.G.Opt[B]] => {var o:Boolean.G.Opt[B & Raw.Boolean]= \/; if(x.nonEmpty) o=f(x.`val`).cast[B & Raw.Boolean]; o}
      case _ : OptTag[B,Byte   .G.Opt[B]] => {var o:Byte   .G.Opt[B & Raw.Byte   ]= \/; if(x.nonEmpty) o=f(x.`val`).cast[B & Raw.Byte   ]; o}
      case _ : OptTag[B,Char   .G.Opt[B]] => {var o:Char   .G.Opt[B & Raw.Char   ]= \/; if(x.nonEmpty) o=f(x.`val`).cast[B & Raw.Char   ]; o}
      case _ : OptTag[B,Short  .G.Opt[B]] => {var o:Short  .G.Opt[B & Raw.Short  ]= \/; if(x.nonEmpty) o=f(x.`val`).cast[B & Raw.Short  ]; o}
      case _ : OptTag[B,Int    .G.Opt[B]] => {var o:Int    .G.Opt[B & Raw.Int    ]= \/; if(x.nonEmpty) o=f(x.`val`).cast[B & Raw.Int    ]; o}
      case _ : OptTag[B,Long   .G.Opt[B]] => {var o:Long   .G.Opt[B & Raw.Long   ]= \/; if(x.nonEmpty) o=f(x.`val`).cast[B & Raw.Long   ]; o}
      case _ : OptTag[B,Float  .G.Opt[B]] => {var o:Float  .G.Opt[B & Raw.Float  ]= \/; if(x.nonEmpty) o=f(x.`val`).cast[B & Raw.Float  ]; o}
      case _ : OptTag[B,Double .G.Opt[B]] => {var o:Double .G.Opt[B & Raw.Double ]= \/; if(x.nonEmpty) o=f(x.`val`).cast[B & Raw.Double ]; o}
      case _ : OptTag[B,      Val.Opt[B]] => {var o:      Val.Opt[B              ]= \/; if(x.nonEmpty) o=f(x.`val`).cast[B              ]; o}

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
