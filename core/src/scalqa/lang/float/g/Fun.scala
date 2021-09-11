package scalqa; package lang; package float; package g; import language.implicitConversions

object Fun:
  trait Fold        [A<:Raw]                { def apply(v:A, w:A) : A        }
  trait FoldAs      [T, A<:Raw]             { def apply(v:T, w:A) : T        }
  trait Consume     [A<:Raw, U]             { def apply(v:A)      : U        }
  trait Filter      [A<:Raw]                { def apply(v:A)      : Boolean  }
  trait Revise      [A<:Raw]                { def apply(v:A)      : A        }
  trait FromAny     [T, A<:Raw]             { def apply(v:T)      : A        }
  trait ToMany      [A<:Raw, B]             { def apply(v:A)      : Val.~[B] }
  trait ToAny       [A<:Raw, B]             { def apply(v:A)      : B        }
  trait ToAnyBoolean[A<:Raw, B<:Any.Boolean]{ def apply(v:A)      : B        };       type  ToBoolean[A<:Raw] = ToAnyBoolean[A,Boolean]
  trait ToAnyByte   [A<:Raw, B<:Any.Byte   ]{ def apply(v:A)      : B        };       type  ToByte   [A<:Raw] = ToAnyByte   [A,Byte]
  trait ToAnyChar   [A<:Raw, B<:Any.Char   ]{ def apply(v:A)      : B        };       type  ToChar   [A<:Raw] = ToAnyChar   [A,Char]
  trait ToAnyShort  [A<:Raw, B<:Any.Short  ]{ def apply(v:A)      : B        };       type  ToShort  [A<:Raw] = ToAnyShort  [A,Short]
  trait ToAnyInt    [A<:Raw, B<:Any.Int    ]{ def apply(v:A)      : B        };       type  ToInt    [A<:Raw] = ToAnyInt    [A,Int]
  trait ToAnyLong   [A<:Raw, B<:Any.Long   ]{ def apply(v:A)      : B        };       type  ToLong   [A<:Raw] = ToAnyLong   [A,Long]
  trait ToAnyFloat  [A<:Raw, B<:Any.Float  ]{ def apply(v:A)      : B        };       type  ToFloat  [A<:Raw] = ToAnyFloat  [A,Float]
  trait ToAnyDouble [A<:Raw, B<:Any.Double ]{ def apply(v:A)      : B        };       type  ToDouble [A<:Raw] = ToAnyDouble [A,Double]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
