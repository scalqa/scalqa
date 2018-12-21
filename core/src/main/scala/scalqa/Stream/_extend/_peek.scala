package scalqa; package Stream; package _extend

trait _peek[A] extends Flow._extend._peek[A] { self: Stream[A] =>

  override def peek(f: Consumer[A]): Stream[A] = Z.extend.peek.peek[A](this, f)

  override def peekIdx(f: Consumer.Idx[A], start: Int = 0): Stream[A]  = Z.extend.peek.peekIdx[A](this, f, start)
  
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait _peek -> `Inspection Interface`.
 *
 *    'peek' methods do not change [[Flow]] type or composition.
 *
 */
