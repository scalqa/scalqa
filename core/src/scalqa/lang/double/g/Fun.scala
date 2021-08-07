package scalqa; package lang; package double; package g; import language.implicitConversions

object Fun:
  trait Fold        [A<:Raw]                { def apply(v:A, w:A) : A        }
  trait FoldAs      [T, A<:Raw]             { def apply(v:T, w:A) : T        }
  trait Consume     [A<:Raw, U]             { def apply(v:A)      : U        }
  trait Filter      [A<:Raw]                { def apply(v:A)      : Boolean  }
  trait Revise      [A<:Raw]                { def apply(v:A)      : A        }
  trait FromAny     [T, A<:Raw]             { def apply(v:T)      : A        }
  trait ToAny       [A<:Raw, B]             { def apply(v:A)      : B        }
  trait ToMany      [A<:Raw, B]             { def apply(v:A)      : Val.~[B] }
  trait ToBooleanRaw[A<:Raw, B<:Boolean.Raw]{ def apply(v:A)      : B        };       type  ToBoolean[A<:Raw] = ToBooleanRaw[A,Boolean]
  trait ToByteRaw   [A<:Raw, B<:Byte.Raw   ]{ def apply(v:A)      : B        };       type  ToByte   [A<:Raw] = ToByteRaw   [A,Byte]
  trait ToCharRaw   [A<:Raw, B<:Char.Raw   ]{ def apply(v:A)      : B        };       type  ToChar   [A<:Raw] = ToCharRaw   [A,Char]
  trait ToShortRaw  [A<:Raw, B<:Short.Raw  ]{ def apply(v:A)      : B        };       type  ToShort  [A<:Raw] = ToShortRaw  [A,Short]
  trait ToIntRaw    [A<:Raw, B<:Int.Raw    ]{ def apply(v:A)      : B        };       type  ToInt    [A<:Raw] = ToIntRaw    [A,Int]
  trait ToLongRaw   [A<:Raw, B<:Long.Raw   ]{ def apply(v:A)      : B        };       type  ToLong   [A<:Raw] = ToLongRaw   [A,Long]
  trait ToFloatRaw  [A<:Raw, B<:Float.Raw  ]{ def apply(v:A)      : B        };       type  ToFloat  [A<:Raw] = ToFloatRaw  [A,Float]
  trait ToDoubleRaw [A<:Raw, B<:Double.Raw ]{ def apply(v:A)      : B        };       type  ToDouble [A<:Raw] = ToDoubleRaw [A,Double]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
