package scalqa; package `val`; package idx; package z; import language.implicitConversions

private class JavaList_View[A](protected val real: Idx[A]) extends JavaList_View.Basis[A]

private[scalqa] object JavaList_View:

  def apply[A](l: Idx[A]): java.util.List[A] = l match
    case l: Idx.M[_] => new M(l.cast[Idx.M[A]])
    case l           => new z.JavaList_View(l)

  abstract class Basis[A] extends java.util.AbstractList[A] with J.Util.Proxy[Idx[A]]:
    def get(i: Int): A = real(i)
    def size           = real.size

  class M[A](protected val real: Idx.Mutable[A]) extends Basis[A] with J.Util.Proxy[Idx.Mutable[A]]:
    override def set(i: Int, a: A) = { val o = get(i); real.update(i, a); o }
    override def add(i: Int, a: A) = real.addAt(i, a)
    override def remove(i: Int)    = { val o = get(i); real.removeAt(i); o }

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
