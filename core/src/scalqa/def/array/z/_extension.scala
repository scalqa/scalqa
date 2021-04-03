package scalqa; package `def`; package array; package z; import language.implicitConversions


transparent trait _extension extends array._extension :
  extension[A<:Raw.Boolean](inline x:Array[A]) @tn("stream_Boolean") inline def ~         : Boolean.G.~[A] & Able.Size = stream.Booleans(x.cast[Array[Boolean]])
  extension[A<:Raw.Boolean](inline x:Array[A]) @tn("stream_Boolean") inline def ~(sz:Int) : Boolean.G.~[A] & Able.Size = stream.Booleans(x.cast[Array[Boolean]],sz)
  extension[A<:Raw.Byte   ](inline x:Array[A]) @tn("stream_Byte")    inline def ~         : Byte   .G.~[A] & Able.Size = stream.Bytes(   x.cast[Array[Byte   ]])
  extension[A<:Raw.Byte   ](inline x:Array[A]) @tn("stream_Byte")    inline def ~(sz:Int) : Byte   .G.~[A] & Able.Size = stream.Bytes(   x.cast[Array[Byte   ]],sz)
  extension[A<:Raw.Char   ](inline x:Array[A]) @tn("stream_Char")    inline def ~         : Char   .G.~[A] & Able.Size = stream.Chars(   x.cast[Array[Char   ]])
  extension[A<:Raw.Char   ](inline x:Array[A]) @tn("stream_Char")    inline def ~(sz:Int) : Char   .G.~[A] & Able.Size = stream.Chars(   x.cast[Array[Char   ]],sz)
  extension[A<:Raw.Short  ](inline x:Array[A]) @tn("stream_Short")   inline def ~         : Short  .G.~[A] & Able.Size = stream.Shorts(  x.cast[Array[Short  ]])
  extension[A<:Raw.Short  ](inline x:Array[A]) @tn("stream_Short")   inline def ~(sz:Int) : Short  .G.~[A] & Able.Size = stream.Shorts(  x.cast[Array[Short  ]],sz)
  extension[A<:Raw.Int    ](inline x:Array[A]) @tn("stream_Int")     inline def ~         : Int    .G.~[A] & Able.Size = stream.Ints(    x.cast[Array[Int    ]])
  extension[A<:Raw.Int    ](inline x:Array[A]) @tn("stream_Int")     inline def ~(sz:Int) : Int    .G.~[A] & Able.Size = stream.Ints(    x.cast[Array[Int    ]],sz)
  extension[A<:Raw.Long   ](inline x:Array[A]) @tn("stream_Long")    inline def ~         : Long   .G.~[A] & Able.Size = stream.Longs(   x.cast[Array[Long   ]])
  extension[A<:Raw.Long   ](inline x:Array[A]) @tn("stream_Long")    inline def ~(sz:Int) : Long   .G.~[A] & Able.Size = stream.Longs(   x.cast[Array[Long   ]],sz)
  extension[A<:Raw.Float  ](inline x:Array[A]) @tn("stream_Float")   inline def ~         : Float  .G.~[A] & Able.Size = stream.Floats(  x.cast[Array[Float  ]])
  extension[A<:Raw.Float  ](inline x:Array[A]) @tn("stream_Float")   inline def ~(sz:Int) : Float  .G.~[A] & Able.Size = stream.Floats(  x.cast[Array[Float  ]],sz)
  extension[A<:Raw.Double ](inline x:Array[A]) @tn("stream_Double")  inline def ~         : Double .G.~[A] & Able.Size = stream.Doubles( x.cast[Array[Double ]])
  extension[A<:Raw.Double ](inline x:Array[A]) @tn("stream_Double")  inline def ~(sz:Int) : Double .G.~[A] & Able.Size = stream.Doubles( x.cast[Array[Double ]],sz)
  extension[A<:Ref        ](inline x:Array[A]) @tn("stream_Ref")     inline def ~         :       Val.~[A] & Able.Size = stream.Refs(    x.cast[Array[Ref    ]])
  extension[A<:Ref        ](inline x:Array[A]) @tn("stream_Ref")     inline def ~(sz:Int) :       Val.~[A] & Able.Size = stream.Refs(    x.cast[Array[Ref    ]],sz)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
