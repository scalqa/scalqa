package scalqa; package Stream; package Interface; package Function

trait Mapping[@specialized(DATA) -A, @specialized(DATA) +B] extends Any with Mapping.Z.RefPrim[A, B] with Mapping.Z.PrimRef[A, B] {

  def apply(v: A): B

}

object Mapping {

  implicit def zzAsIs[A]: Mapping[A, A] = AS_IS

  // ***********************************************************************
  trait Idx[@specialized(DATA) -A, @specialized(DATA) +B] {

    def apply(i: Int, v: A): B

  }

  // ***********************************************************************
  private[scalqa] object Z {

    trait PrimRef[@specialized(DATA) -A, +B] extends Any { def apply(v: A): B }

    trait RefPrim[-A, @specialized(DATA) +B] extends Any { def apply(v: A): B }
  }
}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait Mapping -> `Mapping[A,B]` &nbsp; is a specialized equivalent of &nbsp; `A => B` &nbsp;  function and can be used in similar manner including syntactic sugar
 *
 *   {{{
 *     def map(f : Mapping[Int, Double]) : List
 *
 *     map(_.toDouble)
 *   }}}
 *
 * @trait Idx -> `Mapping.Idx[A,B]` &nbsp; is a specialized equivalent of &nbsp; `(Int, A) => B` &nbsp; function and can be used in similar manner including syntactic sugar
 *
 *   {{{
 *     def map(f : Mapping.Idx[String,String]) : List
 *
 *     map((i,s) => " " * i + s) // Pad front
 *   }}}
 */
