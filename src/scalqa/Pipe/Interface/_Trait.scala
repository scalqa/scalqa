package scalqa; package Pipe; package Interface

trait _Trait[+A] {

  protected def supplyOpt: Opt[A]

}

object _Trait extends Able.Void.Companion.Typed[Interface](scalqa.Pipe.The.Void) {

  @inline private[Pipe] def supplyOpt[A](a: Interface[A]) = a.supplyOpt

  import scala.language.implicitConversions

  implicit def zzGet[A](v: scala.Array[A]): Pipe[A] = getFrom(v)
  implicit def zzGet[A](v: scala.TraversableOnce[A]): Pipe[A] = getFrom(v)
  implicit def zzGet[A](v: java.util.Iterator[A]): Pipe[A] = getFrom(v)
  implicit def zzGet[A](v: java.util.Collection[A]): Pipe[A] = getFrom(v)
  implicit def zzGet[A](v: java.util.Spliterator[A]): Pipe[A] = getFrom(v)
  implicit def zzGet[A](v: java.util.stream.Stream[A]): Pipe[A] = getFrom(v)

  import scalqa.Pipe.{ _library => L }
  implicit def zzLibrary[A](v: ~[A]) = new L._Class(v: Pipe[A])
  implicit def zzLibrary_Int(v: ~[Int]) = new L._Int(v: Pipe[Int])
  implicit def zzLibrary_Byte(v: ~[Byte]) = new L._Byte(v: Pipe[Byte])
  implicit def zzLibrary_Char(v: ~[Char]) = new L._Char(v: Pipe[Char])
  implicit def zzLibrary_Long(v: ~[Long]) = new L._Long(v: Pipe[Long])
  implicit def zzLibrary_Float(v: ~[Float]) = new L._Float(v: Pipe[Float])
  implicit def zzLibrary_Short(v: ~[Short]) = new L._Short(v: Pipe[Short])
  implicit def zzLibrary_Double(v: ~[Double]) = new L._Double(v: Pipe[Double])
  implicit def zzLibrary_Boolean(v: ~[Boolean]) = new L._Boolean(v: Pipe[Boolean])

  implicit def zzzCustomGet(v: ~[String]): Pipe[J.Path] = v.pipe.map(J.Path.get(_))
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait _Trait ->
 *
 *     [[Pipe.Interface]] has global alias '''~''', which is used in most situations
 *
 *     {{{ val p : ~[Int] = \/  // val 'p' of type Pipe.Interface[Int] }}}
 *
 *     On use, [[Pipe.Interface]] will ''always'' be converted to [[Pipe]], so there is nothing wrong calling it [[Pipe]]
 *
 *     There are two reasons why [[Pipe.Interface]] and [[Pipe]] are separate entities:
 *
 *     - [[Pipe.Interface]] is co-variant, what is important for many collections. [[Pipe]] is invariant, what is beneficial for data processing
 *     - [[Pipe.Interface]] has no public methods, so any type like ''List'', ''Array'', ''Iterator'', etc. can be implicitly convertible to it, without the overhead of inherited methods
 *
 *     [[Pipe.Interface]] is the Scalqa's single universal data exchange format.
 *     There is an implicit conversions to [[Pipe.Interface]] for every container like structure, included the ones in Java and Scala.
 *     Therefore all data structures are universally compatible
 *
 *     {{{
 *       val javaList:      java.util.List[Int]          = (1 <> 3).all.to[java.util.List]
 *       val javaStream:    java.util.stream.Stream[Int] = (4 <> 6).all.to[java.util.stream.Stream]
 *       val scalaIterator: scala.Iterator[Int]          = (7 <> 9).all.to[Iterator]
 *       val scalaList:     scala.List[Int]              = 10 :: 11 :: 12 :: Nil
 *
 *       var array: Array[Int] = \/
 *
 *       array = array +~ javaList +~ javaStream +~ scalaIterator +~ scalaList
 *
 *       array.all lp // Prints:  ~(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)
 *     }}}
 *
 *     When creating a custom pipeline most applications should implement [[Pipe.Interface]] instead of [[Pipe]]. This is much easier to do and will
 *     be almost as efficient for end-point pipes
 *
 *   {{{
 *     // Pipe[Int] from 0 to 20
 *
 *     class MyPipe extends ~[Int] {
 *         private var i = -1;
 *
 *         protected def supplyOpt = if (i >= 20) \/ else { i += 1; i }
 *     }
 *
 *     new MyPipe lp
 *
 *     // Output
 *     ~(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20)
 *   }}}
 *
 *   Note. [[Pipe.Interface]] has single protected method (not visible by default)
 *
 * @def supplyOpt: -> Elements supplier
 *
 *     Returns next element in the pipe or Opt.Void if no more elements
 *
 *     Note, if Opt.Void was returned once, every subsequent call must always return Opt.Void
 */
