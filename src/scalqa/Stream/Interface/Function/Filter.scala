package scalqa; package Stream; package Interface; package Function

trait Filter[@specialized(DATA) -A] {

  def allow(v: A): Boolean

}

object Filter {

  trait Idx[@specialized(DATA) A] {

    def allow(i: Int, v: A): Boolean

  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait Filter -> `Filter[A]` &nbsp; is a specialized equivalent of &nbsp; `A => Boolean` &nbsp; function and can be used in similar manner including syntactic sugar
 *
 *   {{{
 *     def let(f : Filter[Int]): Unit
 *
 *     let(_ > 0)
 *   }}}
 *
 * @trait Idx -> `Filter.Idx[A]` &nbsp; is a specialized equivalent of &nbsp; `(Int, A) => Boolean` &nbsp; function and can be used in similar manner including syntactic sugar
 *
 *   {{{
 *     def let(f : Filter.Idx[String]): Unit
 *
 *     let((idx,str) => idx > 3 && idx < 10)
 *   }}}
 */
