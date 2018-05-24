package scalqa

import scala.language.higherKinds

package object Pipe extends Z.Create {
  type Interface[+A] = Interface._Trait[A]
  type Flow[A] = Flow._Class[A]
  type From[-CONTAINER[Any]] = From._Class[CONTAINER]
  

  // private[Pipe] no frills access to Metadata
  private[Pipe] implicit class zzMetadataFlow[A](val v: Pipe.Flow[A]) extends AnyVal {
    private def opt = v.I.letAs(classOf[Z.FlowWithMetadata[A]])
    def isMutable = opt.map(_.isMutable) or v.metadata.isMutable
    def sizeOpt = opt.map(_.sizeOpt) or v.metadata.sizeOpt
    def tagOpt = opt.map(_.tagOpt) or v.metadata.tagOpt
    def sortingOpt = opt.map(_.sortingOpt) or v.metadata.sortingOpt
    def sortingByOpt[B] = opt.map(_.sortingByOpt[B]) or v.metadata.sortingByOpt[B]
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @object Pipe ->
 *
 *    There are many ways to create [[Pipe]] besides ''get'' constructors
 *
 *     {{{
 *      val p: ~[Int] = 4 ~ 5 ~ 6 ~ 7 ~ 8   // Series of '~' operators, first on Any, then on resulting Pipe
 *      p lp                                // Prints: ~(4, 5, 6, 7, 8)
 *
 *      val d = ~[Double] ~ 12 ~ 10L ~ 1D   // Pipe with forced Double type
 *      d lp                                // Prints: ~(12.0, 10.0, 1.0)
 *
 *      val r: ~[Int] = 10 <> 12            // From Range, which can be implicitly converted to Pipe.Interface
 *      r lp                                // Prints: ~(10, 11, 12)
 *
 *      val v1 = ~[Int]                     // Create void pipe with explicit type
 *      v1 lp                               // Prints: void
 *
 *      val v2: ~[Int] = \/                 // Create void pipe with context type
 *      v2 lp                               // Prints: void
 *    }}}
 */
