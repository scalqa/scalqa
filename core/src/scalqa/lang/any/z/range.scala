package scalqa; package lang; package any; package z; import language.implicitConversions

object range:

  inline def apply[A](inline from: A, inline to: A)(using inline o:Ordering[A])(using inline A:Specialized[A]): A.<> =
    inline A match
      case _ : Specialized[A & Any.Byte  ] => new Byte  .G.<>[A & Byte  ](from.cast[A & Byte  ],to.cast[A & Byte  ],true).cast[A.<>]
      case _ : Specialized[A & Any.Char  ] => new Char  .G.<>[A & Char  ](from.cast[A & Char  ],to.cast[A & Char  ],true).cast[A.<>]
      case _ : Specialized[A & Any.Short ] => new Short .G.<>[A & Short ](from.cast[A & Short ],to.cast[A & Short ],true).cast[A.<>]
      case _ : Specialized[A & Any.Int   ] => new Int   .G.<>[A & Int   ](from.cast[A & Int   ],to.cast[A & Int   ],true).cast[A.<>]
      case _ : Specialized[A & Any.Long  ] => new Long  .G.<>[A & Long  ](from.cast[A & Long  ],to.cast[A & Long  ],true).cast[A.<>]
      case _ : Specialized[A & Any.Float ] => new Float .G.<>[A & Float ](from.cast[A & Float ],to.cast[A & Float ],true).cast[A.<>]
      case _ : Specialized[A & Any.Double] => new Double.G.<>[A & Double](from.cast[A & Double],to.cast[A & Double],true).cast[A.<>]
      case _ : Specialized[A             ] => Val.<>(from,to,true).cast[A.<>]

  inline def exclusive[A](inline from: A, inline to: A)(using inline o:Ordering[A])(using inline A:Specialized[A]): A.<> =
    inline A match
      case _ : Specialized[A & Any.Byte  ] => new Byte  .G.<>[A & Byte  ](from.cast[A & Byte  ],to.cast[A & Byte  ],false).cast[A.<>]
      case _ : Specialized[A & Any.Char  ] => new Char  .G.<>[A & Char  ](from.cast[A & Char  ],to.cast[A & Char  ],false).cast[A.<>]
      case _ : Specialized[A & Any.Short ] => new Short .G.<>[A & Short ](from.cast[A & Short ],to.cast[A & Short ],false).cast[A.<>]
      case _ : Specialized[A & Any.Int   ] => new Int   .G.<>[A & Int   ](from.cast[A & Int   ],to.cast[A & Int   ],false).cast[A.<>]
      case _ : Specialized[A & Any.Long  ] => new Long  .G.<>[A & Long  ](from.cast[A & Long  ],to.cast[A & Long  ],false).cast[A.<>]
      case _ : Specialized[A & Any.Float ] => new Float .G.<>[A & Float ](from.cast[A & Float ],to.cast[A & Float ],false).cast[A.<>]
      case _ : Specialized[A & Any.Double] => new Double.G.<>[A & Double](from.cast[A & Double],to.cast[A & Double],false).cast[A.<>]
      case _ : Specialized[A             ] => Val.<>(from,to,false).cast[A.<>]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
