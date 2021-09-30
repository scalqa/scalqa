package scalqa; package lang; package anyref; package g; import language.implicitConversions

object Fun:
  trait ToAnyBoolean[A, B<:Any.Boolean]{ def apply(v:A): B };       type  ToBoolean[A] = ToAnyBoolean[A,Boolean]
  trait ToAnyByte   [A, B<:Any.Byte   ]{ def apply(v:A): B };       type  ToByte   [A] = ToAnyByte   [A,Byte]
  trait ToAnyChar   [A, B<:Any.Char   ]{ def apply(v:A): B };       type  ToChar   [A] = ToAnyChar   [A,Char]
  trait ToAnyShort  [A, B<:Any.Short  ]{ def apply(v:A): B };       type  ToShort  [A] = ToAnyShort  [A,Short]
  trait ToAnyInt    [A, B<:Any.Int    ]{ def apply(v:A): B };       type  ToInt    [A] = ToAnyInt    [A,Int]
  trait ToAnyLong   [A, B<:Any.Long   ]{ def apply(v:A): B };       type  ToLong   [A] = ToAnyLong   [A,Long]
  trait ToAnyFloat  [A, B<:Any.Float  ]{ def apply(v:A): B };       type  ToFloat  [A] = ToAnyFloat  [A,Float]
  trait ToAnyDouble [A, B<:Any.Double ]{ def apply(v:A): B };       type  ToDouble [A] = ToAnyDouble [A,Double]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
