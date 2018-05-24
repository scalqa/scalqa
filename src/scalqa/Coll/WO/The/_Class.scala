package scalqa; package Coll; package WO; package The

class _Class[A] extends Coll.W.The[A] with Base[A] {

  override def add(a: A): Unit = synchronized { super.add(a); fireChange(O.Add.getSingle(a).I.~.as[Coll]) }

  override def removeFor(f: A => Boolean): Coll[A] = synchronized { super.removeFor(f).I(c => if (c.isEmpty.not) fireChange(O.Remove.get(c).I.~.as[Index])) }

  override def clear = if (size > 0) synchronized { val c = all.as[Index]; super.clear; fireChange(O.Remove.get(c).I.~.as[Index]) }

  def multiChange(ch: W[A] => Any) = synchronized {
    var cngs: Val[O.Change[A]] = \/
    ch(new Coll.W[A] {
      def size = _Class.super.size
      def all = _Class.super.all
      def add(a: A) { _Class.super.add(a); cngs += O.Add.getSingle(a) }
      def remove(a: A) = _Class.super.removeFor(_ == a).all(cngs += O.Remove.getSingle(_))
      def clear = if (size > 0) { val s = all.as[Index]; _Class.super.clear; cngs += O.Remove.get(s) }
    })
    if (cngs.isEmpty.not) super.fireChange(cngs);
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
