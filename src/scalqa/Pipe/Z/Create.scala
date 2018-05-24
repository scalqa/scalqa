package scalqa; package Pipe; package Z

import scala.language.higherKinds

private[Pipe] class Create {

  def get[A]: Pipe[A] = \/

  def get[A](vs: A*): Pipe[A] = vs match {
    case a: scala.collection.mutable.WrappedArray[_] => new Array.Z.all.Public[A](a.array.cast) { override def isMutable = false }
    case _ => vs.all
  }

  def getFrom[A, B[A]](c: B[A])(implicit v: Pipe.From[B]): Pipe[A] = v(c)

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def getFrom -> From container
 *
 *   Creates Pipe from a general container, for which there is implicit converter [[Pipe.From]]
 *
 *   {{{
 *     ~.getFrom( scala.List(1,2,3) ) lp  // Prints: ~(1, 2, 3)
 *   }}}
 *
 * @def get[A]( -> Pipe of elements
 *
 *   Returns specified elements as a [[Pipe]]
 *
 *   Note: Element type is determined by lowest common parent type down to [[Any]]
 *
 *   {{{
 *       *(1, 3, 5, 7) lp    // Prints: ~(1, 3, 5, 7)
 *
 *       *('a', 'b', 'c') lp // Prints: ~(a, b, c)
 *
 *       *('a', 1, 12.34) lp // Prints: ~(97.0, 1.0, 12.34)
 *
 *       *("a", 1, 12.34) lp // Prints: ~(a, 1, 12.34)
 *   }}}
 *
 * @def get[A]: -> Void pipe
 *
 *   Returns void pipe of the specified type
 *
 *   {{{
 *       val a1 = ~[Int]        // Explicit type
 *       val a2 : ~[Int] = \/   // Context type
 *
 *       a1 lp // Prints: void
 *   }}}
 */
