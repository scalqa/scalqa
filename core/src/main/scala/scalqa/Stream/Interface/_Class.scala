package scalqa; package Stream; package Interface

abstract class _Class[+A] private[Stream]

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @class _Class ->
 *
 *     [[Stream.Interface]] has global alias "`<big><big>~</big></big>`" (tilde), which is used in most situations
 *
 *     {{{ val s : ~[Int] = \/  // val 's' of type Stream.Interface[Int] }}}
 *
 *     On use, [[Stream.Interface]] will `always` be converted to [[Stream]], so there is nothing wrong calling it [[Stream]]
 *
 *     There are two reasons why [[Stream.Interface]] and [[Stream]] are separate entities:
 *
 *     - [[Stream.Interface]] is co-variant, what is important for many collections. [[Stream]] is invariant, what is beneficial for data processing
 *     - [[Stream.Interface]] has no methods, so any type like `List`, `Array`, `Iterator`, etc. can be implicitly convertible to it, without the overhead of inherited methods
 *
 *     [[Stream.Interface]] is the Scalqa's single universal data exchange format.
 *     There is an implicit conversions to [[Stream.Interface]] for every container like structure, included the ones in Java and Scala.
 *     Therefore all data structures are universally compatible
 *
 *     {{{
 *       val javaList:      java.util.List[Int]          = (1 <> 3).all.to[java.util.List]
 *       val javaStream:    java.util.stream.Stream[Int] = (4 <> 6).all.to[java.util.stream.Stream]
 *       val scalaIterator: scala.Iterator[Int]          = (7 <> 9).all.to[Iterator]
 *       val scalaList:     scala.List[Int]              = 10 :: 11 :: 12 :: Nil
 *
 *       var ints: Ints = \/
 *
 *       ints = ints +~ javaList +~ javaStream +~ scalaIterator +~ scalaList
 *
 *       ints.all lp // Prints:  ~(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)
 *     }}}
 */
