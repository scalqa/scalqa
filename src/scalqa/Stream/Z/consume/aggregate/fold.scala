package scalqa; package Stream; package Z; package consume; package aggregate

private[scalqa] object fold {

  def apply[@specialized(DATA) A](s: Stream[A], start: A, op: Folding[A]): A = {
    class Each extends Consumer[A] { var value = start; def accept(v: A) = value = op(value, v) }
    val e = new Each
    s.foreach(e)
    e.value
  }

  def as[@specialized(DATA) A, @specialized(DATA) B](s: Stream[B], start: A, op: Folding.As[A, B]): A = {
    class as extends Consumer[B] { var value = start; def accept(v: B) = value = op(value, v) }
    val f = new as
    s.foreach(f)
    f.value
  }

  def asPrimRef[@specialized(DATA) A, B](s: Stream[B], start: A, op: Folding.Z.PrimRef[A, B]): A = {
    class asPrimRef extends Consumer[B] { var value = start; def accept(v: B) = value = op(value, v) }
    val f = new asPrimRef
    s.foreach(f)
    f.value
  }

  def asRefPrim[A, @specialized(DATA) B](s: Stream[B], start: A, op: Folding.Z.RefPrim[A, B]): A = {
    class asRefPrim extends Consumer[B] { var value = start; def accept(v: B) = value = op(value, v) }
    val f = new asRefPrim
    s.foreach(f)
    f.value
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
