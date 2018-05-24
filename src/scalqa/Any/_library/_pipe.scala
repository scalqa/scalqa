package scalqa; package Any; package _library

trait _pipe[A] extends Any with __[A] with _pipe.Like[A] {

  override def ~(value: A): ~[A] = new Pipe.Z.The.Two[A](This, Opt.getNullAble(value))

  override def ~~(that: ~[A]): ~[A] = if (that == null) This.I.~ else that ~@ (0, This)

}

private[scalqa] object _pipe {

  trait Like[A] extends Any {

    def ~(v: A): ~[A]

    def ~~(t: ~[A]): ~[A]

  }
}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait _pipe -> '''Piping'''
 *
 *     These are piping operations attached to ''every'' single object in Scalqa
 *
 *     These methods are similar to those available on [[Pipe]] itself
 *
 *     So the [[Pipe]] building chain can start with a single object
 *
 *     {{{
 *       val pipe = 1 ~ 3 ~ 5 ~ 7 ~ 9
 *
 *       pipe lp // Prints: ~(1, 3, 5, 7, 9)
 *     }}}
 *
 * @def ~(value: -> Pipe of two elements
 *
 *   Creates a [[Pipe]] with two elements ''this'' and ''value''
 *
 *   {{{
 *       1 ~ 2 lp                  // Prints: ~(1, 2)
 *
 *       'A' ~ 'Z' lp              // Prints: ~(A, Z)
 *
 *       "aaa" ~ "bbb" ~ "ccc" lp  // Prints: ~(aaa, bbb, ccc)
 *   }}}
 *
 * @def ~~(that: -> Pipe of ''this'' with ''that''
 *
 *   Creates a [[Pipe]] with ''this'' and elements of pipe ''that''
 *
 *   {{{
 *       1 ~~ (2 <> 5) lp                // Prints: ~(1, 2, 3, 4, 5)
 *
 *       'A' ~~ ('B' ~ 'C') lp           // Prints: ~(A, B, C)
 *
 *       "aa" ~~ *("bb","cc","dd") lp  // Prints: ~(aa, bb, cc, dd)
 *   }}}
 */
