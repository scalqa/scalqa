package scalqa; package lang; package any; package z; import language.implicitConversions

import Gen.Given.RangeTag

object range:

  inline def apply[A,RANGE<: <>.AnyType[A]](inline from: A, inline to: A, inline c:Ordering[A], inline t: RangeTag[A,RANGE] ): RANGE =
    inline t match
      case _ : RangeTag[A,Byte   .G.<>[A]] => new Byte  .G.<>[A & Byte  ](from.cast[A & Byte  ],to.cast[A & Byte  ],true).cast[RANGE]
      case _ : RangeTag[A,Char   .G.<>[A]] => new Char  .G.<>[A & Char  ](from.cast[A & Char  ],to.cast[A & Char  ],true).cast[RANGE]
      case _ : RangeTag[A,Short  .G.<>[A]] => new Short .G.<>[A & Short ](from.cast[A & Short ],to.cast[A & Short ],true).cast[RANGE]
      case _ : RangeTag[A,Int    .G.<>[A]] => new Int   .G.<>[A & Int   ](from.cast[A & Int   ],to.cast[A & Int   ],true).cast[RANGE]
      case _ : RangeTag[A,Long   .G.<>[A]] => new Long  .G.<>[A & Long  ](from.cast[A & Long  ],to.cast[A & Long  ],true).cast[RANGE]
      case _ : RangeTag[A,Float  .G.<>[A]] => new Float .G.<>[A & Float ](from.cast[A & Float ],to.cast[A & Float ],true).cast[RANGE]
      case _ : RangeTag[A,Double .G.<>[A]] => new Double.G.<>[A & Double](from.cast[A & Double],to.cast[A & Double],true).cast[RANGE]
      case _ : RangeTag[A,      Val.<>[A]] => Val.<>(from,to,true)(using c)

  inline def exclusive[A,RANGE<: <>.AnyType[A]](inline from: A, inline to: A, inline c:Ordering[A], inline t: RangeTag[A,RANGE] ): RANGE =
    inline t match
      case _ : RangeTag[A,Byte   .G.<>[A]] => new Byte  .G.<>[A & Byte  ](from.cast[A & Byte  ],to.cast[A & Byte  ],false).cast[RANGE]
      case _ : RangeTag[A,Char   .G.<>[A]] => new Char  .G.<>[A & Char  ](from.cast[A & Char  ],to.cast[A & Char  ],false).cast[RANGE]
      case _ : RangeTag[A,Short  .G.<>[A]] => new Short .G.<>[A & Short ](from.cast[A & Short ],to.cast[A & Short ],false).cast[RANGE]
      case _ : RangeTag[A,Int    .G.<>[A]] => new Int   .G.<>[A & Int   ](from.cast[A & Int   ],to.cast[A & Int   ],false).cast[RANGE]
      case _ : RangeTag[A,Long   .G.<>[A]] => new Long  .G.<>[A & Long  ](from.cast[A & Long  ],to.cast[A & Long  ],false).cast[RANGE]
      case _ : RangeTag[A,Float  .G.<>[A]] => new Float .G.<>[A & Float ](from.cast[A & Float ],to.cast[A & Float ],false).cast[RANGE]
      case _ : RangeTag[A,Double .G.<>[A]] => new Double.G.<>[A & Double](from.cast[A & Double],to.cast[A & Double],false).cast[RANGE]
      case _ : RangeTag[A,      Val.<>[A]] => Val.<>(from,to,false)(using c)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
