package scalqa; package lang; package float; package g; import language.implicitConversions

object Fun:
  trait Fold        [A<:RAW]                { def apply(v:A, w:A) : A        }
  trait FoldAs      [T, A<:Raw]             { def apply(v:T, w:A) : T        }
  trait Consume     [A<:RAW, U]             { def apply(v:A)      : U        }
  trait Filter      [A<:RAW]                { def apply(v:A)      : Boolean  }
  trait Revise      [A<:RAW]                { def apply(v:A)      : A        }
  trait FromAny     [T, A<:Raw]             { def apply(v:T)      : A        }
  trait ToAny       [A<:RAW, B]             { def apply(v:A)      : B        }
  trait ToMany      [A<:RAW, B]             { def apply(v:A)      : Val.~[B] }
  trait ToRawBoolean[A<:RAW, B<:Raw.Boolean]{ def apply(v:A)      : B        };       type  ToBoolean[A<:RAW] = ToRawBoolean[A,Boolean]
  trait ToRawByte   [A<:RAW, B<:Raw.Byte   ]{ def apply(v:A)      : B        };       type  ToByte   [A<:RAW] = ToRawByte   [A,Byte]
  trait ToRawChar   [A<:RAW, B<:Raw.Char   ]{ def apply(v:A)      : B        };       type  ToChar   [A<:RAW] = ToRawChar   [A,Char]
  trait ToRawShort  [A<:RAW, B<:Raw.Short  ]{ def apply(v:A)      : B        };       type  ToShort  [A<:RAW] = ToRawShort  [A,Short]
  trait ToRawInt    [A<:RAW, B<:Raw.Int    ]{ def apply(v:A)      : B        };       type  ToInt    [A<:RAW] = ToRawInt    [A,Int]
  trait ToRawLong   [A<:RAW, B<:Raw.Long   ]{ def apply(v:A)      : B        };       type  ToLong   [A<:RAW] = ToRawLong   [A,Long]
  trait ToRawFloat  [A<:RAW, B<:Raw.Float  ]{ def apply(v:A)      : B        };       type  ToFloat  [A<:RAW] = ToRawFloat  [A,Float]
  trait ToRawDouble [A<:RAW, B<:Raw.Double ]{ def apply(v:A)      : B        };       type  ToDouble [A<:RAW] = ToRawDouble [A,Double]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
