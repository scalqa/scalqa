package scalqa; package Pipe

trait Iterator[A] {

  def hasNext: Boolean = previewOpt

  def next: A = nextOpt.value

  def nextOpt: Opt[A] = nextFindOpt(true.filter)

  def nextFindOpt(f: A => Boolean): Opt[A]

  def next(several: Int): ~[A] = {
    var c: Coll.Val[A] = \/
    if (several > 0) nextFindOpt(o => { c += o; c.size == several })
    c.all
  }

  def nextWhile(f: A => Boolean): ~[A] = {
    var c: Coll.Val[A] = \/
    while (previewOpt.let(f)) c += next
    c.all
  }

  def previewOpt: Opt[A]

  def preview: A = previewOpt.value

  def all: ~[A]

}

object Iterator extends Able.Void.Companion.Typed[Iterator](Pipe.The.Void) {

  import scala.language.implicitConversions

  implicit def zzAll[A](it: Iterator[A]): ~[A] = it.all

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait Iterator ->
 *
 *   [[Pipe.Iterator]] allows to iterate through [[Pipe]] elements
 *
 *   Unlike [[Pipe]], which has to be discarded after single method call, all [[Iterator]] methods can be called repeatedly
 *
 *   {{{
 *      val it = ('A' <> 'D').all.iterator
 *
 *      it.nextOpt.lp // Prints: Opt(A)
 *      it.nextOpt.lp // Prints: Opt(B)
 *      it.nextOpt.lp // Prints: Opt(C)
 *      it.nextOpt.lp // Prints: Opt(D)
 *      it.nextOpt.lp // Prints: Opt.Void
 *      it.nextOpt.lp // Prints: Opt.Void
 *      it.nextOpt.lp // Prints: Opt.Void
 *   }}}
 *
 * @def preview: -> Preview element
 *
 *    Allows preview of the next element even before it is pumped as 'next'
 *
 *    If no more - Fails
 *
 * @def previewOpt -> Preview element
 *
 *    Allows optional preview of the next element even before it is pumped as 'next'
 *
 *    If no more - Opt.Void is returned
 *
 * @def hasNext -> There is more
 *
 *     Returns true if there is at least one more element in the pipeline
 *
 * @def next: -> Pumps next
 *
 *     Pumps next element from the pipeline
 *
 *     If no more - Fails
 *
 * @def nextOpt: -> Pumps next
 *
 *     Pumps and optionally returns next element from the pipeline
 *
 *     If no more - Opt.Void is returned
 *
 * @def nextFindOpt -> Pumps next conditional
 *
 *     Pumps and optionally returns next element which pass given filter from the pipeline
 *
 *     If non found - Opt.Void is returned
 *
 * @def next( -> Pipe few next
 *
 *     Returns a [[Pipe]] of next ''several'' elements
 *
 *     Note. Piped elements are immediately removed from this [[Iterator]] and buffered within the [[Pipe]]
 *
 * @def nextWhile -> Pipe while
 *
 *     Returns a [[Pipe]] of sequential elements, which pass given filter
 *
 *     Note. Piped elements are immediately removed from this [[Iterator]] and buffered within the [[Pipe]]
 *
 * @def all -> Convert to Pipe
 *
 *     Converts this [[Iterator]] back to [[Pipe]]
 *
 *     This [[Iterator]] must be discarded at this point and the new [[Pipe]] used instead
 *
 */
