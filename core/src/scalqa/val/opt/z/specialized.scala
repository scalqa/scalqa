package scalqa; package `val`; package opt; package z; import language.implicitConversions;

object specialized:

  inline def map[A,B](x:Opt[A], inline f: A=>B)(using inline B: Specialized[B]): B.Opt =
    inline B match
      case _ : Specialized[B & Any.Boolean] => { var o: Boolean.Opt= \/; if(x) o=f(x.`val`).cast[Boolean]; o.cast[B.Opt] }
      case _ : Specialized[B & Any.Byte   ] => { var o: Byte   .Opt= \/; if(x) o=f(x.`val`).cast[Byte   ]; o.cast[B.Opt] }
      case _ : Specialized[B & Any.Char   ] => { var o: Char   .Opt= \/; if(x) o=f(x.`val`).cast[Char   ]; o.cast[B.Opt] }
      case _ : Specialized[B & Any.Short  ] => { var o: Short  .Opt= \/; if(x) o=f(x.`val`).cast[Short  ]; o.cast[B.Opt] }
      case _ : Specialized[B & Any.Int    ] => { var o: Int    .Opt= \/; if(x) o=f(x.`val`).cast[Int    ]; o.cast[B.Opt] }
      case _ : Specialized[B & Any.Long   ] => { var o: Long   .Opt= \/; if(x) o=f(x.`val`).cast[Long   ]; o.cast[B.Opt] }
      case _ : Specialized[B & Any.Float  ] => { var o: Float  .Opt= \/; if(x) o=f(x.`val`).cast[Float  ]; o.cast[B.Opt] }
      case _ : Specialized[B & Any.Double ] => { var o: Double .Opt= \/; if(x) o=f(x.`val`).cast[Double ]; o.cast[B.Opt] }
      case _                                => { var o:  Val.Opt[B]= \/; if(x) o=f(x.`val`).cast[B      ]; o.cast[B.Opt] }

  inline def mapOpt[A,B,OPT<:Any.Opt[B]](x:Opt[A], inline f: A=>OPT)(using inline s:Specialized.Opt[B,OPT], inline B:Specialized[B]): B.Opt =
    inline B match
      case _ : Specialized[B & Any.Boolean] => { var o: Boolean.Opt= \/; if(x) o=s(x.`val`,f).cast[Boolean.Opt]; o.cast[B.Opt] }
      case _ : Specialized[B & Any.Byte   ] => { var o: Byte   .Opt= \/; if(x) o=s(x.`val`,f).cast[Byte   .Opt]; o.cast[B.Opt] }
      case _ : Specialized[B & Any.Char   ] => { var o: Char   .Opt= \/; if(x) o=s(x.`val`,f).cast[Char   .Opt]; o.cast[B.Opt] }
      case _ : Specialized[B & Any.Short  ] => { var o: Short  .Opt= \/; if(x) o=s(x.`val`,f).cast[Short  .Opt]; o.cast[B.Opt] }
      case _ : Specialized[B & Any.Int    ] => { var o: Int    .Opt= \/; if(x) o=s(x.`val`,f).cast[Int    .Opt]; o.cast[B.Opt] }
      case _ : Specialized[B & Any.Long   ] => { var o: Long   .Opt= \/; if(x) o=s(x.`val`,f).cast[Long   .Opt]; o.cast[B.Opt] }
      case _ : Specialized[B & Any.Float  ] => { var o: Float  .Opt= \/; if(x) o=s(x.`val`,f).cast[Float  .Opt]; o.cast[B.Opt] }
      case _ : Specialized[B & Any.Double ] => { var o: Double .Opt= \/; if(x) o=s(x.`val`,f).cast[Double .Opt]; o.cast[B.Opt] }
      case _                                => { var o:  Val.Opt[B]= \/; if(x) o=s(x.`val`,f).cast[Val .Opt[B]]; o.cast[B.Opt] }

  inline def mix[A,B,C](x:Opt[A], bo: Any.Opt[B], inline f: (A,B) => C)(using inline C:Specialized[C]): C.Opt =
    import lang.any.z.opt.Ops.{SOME, VAL}
    inline C match
      case _ : Specialized[C & Any.Boolean] => { var o: Boolean.Opt= \/; if(x && bo.SOME) o=f(x.`val`,bo.VAL).cast[Boolean]; o.cast[C.Opt]}
      case _ : Specialized[C & Any.Byte   ] => { var o: Byte   .Opt= \/; if(x && bo.SOME) o=f(x.`val`,bo.VAL).cast[Byte   ]; o.cast[C.Opt]}
      case _ : Specialized[C & Any.Char   ] => { var o: Char   .Opt= \/; if(x && bo.SOME) o=f(x.`val`,bo.VAL).cast[Char   ]; o.cast[C.Opt]}
      case _ : Specialized[C & Any.Short  ] => { var o: Short  .Opt= \/; if(x && bo.SOME) o=f(x.`val`,bo.VAL).cast[Short  ]; o.cast[C.Opt]}
      case _ : Specialized[C & Any.Int    ] => { var o: Int    .Opt= \/; if(x && bo.SOME) o=f(x.`val`,bo.VAL).cast[Int    ]; o.cast[C.Opt]}
      case _ : Specialized[C & Any.Long   ] => { var o: Long   .Opt= \/; if(x && bo.SOME) o=f(x.`val`,bo.VAL).cast[Long   ]; o.cast[C.Opt]}
      case _ : Specialized[C & Any.Float  ] => { var o: Float  .Opt= \/; if(x && bo.SOME) o=f(x.`val`,bo.VAL).cast[Float  ]; o.cast[C.Opt]}
      case _ : Specialized[C & Any.Double ] => { var o: Double .Opt= \/; if(x && bo.SOME) o=f(x.`val`,bo.VAL).cast[Double ]; o.cast[C.Opt]}
      case _                                => { var o:  Val.Opt[C]= \/; if(x && bo.SOME) o=f(x.`val`,bo.VAL)              ; o.cast[C.Opt]}

  inline def raw[A](x:Opt[A])(using inline A:Specialized.Primitive[A]): A.Opt =
    inline A match
      case _ : Specialized.Primitive[A & Any.Boolean] => {var o: Boolean.Opt= \/; if(x) o=x.cast[java.lang.Boolean  ].booleanValue; o.cast[A.Opt]}
      case _ : Specialized.Primitive[A & Any.Byte   ] => {var o: Byte   .Opt= \/; if(x) o=x.cast[java.lang.Byte     ].byteValue;    o.cast[A.Opt]}
      case _ : Specialized.Primitive[A & Any.Char   ] => {var o: Char   .Opt= \/; if(x) o=x.cast[java.lang.Character].charValue;    o.cast[A.Opt]}
      case _ : Specialized.Primitive[A & Any.Short  ] => {var o: Short  .Opt= \/; if(x) o=x.cast[java.lang.Short    ].shortValue;   o.cast[A.Opt]}
      case _ : Specialized.Primitive[A & Any.Int    ] => {var o: Int    .Opt= \/; if(x) o=x.cast[java.lang.Integer  ].intValue;     o.cast[A.Opt]}
      case _ : Specialized.Primitive[A & Any.Long   ] => {var o: Long   .Opt= \/; if(x) o=x.cast[java.lang.Long     ].longValue;    o.cast[A.Opt]}
      case _ : Specialized.Primitive[A & Any.Float  ] => {var o: Float  .Opt= \/; if(x) o=x.cast[java.lang.Float    ].floatValue;   o.cast[A.Opt]}
      case _ : Specialized.Primitive[A & Any.Double ] => {var o: Double .Opt= \/; if(x) o=x.cast[java.lang.Double   ].doubleValue;  o.cast[A.Opt]}
      case _                                          => J.illegalState()

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
