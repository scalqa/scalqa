package scalqa; package lang; package any; package z; import language.implicitConversions

object range:

  inline def apply[A](inline from: A, inline to: A)(using inline o:Ordering[A])(using inline s:Specialized[A]): s.Range =
    inline s match
      case _ : Specialized[A & Any.Byte  ] => new Byte  .G.Range[A & Byte  ](from.cast[A & Byte  ],to.cast[A & Byte  ],true).cast[s.Range]
      case _ : Specialized[A & Any.Char  ] => new Char  .G.Range[A & Char  ](from.cast[A & Char  ],to.cast[A & Char  ],true).cast[s.Range]
      case _ : Specialized[A & Any.Short ] => new Short .G.Range[A & Short ](from.cast[A & Short ],to.cast[A & Short ],true).cast[s.Range]
      case _ : Specialized[A & Any.Int   ] => new Int   .G.Range[A & Int   ](from.cast[A & Int   ],to.cast[A & Int   ],true).cast[s.Range]
      case _ : Specialized[A & Any.Long  ] => new Long  .G.Range[A & Long  ](from.cast[A & Long  ],to.cast[A & Long  ],true).cast[s.Range]
      case _ : Specialized[A & Any.Float ] => new Float .G.Range[A & Float ](from.cast[A & Float ],to.cast[A & Float ],true).cast[s.Range]
      case _ : Specialized[A & Any.Double] => new Double.G.Range[A & Double](from.cast[A & Double],to.cast[A & Double],true).cast[s.Range]
      case _ : Specialized[A             ] => Val.Range(from,to,true).cast[s.Range]

  inline def exclusive[A](inline from: A, inline to: A)(using inline o:Ordering[A])(using inline s:Specialized[A]): s.Range =
    inline s match
      case _ : Specialized[A & Any.Byte  ] => new Byte  .G.Range[A & Byte  ](from.cast[A & Byte  ],to.cast[A & Byte  ],false).cast[s.Range]
      case _ : Specialized[A & Any.Char  ] => new Char  .G.Range[A & Char  ](from.cast[A & Char  ],to.cast[A & Char  ],false).cast[s.Range]
      case _ : Specialized[A & Any.Short ] => new Short .G.Range[A & Short ](from.cast[A & Short ],to.cast[A & Short ],false).cast[s.Range]
      case _ : Specialized[A & Any.Int   ] => new Int   .G.Range[A & Int   ](from.cast[A & Int   ],to.cast[A & Int   ],false).cast[s.Range]
      case _ : Specialized[A & Any.Long  ] => new Long  .G.Range[A & Long  ](from.cast[A & Long  ],to.cast[A & Long  ],false).cast[s.Range]
      case _ : Specialized[A & Any.Float ] => new Float .G.Range[A & Float ](from.cast[A & Float ],to.cast[A & Float ],false).cast[s.Range]
      case _ : Specialized[A & Any.Double] => new Double.G.Range[A & Double](from.cast[A & Double],to.cast[A & Double],false).cast[s.Range]
      case _ : Specialized[A             ] => Val.Range(from,to,false).cast[s.Range]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
