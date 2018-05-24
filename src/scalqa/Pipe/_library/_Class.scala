package scalqa; package Pipe; package _library

class _Class[A] private[scalqa] (protected val This: Pipe[A]) extends AnyVal {

  def yieldSize: (Pipe[A], Int) = Z.process.Yield.size(This)

  def yieldTag: (Pipe[A], Tag[A]) = Z.process.Yield.tag(This)

  def yieldSizeAndTag: (Pipe[A], Int, Tag[A]) = Z.process.Yield.sizeAndTag(This)

  def yieldSizeAtLeast(count: Int): (Pipe[A], Boolean) = Z.process.Yield.sizeAtLeast(This, count)

  def toArrayRaw(implicit ct: scala.reflect.ClassTag[A]): Array.Raw[A] = Z.transform.toArray.raw(This, ct)

  def equalAllOpt(that: ~[A], check: (A, A) => Boolean = _ == _): Opt.Ok = Z.evaluate.equalAllOpt(This, that, check)

  def pipe: Pipe[A] = This

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @class _Class ->
 *
 *     This library includes methods not widely used in applications and removed here not to pollute main name space for [[Pipe]]
 *
 * @def equalAllOpt -> Equal check
 *
 *     Pumps both pipes and compares all corresponding elements
 *
 *     When first not equal pair is found, failed Opt.Ok is returned
 *
 *     Opt.Ok.Success means all elements are equal
 *
 *     @param check is the function to compare two elements
 *     {{{
 *       (0 <> 10).all equalAllOpt (0 <> 10) lp        // Prints: Opt.Ok.Success
 *
 *       (0 <> 10).all equalAllOpt (0 <>> 10) lp       // Prints: Opt.Ok(error=First has more elements)
 *
 *       (0 <> 5).all ~ 7 ~ 8 equalAllOpt (0 <> 10) lp // Prints: Opt.Ok(error=Fail at index 6: 7 != 6)
 *     }}}
 *
 * @def toArrayRaw -> Convert to scala.Array
 *
 *    Creates [[Array.Raw]] with pipeline elements.
 *
 *    Note that scala.reflect.ClassTag is implicitly required. This method follows general the rules for creating arrays in Scala
 *
 * @def yieldSizeAtLeast -> Checks size
 *
 *    Returns a tuple of [[Pipe]] with the same elements as ''this'' and Boolean, indicating that size is at least ''count'' value
 *
 *    Unlike ''yieldSize'' method, this one does not require to buffer entire pipeline, but only enough elements to check the predicate
 *
 * @def yieldSize: -> Deliver size
 *
 *    Returns a tuple of [[Pipe]] with the same elements as ''this'' and element count
 *
 *    If size is available from the [[Metadata]], ''this'' [[Pipe]] and the size are returned
 *
 *    Otherwise, all elements have to be buffered to a new [[Pipe]] and counted
 *
 *  @def yieldTag -> Deliver element class tag
 *
 *    Returns a tuple of [[Pipe]] with the same elements as ''this'' and [[Any.Class.Tag]]
 *
 *    If tag is available from the [[Metadata]], ''this'' [[Pipe]] and the tag are returned
 *
 *    Otherwise, one element is pumped, its tag is determined, and new [[Pipe]] is created with this element added
 *
 *    If pipeline is empty, void [[Pipe]] and [[Tag]] returned
 *
 *  @def yieldSizeAndTag -> Deliver size and element class tag
 *
 *    Returns a tuple of [[Pipe]] with the same elements as ''this'', its size, and [[Any.Class.Tag]]
 *
 *    If tag and size are available from the [[Metadata]], ''this'' [[Pipe]], the size, and the tag are returned
 *
 *    Otherwise, all elements have to be buffered to a new [[Pipe]], counted, and tagged
 *
 * @def pipe -> Explicit [[Pipe]]
 *
 *    This method is useless on [[Pipe]], but it can be handy with [[Pipe.Interface]] for explicit [[Pipe]] conversions
 *
 *    {{{
 *       var o: Opt[Pipe[Int]] = \/
 *
 *       o = (1 <> 10).all       // Does not compile, because two implicit
 *                               // conversions need to happen: ~[Int] > Pipe[Int] > Opt[Pipe[Int]]
 *
 *       o = (1 <> 10).all.pipe  // Compiles fine with one implicit conversion
 *   }}}
 */
