package scalqa; package lang; package array; package z; import language.implicitConversions

import java.util.{ Arrays }

object range:

  inline def take[A](inline x: Array[A], s:Int, inline sz: Int)(using inline A: Specialized[A]): A.Array =
    inline A match
      case _ : Specialized[A&Any.Boolean] => Arrays.copyOfRange(x.cast[Array[Boolean]],s,s+sz).cast[A.Array]
      case _ : Specialized[A&Any.Byte   ] => Arrays.copyOfRange(x.cast[Array[Byte   ]],s,s+sz).cast[A.Array]
      case _ : Specialized[A&Any.Char   ] => Arrays.copyOfRange(x.cast[Array[Char   ]],s,s+sz).cast[A.Array]
      case _ : Specialized[A&Any.Short  ] => Arrays.copyOfRange(x.cast[Array[Short  ]],s,s+sz).cast[A.Array]
      case _ : Specialized[A&Any.Int    ] => Arrays.copyOfRange(x.cast[Array[Int    ]],s,s+sz).cast[A.Array]
      case _ : Specialized[A&Any.Long   ] => Arrays.copyOfRange(x.cast[Array[Long   ]],s,s+sz).cast[A.Array]
      case _ : Specialized[A&Any.Float  ] => Arrays.copyOfRange(x.cast[Array[Float  ]],s,s+sz).cast[A.Array]
      case _ : Specialized[A&Any.Double ] => Arrays.copyOfRange(x.cast[Array[Double ]],s,s+sz).cast[A.Array]
      case _ : Specialized[A&AnyRef     ] => Arrays.copyOfRange(x.cast[Array[AnyRef ]],s,s+sz).cast[A.Array]
      case _                              =>            takeAny(x.cast[Array[A]]      ,s,sz  ).cast[A.Array]

  def takeAny[A](x: Array[A], s:Int, sz: Int): Array[A] =
    x match
       case x: Array[AnyRef]     => Arrays.copyOfRange(x.cast[Array[AnyRef ]],s,s+sz).cast[Array[A]]
       case x: Array[Int]        => Arrays.copyOfRange(x.cast[Array[Int    ]],s,s+sz).cast[Array[A]]
       case x: Array[Double]     => Arrays.copyOfRange(x.cast[Array[Double ]],s,s+sz).cast[Array[A]]
       case x: Array[Long]       => Arrays.copyOfRange(x.cast[Array[Long   ]],s,s+sz).cast[Array[A]]
       case x: Array[Float]      => Arrays.copyOfRange(x.cast[Array[Float  ]],s,s+sz).cast[Array[A]]
       case x: Array[Char]       => Arrays.copyOfRange(x.cast[Array[Char   ]],s,s+sz).cast[Array[A]]
       case x: Array[Byte]       => Arrays.copyOfRange(x.cast[Array[Byte   ]],s,s+sz).cast[Array[A]]
       case x: Array[Short]      => Arrays.copyOfRange(x.cast[Array[Short  ]],s,s+sz).cast[Array[A]]
       case x: Array[Boolean]    => Arrays.copyOfRange(x.cast[Array[Boolean]],s,s+sz).cast[Array[A]]

  def drop[A](x: Array[A], start:Int, sz:Int)(using A: Specialized[A]): A.Array =
    val len = x.length
    val end = start+sz
    val a   = x.newArray(len - sz)
    System.arraycopy(x,0,a,0,start)
    System.arraycopy(x,end,a,start,len-end)
    a.cast[A.Array]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
