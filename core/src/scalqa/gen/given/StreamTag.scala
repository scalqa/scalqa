package scalqa; package gen; package `given`; import language.implicitConversions

class  StreamTag[A, STREAM <: ~~.AnyType[A]]

object StreamTag extends zStreamTagDefault:
  inline given givenBoolean   [A<:Any.Raw.Boolean] : StreamTag[A,Boolean.G.~[A]] = new StreamTag[A, Boolean.G.~[A]]
  inline given givenByte      [A<:Any.Raw.Byte   ] : StreamTag[A,Byte   .G.~[A]] = new StreamTag[A, Byte   .G.~[A]]
  inline given givenChar      [A<:Any.Raw.Char   ] : StreamTag[A,Char   .G.~[A]] = new StreamTag[A, Char   .G.~[A]]
  inline given givenShort     [A<:Any.Raw.Short  ] : StreamTag[A,Short  .G.~[A]] = new StreamTag[A, Short  .G.~[A]]
  inline given givenInt       [A<:Any.Raw.Int    ] : StreamTag[A,Int    .G.~[A]] = new StreamTag[A, Int    .G.~[A]]
  inline given givenLong      [A<:Any.Raw.Long   ] : StreamTag[A,Long   .G.~[A]] = new StreamTag[A, Long   .G.~[A]]
  inline given givenFloat     [A<:Any.Raw.Float  ] : StreamTag[A,Float  .G.~[A]] = new StreamTag[A, Float  .G.~[A]]
  inline given givenDouble    [A<:Any.Raw.Double ] : StreamTag[A,Double .G.~[A]] = new StreamTag[A, Double .G.~[A]]
  inline given givenRef       [A<:Any.Ref]         : StreamTag[A,      Val.~[A]] = new StreamTag[A,       Val.~[A]]

  // ********************************************************************************************************************************************
  class  Raw[A, RAW <: ~~.RawType[A]] extends StreamTag[A,RAW]
  object Raw:
    inline given givenBoolean   [A<:Any.Raw.Boolean] : Raw[A,Boolean.G.~[A]] = new Raw[A,Boolean.G.~[A]]
    inline given givenByte      [A<:Any.Raw.Byte   ] : Raw[A,Byte   .G.~[A]] = new Raw[A,Byte   .G.~[A]]
    inline given givenChar      [A<:Any.Raw.Char   ] : Raw[A,Char   .G.~[A]] = new Raw[A,Char   .G.~[A]]
    inline given givenShort     [A<:Any.Raw.Short  ] : Raw[A,Short  .G.~[A]] = new Raw[A,Short  .G.~[A]]
    inline given givenInt       [A<:Any.Raw.Int    ] : Raw[A,Int    .G.~[A]] = new Raw[A,Int    .G.~[A]]
    inline given givenLong      [A<:Any.Raw.Long   ] : Raw[A,Long   .G.~[A]] = new Raw[A,Long   .G.~[A]]
    inline given givenFloat     [A<:Any.Raw.Float  ] : Raw[A,Float  .G.~[A]] = new Raw[A,Float  .G.~[A]]
    inline given givenDouble    [A<:Any.Raw.Double ] : Raw[A,Double .G.~[A]] = new Raw[A,Double .G.~[A]]

  // ********************************************************************************************************************************************
  class  Opt[A, OPT <: Val.Opt.AnyType[A], STREAM <: ~~.AnyType[A]]
  object Opt extends zOptTagDefault:
    inline given givenBoolean   [A<:Any.Raw.Boolean] : Opt[A,Boolean.G.Opt[A], Boolean.G.~[A]] = new Opt[A,Boolean.G.Opt[A], Boolean.G.~[A]]
    inline given givenByte      [A<:Any.Raw.Byte   ] : Opt[A,Byte   .G.Opt[A], Byte   .G.~[A]] = new Opt[A,Byte   .G.Opt[A], Byte   .G.~[A]]
    inline given givenChar      [A<:Any.Raw.Char   ] : Opt[A,Char   .G.Opt[A], Char   .G.~[A]] = new Opt[A,Char   .G.Opt[A], Char   .G.~[A]]
    inline given givenShort     [A<:Any.Raw.Short  ] : Opt[A,Short  .G.Opt[A], Short  .G.~[A]] = new Opt[A,Short  .G.Opt[A], Short  .G.~[A]]
    inline given givenInt       [A<:Any.Raw.Int    ] : Opt[A,Int    .G.Opt[A], Int    .G.~[A]] = new Opt[A,Int    .G.Opt[A], Int    .G.~[A]]
    inline given givenLong      [A<:Any.Raw.Long   ] : Opt[A,Long   .G.Opt[A], Long   .G.~[A]] = new Opt[A,Long   .G.Opt[A], Long   .G.~[A]]
    inline given givenFloat     [A<:Any.Raw.Float  ] : Opt[A,Float  .G.Opt[A], Float  .G.~[A]] = new Opt[A,Float  .G.Opt[A], Float  .G.~[A]]
    inline given givenDouble    [A<:Any.Raw.Double ] : Opt[A,Double .G.Opt[A], Double .G.~[A]] = new Opt[A,Double .G.Opt[A], Double .G.~[A]]

    inline given givenRefBoolean[A<:Any.Raw.Boolean] : Opt[A,      Val.Opt[A], Boolean.G.~[A]] = new Opt[A,      Val.Opt[A], Boolean.G.~[A]]
    inline given givenRefByte   [A<:Any.Raw.Byte   ] : Opt[A,      Val.Opt[A], Byte   .G.~[A]] = new Opt[A,      Val.Opt[A], Byte   .G.~[A]]
    inline given givenRefChar   [A<:Any.Raw.Char   ] : Opt[A,      Val.Opt[A], Char   .G.~[A]] = new Opt[A,      Val.Opt[A], Char   .G.~[A]]
    inline given givenRefShort  [A<:Any.Raw.Short  ] : Opt[A,      Val.Opt[A], Short  .G.~[A]] = new Opt[A,      Val.Opt[A], Short  .G.~[A]]
    inline given givenRefInt    [A<:Any.Raw.Int    ] : Opt[A,      Val.Opt[A], Int    .G.~[A]] = new Opt[A,      Val.Opt[A], Int    .G.~[A]]
    inline given givenRefLong   [A<:Any.Raw.Long   ] : Opt[A,      Val.Opt[A], Long   .G.~[A]] = new Opt[A,      Val.Opt[A], Long   .G.~[A]]
    inline given givenRefFloat  [A<:Any.Raw.Float  ] : Opt[A,      Val.Opt[A], Float  .G.~[A]] = new Opt[A,      Val.Opt[A], Float  .G.~[A]]
    inline given givenRefDouble [A<:Any.Raw.Double ] : Opt[A,      Val.Opt[A], Double .G.~[A]] = new Opt[A,      Val.Opt[A], Double .G.~[A]]
    inline given givenRef       [A<:Any.Ref        ] : Opt[A,      Val.Opt[A],       Val.~[A]] = new Opt[A,      Val.Opt[A],       Val.~[A]]
  private[`given`] class zOptTagDefault:
    inline given givenAny       [A                 ] : Opt[A,      Val.Opt[A],       Val.~[A]] = new Opt[A,      Val.Opt[A],       Val.~[A]]

// **********************************************************************************************************************************************
private[`given`] class zStreamTagDefault:
  inline given givenAny[A]: StreamTag[A, Val.~[A]] = new StreamTag[A, Val.~[A]]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
