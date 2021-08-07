package scalqa; package lang; package char; package g; package customized; package companion; import language.implicitConversions

class Fun[A<:Raw]:
  type Fold                         = G.Fun.Fold[A]
  type FoldAs[T]                    = G.Fun.FoldAs[T,A]
  type Consume[U]                   = G.Fun.Consume[A,U]
  type Filter                       = G.Fun.Filter[A]
  type Revise                       = G.Fun.Revise[A]
  type FromAny[T]                   = G.Fun.FromAny[T,A]
  type ToAny[B]                     = G.Fun.ToAny[A,B]
  type ToMany[B]                    = G.Fun.ToMany[A,B]
  type ToBooleanRaw[B<:Boolean.Raw] = G.Fun.ToBooleanRaw[A,B];     type ToBoolean = G.Fun.ToBooleanRaw[A,Boolean]
  type ToByteRaw   [B<:Byte.Raw   ] = G.Fun.ToByteRaw[A,B];        type ToByte    = G.Fun.ToByteRaw   [A,Byte]
  type ToCharRaw   [B<:Char.Raw   ] = G.Fun.ToCharRaw[A,B];        type ToChar    = G.Fun.ToCharRaw   [A,Char]
  type ToShortRaw  [B<:Short.Raw  ] = G.Fun.ToShortRaw[A,B];       type ToShort   = G.Fun.ToShortRaw  [A,Short]
  type ToIntRaw    [B<:Int.Raw    ] = G.Fun.ToIntRaw[A,B];         type ToInt     = G.Fun.ToIntRaw    [A,Int]
  type ToLongRaw   [B<:Long.Raw   ] = G.Fun.ToLongRaw[A,B];        type ToLong    = G.Fun.ToLongRaw   [A,Long]
  type ToFloatRaw  [B<:Float.Raw  ] = G.Fun.ToFloatRaw[A,B];       type ToFloat   = G.Fun.ToFloatRaw  [A,Float]
  type ToDoubleRaw [B<:Double.Raw ] = G.Fun.ToDoubleRaw[A,B];      type ToDouble  = G.Fun.ToDoubleRaw [A,Double]

object Fun extends Fun[Char]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
