package scalqa; package lang; package byte; package custom;  package containers; package companion; import language.implicitConversions

class Fun[A<:RAW]:
  type Fold                             = g.Fun.Fold[A]
  type FoldAs[T]                        = g.Fun.FoldAs[T,A]
  type Consume[U]                       = g.Fun.Consume[A,U]
  type Filter                           = g.Fun.Filter[A]
  type Revise                           = g.Fun.Revise[A]
  type FromAny[T]                       = g.Fun.FromAny[T,A]
  type ToAny[B]                         = g.Fun.ToAny[A,B]
  type ToMany[B]                        = g.Fun.ToMany[A,B]
  type ToRawBoolean[B<:Any.Raw.Boolean] = g.Fun.ToRawBoolean[A,B];     type ToBoolean = g.Fun.ToRawBoolean[A,Boolean]
  type ToRawByte   [B<:Any.Raw.Byte   ] = g.Fun.ToRawByte[A,B];        type ToByte    = g.Fun.ToRawByte   [A,Byte]
  type ToRawChar   [B<:Any.Raw.Char   ] = g.Fun.ToRawChar[A,B];        type ToChar    = g.Fun.ToRawChar   [A,Char]
  type ToRawShort  [B<:Any.Raw.Short  ] = g.Fun.ToRawShort[A,B];       type ToShort   = g.Fun.ToRawShort  [A,Short]
  type ToRawInt    [B<:Any.Raw.Int    ] = g.Fun.ToRawInt[A,B];         type ToInt     = g.Fun.ToRawInt    [A,Int]
  type ToRawLong   [B<:Any.Raw.Long   ] = g.Fun.ToRawLong[A,B];        type ToLong    = g.Fun.ToRawLong   [A,Long]
  type ToRawFloat  [B<:Any.Raw.Float  ] = g.Fun.ToRawFloat[A,B];       type ToFloat   = g.Fun.ToRawFloat  [A,Float]
  type ToRawDouble [B<:Any.Raw.Double ] = g.Fun.ToRawDouble[A,B];      type ToDouble  = g.Fun.ToRawDouble [A,Double]

object Fun extends Fun[SELF]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
