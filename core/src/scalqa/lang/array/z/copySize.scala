package scalqa; package lang; package array; package z; import language.implicitConversions

import java.util.Arrays

object copySize:

  inline def apply[A](inline x: Array[A], inline sz: Int)(using inline s: Specialized[A]): s.Array =
    inline s match
              case _ : Specialized[A&Any.Boolean] => Arrays.copyOf(x.cast[Array[Boolean]],sz).cast[s.Array]
              case _ : Specialized[A&Any.Byte   ] => Arrays.copyOf(x.cast[Array[Byte   ]],sz).cast[s.Array]
              case _ : Specialized[A&Any.Char   ] => Arrays.copyOf(x.cast[Array[Char   ]],sz).cast[s.Array]
              case _ : Specialized[A&Any.Short  ] => Arrays.copyOf(x.cast[Array[Short  ]],sz).cast[s.Array]
              case _ : Specialized[A&Any.Int    ] => Arrays.copyOf(x.cast[Array[Int    ]],sz).cast[s.Array]
              case _ : Specialized[A&Any.Long   ] => Arrays.copyOf(x.cast[Array[Long   ]],sz).cast[s.Array]
              case _ : Specialized[A&Any.Float  ] => Arrays.copyOf(x.cast[Array[Float  ]],sz).cast[s.Array]
              case _ : Specialized[A&Any.Double ] => Arrays.copyOf(x.cast[Array[Double ]],sz).cast[s.Array]
              case _ : Specialized[A&AnyRef     ] => Arrays.copyOf(x.cast[Array[AnyRef ]],sz).cast[s.Array]
              case _                              =>           any(x.cast[Array[A      ]],sz).cast[s.Array]

  def any[A](x: Array[A], sz:Int): Array[A] =
    x match
      case x: Array[AnyRef]     => Arrays.copyOf(x.cast[Array[AnyRef ]],sz).cast[Array[A]]
      case x: Array[Int]        => Arrays.copyOf(x.cast[Array[Int    ]],sz).cast[Array[A]]
      case x: Array[Double]     => Arrays.copyOf(x.cast[Array[Double ]],sz).cast[Array[A]]
      case x: Array[Long]       => Arrays.copyOf(x.cast[Array[Long   ]],sz).cast[Array[A]]
      case x: Array[Float]      => Arrays.copyOf(x.cast[Array[Float  ]],sz).cast[Array[A]]
      case x: Array[Char]       => Arrays.copyOf(x.cast[Array[Char   ]],sz).cast[Array[A]]
      case x: Array[Byte]       => Arrays.copyOf(x.cast[Array[Byte   ]],sz).cast[Array[A]]
      case x: Array[Short]      => Arrays.copyOf(x.cast[Array[Short  ]],sz).cast[Array[A]]
      case x: Array[Boolean]    => Arrays.copyOf(x.cast[Array[Boolean]],sz).cast[Array[A]]
      case _                    => J.illegalState()

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (A) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
