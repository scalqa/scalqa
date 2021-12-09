package scalqa; package lang; package any; package z; import language.implicitConversions

object opt:

  inline def make[A](inline x: A)(using inline s:Specialized[A]): s.Opt =
    inline s match
      case _ : Specialized[A & Any.Boolean] => (if(x.cast[Boolean]) Boolean.G.Opt.TRUE else Boolean.G.Opt.FALSE).cast[Boolean.Opt].cast[s.Opt]
      case _ : Specialized[A & Any.Byte   ] => x.cast[Byte  .Opt].cast[s.Opt]
      case _ : Specialized[A & Any.Char   ] => x.cast[Char  .Opt].cast[s.Opt]
      case _ : Specialized[A & Any.Short  ] => x.cast[Short .Opt].cast[s.Opt]
      case _ : Specialized[A & Any.Int    ] => x.cast[Int   .Opt].cast[s.Opt]
      case _ : Specialized[A & Any.Long   ] => x.cast[Long  .Opt].cast[s.Opt]
      case _ : Specialized[A & Any.Float  ] => x.cast[Float .Opt].cast[s.Opt]
      case _ : Specialized[A & Any.Double ] => x.cast[Double.Opt].cast[s.Opt]
      case _ : Specialized[A              ] => {val v=x; (if(v == null) ZZ.None else v).cast[Val.Opt[A]].cast[s.Opt]}

  def nonEmpty[A](x: Any, o:Opt[Def.Empty[A]], d:Def.Void[A]): Opt[A] =
    val v = x.cast[A]
    if(v == null || d.value_isVoid(v) || o.take(_.value_isEmpty(v))) VOID else v.cast[Opt[A]]

  def nonEmptyStream[A](x: Any): Opt[Stream[A]] =
    val s = x.cast[Stream[A]]
    s.sizeLongOpt.take(_ > 0).map(_ => s) orOpt s.enablePreview.self.map(p => p.previewOpt.map[Stream[A]](_ => p))

  // *************************************************************************************************
  class NameDef[A]()(using t :Any.Def.TypeName[A]) extends Def.TypeName[A]:
    def typeName = t.typeName + ".Opt"

  // *************************************************************************************************
  object Ops:

    extension[A](x: Any.Opt[A])
      inline def SOME: Boolean = inline x match
        case _ : boolean.G.Opt[A] => x.cast[boolean.G.Opt[A & Any.Boolean]].nonEmpty
        case _ : byte   .G.Opt[A] => x.cast[byte   .G.Opt[A & Any.Byte   ]].nonEmpty
        case _ : char   .G.Opt[A] => x.cast[char   .G.Opt[A & Any.Char   ]].nonEmpty
        case _ : short  .G.Opt[A] => x.cast[short  .G.Opt[A & Any.Short  ]].nonEmpty
        case _ : int    .G.Opt[A] => x.cast[int    .G.Opt[A & Any.Int    ]].nonEmpty
        case _ : long   .G.Opt[A] => x.cast[long   .G.Opt[A & Any.Long   ]].nonEmpty
        case _ : float  .G.Opt[A] => x.cast[float  .G.Opt[A & Any.Float  ]].nonEmpty
        case _ : double .G.Opt[A] => x.cast[double .G.Opt[A & Any.Double ]].nonEmpty
        case _ : Val.Opt[A]       => x.cast[Val.Opt[A]].nonEmpty

      inline def VAL: A = inline x match
        case _ : boolean.G.Opt[A] => x.cast[boolean.G.Opt[A & Any.Boolean]].`val`
        case _ : byte   .G.Opt[A] => x.cast[byte   .G.Opt[A & Any.Byte   ]].`val`
        case _ : char   .G.Opt[A] => x.cast[char   .G.Opt[A & Any.Char   ]].`val`
        case _ : short  .G.Opt[A] => x.cast[short  .G.Opt[A & Any.Short  ]].`val`
        case _ : int    .G.Opt[A] => x.cast[int    .G.Opt[A & Any.Int    ]].`val`
        case _ : long   .G.Opt[A] => x.cast[long   .G.Opt[A & Any.Long   ]].`val`
        case _ : float  .G.Opt[A] => x.cast[float  .G.Opt[A & Any.Float  ]].`val`
        case _ : double .G.Opt[A] => x.cast[double .G.Opt[A & Any.Double ]].`val`
        case v:       Val.Opt[A] => x.cast[      Val.Opt[A              ]].`val`

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
