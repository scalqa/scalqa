package scalqa; package lang; package array; package z; import language.implicitConversions

object joinAllAt:

  inline def apply[A](x: Array[A], inline i: Int, inline v: Stream[A])(using inline A: Specialized[A]): A.Array =
    inline A match
      case _ : Specialized[A&Any.Boolean] => {val a=x.cast[Array[Boolean]]; boolean.g.Buffer.z_ArrayJoinAllAt(a,i,v.cast[Stream[Boolean]],a.length).cast[A.Array] }
      case _ : Specialized[A&Any.Byte   ] => {val a=x.cast[Array[Byte   ]]; byte   .g.Buffer.z_ArrayJoinAllAt(a,i,v.cast[Stream[Byte   ]],a.length).cast[A.Array] }
      case _ : Specialized[A&Any.Char   ] => {val a=x.cast[Array[Char   ]]; char   .g.Buffer.z_ArrayJoinAllAt(a,i,v.cast[Stream[Char   ]],a.length).cast[A.Array] }
      case _ : Specialized[A&Any.Short  ] => {val a=x.cast[Array[Short  ]]; short  .g.Buffer.z_ArrayJoinAllAt(a,i,v.cast[Stream[Short  ]],a.length).cast[A.Array] }
      case _ : Specialized[A&Any.Int    ] => {val a=x.cast[Array[Int    ]]; int    .g.Buffer.z_ArrayJoinAllAt(a,i,v.cast[Stream[Int    ]],a.length).cast[A.Array] }
      case _ : Specialized[A&Any.Long   ] => {val a=x.cast[Array[Long   ]]; long   .g.Buffer.z_ArrayJoinAllAt(a,i,v.cast[Stream[Long   ]],a.length).cast[A.Array] }
      case _ : Specialized[A&Any.Float  ] => {val a=x.cast[Array[Float  ]]; float  .g.Buffer.z_ArrayJoinAllAt(a,i,v.cast[Stream[Float  ]],a.length).cast[A.Array] }
      case _ : Specialized[A&Any.Double ] => {val a=x.cast[Array[Double ]]; double .g.Buffer.z_ArrayJoinAllAt(a,i,v.cast[Stream[Double ]],a.length).cast[A.Array] }
      case _ : Specialized[A&AnyRef     ] => {val a=x.cast[Array[AnyRef ]]; anyref   .Buffer.z_ArrayJoinAllAt(a,i,v.cast[Stream[AnyRef ]],a.length).cast[A.Array] }
      case _                              => any(x,i,v).cast[A.Array]

  def any[A](x: Array[A], i:Int, v: Stream[A]): Array[A] =
    x match
       case x: Array[AnyRef]     => anyref   .Buffer.z_ArrayJoinAllAt(x,i,v,x.length)
       case x: Array[Int]        => int    .g.Buffer.z_ArrayJoinAllAt(x,i,v,x.length)
       case x: Array[Double]     => double .g.Buffer.z_ArrayJoinAllAt(x,i,v,x.length)
       case x: Array[Long]       => long   .g.Buffer.z_ArrayJoinAllAt(x,i,v,x.length)
       case x: Array[Float]      => float  .g.Buffer.z_ArrayJoinAllAt(x,i,v,x.length)
       case x: Array[Char]       => char   .g.Buffer.z_ArrayJoinAllAt(x,i,v,x.length)
       case x: Array[Byte]       => byte   .g.Buffer.z_ArrayJoinAllAt(x,i,v,x.length)
       case x: Array[Short]      => short  .g.Buffer.z_ArrayJoinAllAt(x,i,v,x.length)
       case x: Array[Boolean]    => boolean.g.Buffer.z_ArrayJoinAllAt(x,i,v,x.length)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
