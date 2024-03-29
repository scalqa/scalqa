package scalqa; package lang; package float; package z; import language.implicitConversions

object opt:

  inline def map[A<:Raw,B](x:G.Opt[A], inline f: A=>B)(using inline s: Specialized[B]): s.Opt =
    inline s match
      case _ : Specialized[B & Any.Boolean] => { var o: Boolean.Opt=VOID; if(x) o=f(x.`val`).cast[Boolean]; o.cast[s.Opt] }
      case _ : Specialized[B & Any.Byte   ] => { var o: Byte   .Opt=VOID; if(x) o=f(x.`val`).cast[Byte   ]; o.cast[s.Opt] }
      case _ : Specialized[B & Any.Char   ] => { var o: Char   .Opt=VOID; if(x) o=f(x.`val`).cast[Char   ]; o.cast[s.Opt] }
      case _ : Specialized[B & Any.Short  ] => { var o: Short  .Opt=VOID; if(x) o=f(x.`val`).cast[Short  ]; o.cast[s.Opt] }
      case _ : Specialized[B & Any.Int    ] => { var o: Int    .Opt=VOID; if(x) o=f(x.`val`).cast[Int    ]; o.cast[s.Opt] }
      case _ : Specialized[B & Any.Long   ] => { var o: Long   .Opt=VOID; if(x) o=f(x.`val`).cast[Long   ]; o.cast[s.Opt] }
      case _ : Specialized[B & Any.Float  ] => { var o: Float  .Opt=VOID; if(x) o=f(x.`val`).cast[Float  ]; o.cast[s.Opt] }
      case _ : Specialized[B & Any.Double ] => { var o: Double .Opt=VOID; if(x) o=f(x.`val`).cast[Double ]; o.cast[s.Opt] }
      case _                                => { var o:  Val.Opt[B]=VOID; if(x) o=f(x.`val`).cast[B      ]; o.cast[s.Opt] }

  inline def mapOpt[A<:Raw,B,OPT<:Any.Opt[B]](inline x:G.Opt[A], inline f: A=>OPT)(using inline so:Specialized.Opt[B,OPT], inline s:Specialized[B]): s.Opt =
    inline s match
      case _ : Specialized[B & Any.Boolean] => { var o: Boolean.Opt=VOID; if(x) o=so(x.`val`,f).cast[Boolean.Opt]; o.cast[s.Opt] }
      case _ : Specialized[B & Any.Byte   ] => { var o: Byte   .Opt=VOID; if(x) o=so(x.`val`,f).cast[Byte   .Opt]; o.cast[s.Opt] }
      case _ : Specialized[B & Any.Char   ] => { var o: Char   .Opt=VOID; if(x) o=so(x.`val`,f).cast[Char   .Opt]; o.cast[s.Opt] }
      case _ : Specialized[B & Any.Short  ] => { var o: Short  .Opt=VOID; if(x) o=so(x.`val`,f).cast[Short  .Opt]; o.cast[s.Opt] }
      case _ : Specialized[B & Any.Int    ] => { var o: Int    .Opt=VOID; if(x) o=so(x.`val`,f).cast[Int    .Opt]; o.cast[s.Opt] }
      case _ : Specialized[B & Any.Long   ] => { var o: Long   .Opt=VOID; if(x) o=so(x.`val`,f).cast[Long   .Opt]; o.cast[s.Opt] }
      case _ : Specialized[B & Any.Float  ] => { var o: Float  .Opt=VOID; if(x) o=so(x.`val`,f).cast[Float  .Opt]; o.cast[s.Opt] }
      case _ : Specialized[B & Any.Double ] => { var o: Double .Opt=VOID; if(x) o=so(x.`val`,f).cast[Double .Opt]; o.cast[s.Opt] }
      case _                                => { var o:  Val.Opt[B]=VOID; if(x) o=so(x.`val`,f).cast[Val .Opt[B]]; o.cast[s.Opt] }

  inline def mix[A<:Raw,B,C](x:G.Opt[A], bo: Any.Opt[B], inline f: (A,B)=>C)(using inline s: Specialized[C]): s.Opt =
    import lang.any.z.opt.Ops.{SOME,VAL}
    inline s match
      case _ : Specialized[C & Any.Boolean] => { var o: Boolean.Opt=VOID; if(x && bo.SOME) o=f(x.`val`,bo.VAL).cast[Boolean]; o.cast[s.Opt] }
      case _ : Specialized[C & Any.Byte   ] => { var o: Byte   .Opt=VOID; if(x && bo.SOME) o=f(x.`val`,bo.VAL).cast[Byte   ]; o.cast[s.Opt] }
      case _ : Specialized[C & Any.Char   ] => { var o: Char   .Opt=VOID; if(x && bo.SOME) o=f(x.`val`,bo.VAL).cast[Char   ]; o.cast[s.Opt] }
      case _ : Specialized[C & Any.Short  ] => { var o: Short  .Opt=VOID; if(x && bo.SOME) o=f(x.`val`,bo.VAL).cast[Short  ]; o.cast[s.Opt] }
      case _ : Specialized[C & Any.Int    ] => { var o: Int    .Opt=VOID; if(x && bo.SOME) o=f(x.`val`,bo.VAL).cast[Int    ]; o.cast[s.Opt] }
      case _ : Specialized[C & Any.Long   ] => { var o: Long   .Opt=VOID; if(x && bo.SOME) o=f(x.`val`,bo.VAL).cast[Long   ]; o.cast[s.Opt] }
      case _ : Specialized[C & Any.Float  ] => { var o: Float  .Opt=VOID; if(x && bo.SOME) o=f(x.`val`,bo.VAL).cast[Float  ]; o.cast[s.Opt] }
      case _ : Specialized[C & Any.Double ] => { var o: Double .Opt=VOID; if(x && bo.SOME) o=f(x.`val`,bo.VAL).cast[Double ]; o.cast[s.Opt] }
      case _                                => { var o:  Val.Opt[C]=VOID; if(x && bo.SOME) o=f(x.`val`,bo.VAL).cast[C      ]; o.cast[s.Opt] }

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
