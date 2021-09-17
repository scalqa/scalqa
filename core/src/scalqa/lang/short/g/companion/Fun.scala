package scalqa; package lang; package short; package g; package companion; import language.implicitConversions

class Fun[A<:Raw]:
  type Fold                         = G.Fun.Fold[A]
  type FoldAs[T]                    = G.Fun.FoldAs[T,A]
  type Consume[U]                   = G.Fun.Consume[A,U]
  type Filter                       = G.Fun.Filter[A]
  type Revise                       = G.Fun.Revise[A]
  type FromAny[T]                   = G.Fun.FromAny[T,A]
  type ToAny[B]                     = G.Fun.ToAny[A,B]
  type ToMany[B]                    = G.Fun.ToMany[A,B]
  type ToAnyBoolean[B<:Any.Boolean] = G.Fun.ToAnyBoolean[A,B];     type ToBoolean = G.Fun.ToAnyBoolean[A,Boolean]
  type ToAnyByte   [B<:Any.Byte   ] = G.Fun.ToAnyByte[A,B];        type ToByte    = G.Fun.ToAnyByte   [A,Byte]
  type ToAnyChar   [B<:Any.Char   ] = G.Fun.ToAnyChar[A,B];        type ToChar    = G.Fun.ToAnyChar   [A,Char]
  type ToAnyShort  [B<:Any.Short  ] = G.Fun.ToAnyShort[A,B];       type ToShort   = G.Fun.ToAnyShort  [A,Short]
  type ToAnyInt    [B<:Any.Int    ] = G.Fun.ToAnyInt[A,B];         type ToInt     = G.Fun.ToAnyInt    [A,Int]
  type ToAnyLong   [B<:Any.Long   ] = G.Fun.ToAnyLong[A,B];        type ToLong    = G.Fun.ToAnyLong   [A,Long]
  type ToAnyFloat  [B<:Any.Float  ] = G.Fun.ToAnyFloat[A,B];       type ToFloat   = G.Fun.ToAnyFloat  [A,Float]
  type ToAnyDouble [B<:Any.Double ] = G.Fun.ToAnyDouble[A,B];      type ToDouble  = G.Fun.ToAnyDouble [A,Double]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
