package scalqa; package Pipe; package _extend

trait _process[A] extends Flow._extend._process[A] with __[A] {

  override def peek(f: A => Any): Pipe[A] = new Z.process.peek[A](This, f)

  override def peekIdx(f: (Int, A) => Any, start: Int = 0): Pipe[A] = new Z.process.peek.idx[A](This, f, start)

  // ------------------------------------------------------------------------------------------------------------------
  def buffer: Pipe[A] = new Z.process.buffer(This)

  def reverse: Pipe[A] = new Z.process.reverse(This)

  def shuffle: Pipe[A] = new Z.process.shuffle(This)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait _process -> '''Process Interface'''.
 *
 *    Process methods do not change pipeline type or composition.
 *
 * @def shuffle -> Randomize order
 *
 *     Mixes elements in random order
 *
 *     With the start of pumping action, all the elements are retrieved from the source, buffered, and randomly reorganized
 *
 *     Only after, the first element and the others are allowed down the pipeline
 *
 *     This method is not suitable for large pipes
 *
 *     {{{ (0 <>> 10).all.shuffle.lp // Might print: ~(4, 2, 5, 1, 0, 3, 6, 9, 7, 8) }}}
 *
 * @def buffer -> Buffers all elements
 *
 *     With the start of pumping action,  all the elements are retrieved from the source and buffered
 *
 *     Only after, the first element and the others are allowed down the pipeline
 *
 *     This method is not suitable for large pipes.
 *
 * @def reverse -> Reverse order
 *
 *     In most cases all elements have to be buffered at this point, so it is not suitable for large pipes
 *
 *     {{{ (0 <>> 10).all.reverse.lp // prints: ~(9, 8, 7, 6, 5, 4, 3, 2, 1, 0) }}}
 *
 */
