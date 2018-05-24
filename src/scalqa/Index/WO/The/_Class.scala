package scalqa; package Index; package WO; package The

class _Class[A](initSizeOpt: Opt[Int] = \/)(implicit t: Tag[A] = \/)
    extends Index.W.The[A](initSizeOpt, if (t.isVoid) Array.VoidRaw.cast else t.newArrayRaw(initSizeOpt or App.Pro.DefaultBufferSize())) with O.The.Base[A] with WO[A] {

  override def addAt(i: Int, a: A) = _change(c => { c.addAt(i); super.addAt(i, a) })

  override def removeAt(r: Int.Range) = if (r.size > 0) _change(c => { c.removeAt(r); super.removeAt(r) })

  override def replaceAt(i: Int, a: A) = _change(c => { c.replaceAt(i); super.replaceAt(i, a) })

  override def refreshAt(r: Int.Range) = if (r.size > 0) _change(c => { c.refreshAt(r); super.refreshAt(r) })

  override def reposition(r: Int.Range.Reposition) = if (r.range.size > 0) _change(c => { c.reposition(r); super.reposition(r) })

  def multiChange(ch: W[A] => Any): Unit = O.Change.Builder.get[A](this).I(c => {
    ch(new Index.The.Proxy[A](this) with W[A] {
      def addAt(i: Int, a: A) = { c.addAt(i); _Class.super.addAt(i, a) }
      def removeAt(r: Int.Range) = if (r.size > 0) { c.removeAt(r); _Class.super.removeAt(r) }
      def replaceAt(i: Int, a: A) = { c.replaceAt(i); _Class.super.replaceAt(i, a) }
      override def reposition(r: Int.Range.Reposition) = if (r.range.size > 0) { c.reposition(r); _Class.super.reposition(r) }
    }); if (c.isEmpty.not) fireChange(c.seal)
  })
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
