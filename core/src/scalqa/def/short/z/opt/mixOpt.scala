package scalqa; package `def`; package short; package z; package opt; import language.implicitConversions

import Shape.OfOpt.*

object mixOpt:

  inline def apply[A<:RAW,B,C,OPT<:Any[C]](x:G.Opt[A], bo: Any[B], inline f: (A,B)=>C, inline s:Tag[C,OPT]): OPT =
    inline s match
      case _ : Tag[C,Boolean.G.Opt[C]] => {var o:Boolean.G.Opt[C & Raw.Boolean]= \/; if(x.nonEmpty && bo.SOME) o=f(x.`val`,bo.VAL).cast[C & Raw.Boolean]; o}
      case _ : Tag[C,Byte   .G.Opt[C]] => {var o:Byte   .G.Opt[C & Raw.Byte   ]= \/; if(x.nonEmpty && bo.SOME) o=f(x.`val`,bo.VAL).cast[C & Raw.Byte   ]; o}
      case _ : Tag[C,Char   .G.Opt[C]] => {var o:Char   .G.Opt[C & Raw.Char   ]= \/; if(x.nonEmpty && bo.SOME) o=f(x.`val`,bo.VAL).cast[C & Raw.Char   ]; o}
      case _ : Tag[C,Short  .G.Opt[C]] => {var o:Short  .G.Opt[C & Raw.Short  ]= \/; if(x.nonEmpty && bo.SOME) o=f(x.`val`,bo.VAL).cast[C & Raw.Short  ]; o}
      case _ : Tag[C,Int    .G.Opt[C]] => {var o:Int    .G.Opt[C & Raw.Int    ]= \/; if(x.nonEmpty && bo.SOME) o=f(x.`val`,bo.VAL).cast[C & Raw.Int    ]; o}
      case _ : Tag[C,Long   .G.Opt[C]] => {var o:Long   .G.Opt[C & Raw.Long   ]= \/; if(x.nonEmpty && bo.SOME) o=f(x.`val`,bo.VAL).cast[C & Raw.Long   ]; o}
      case _ : Tag[C,Float  .G.Opt[C]] => {var o:Float  .G.Opt[C & Raw.Float  ]= \/; if(x.nonEmpty && bo.SOME) o=f(x.`val`,bo.VAL).cast[C & Raw.Float  ]; o}
      case _ : Tag[C,Double .G.Opt[C]] => {var o:Double .G.Opt[C & Raw.Double ]= \/; if(x.nonEmpty && bo.SOME) o=f(x.`val`,bo.VAL).cast[C & Raw.Double ]; o}
      case _ : Tag[C,      Val.Opt[C]] => {var o:      Val.Opt[C              ]= \/; if(x.nonEmpty && bo.SOME) o=f(x.`val`,bo.VAL).cast[C              ]; o}

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
