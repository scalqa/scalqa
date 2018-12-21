package scalqa; package Fx; package Table; package Z

private[Table] class HeaderFooterList[A](hf: (Idx[A], Idx[A]), override val real: Idx.OM[A]) extends HeaderFooterList.Base[A](hf._1, hf._2, real) with Idx.OM[A] {

  def refreshAt(r: Idx.Range): Unit = real.refreshAt(r)

  def multiChange(ch: Idx.M[A] ⇒ Any): Unit = real.multiChange(l => ch(new HeaderFooterList.Base[A](hdr, ftr, l)))

  override def order(o: Ordering[A]): Unit = real.order(o)

  def onChange(f: Idx[Idx.Change[A]] ⇒ Any) = real.onChange(EventControl.moveId1(f, c => f(Idx.O.transformIdx(c, _ move hdrS))))

}

private[Table] object HeaderFooterList {

  class Base[A](val hdr: Idx[A], val ftr: Idx[A], val real: Idx.M[A]) extends Idx.M[A] {
    val hdrS = hdr.size
    val ftrS = ftr.size

    def size: Int = hdrS + ftrS + real.size

    def apply(idx: Int): A = { val i = idx - hdrS; if (idx < hdrS) hdr(idx) else if (i < real.size) real(i) else ftr(i - real.size) }

    def addAt(i: Int, e: A): Unit = real.addAt(toReal(i), e)

    def update(i: Int, e: A): Unit = real.update(toReal(i), e)

    def removeAt(r: Idx.Range): Unit = if (r.size > 0) { toReal(r.start); toReal(r.end - 1); real.removeAt(r move -hdrS) }

    private def toReal(i: Int): Int = {
      if (i < hdrS) App.Fail("Updating header: " + i)
      if ({ val v = i - hdrS - real.size; v >= 0 && v < ftrS }) { App.Fail("Updating footer: " + i) }
      i - hdrS
    }
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
