package scalqa; package Any; package Itself

trait _container[A] extends Any with __[A] {

  def ~ : scalqa.Pipe[A] = new ThePipe(This)

  def Coll: scalqa.Coll[A] = new TheColl(This)

  def Index: scalqa.Index[A] = new TheIndex(This)

  def CollVal(implicit t: Tag[A] = \/) = scalqa.Coll.Val.get(This)

  def IndexVal(implicit t: Tag[A] = \/) = scalqa.Index.Val.get(This)

  def Array(implicit t: Tag[A] = \/) = scalqa.Array.get[A](This)

  def Refs(implicit t: Tag[A] = \/) = scalqa.Array.View.Refs.get(This)

}
private class ThePipe[A](v: A) extends Pipe.Z.The.One(v)
private class TheColl[A](v: A) extends scalqa.Coll[A] { def size = 1; def all = new ThePipe(v) }
private class TheIndex[A](v: A) extends scalqa.Index[A] { def size = 1; def apply(i: Int) = v }

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def ~ : -> Itself as Pipe
 *
 *   Creates a [[Pipe]] with single element ''this''
 *
 *   {{{
 *       1.I.~     .lp  // Prints: ~(1)
 *       'A'.I.~   .lp  // Prints: ~(A)
 *       "aaa".I.~ .lp  // Prints: ~(aaa)
 *   }}}
 *
 * @def Index: -> Itself as Index
 *
 *   Creates [[Index]] with single element ''this''
 *   {{{ 10.I.Index.all    lp  // Prints: ~(10) }}}
 *
 *
 */
