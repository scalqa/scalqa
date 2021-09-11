package scalqa; package fx; package control; package table; package z; import language.implicitConversions

private[fx] class HeaderFooter[A](hf: (><[A], ><[A]), override val real:  Idx.OM[A]) extends HeaderFooter.Base[A](hf._1, hf._2, real) with Idx.OM[A]:

  @tn("refresh_Range") def refresh_<>(i: Int.<>)         : Unit = real.refresh_<>(i << headSize)
  /**/                 def modify(ch:  Idx.M[A] => Unit) : Unit = real.modify(l => ch(HeaderFooter.Base[A](head, foot, l)))
  override             def sort  (using o: Ordering[A])  : Unit = real.sort(using o)

  def onChange[U](l: ><[Idx.O.Event[A]] => U) = real.onChange(Event.Id.map1(l,ci => if (headSize == 0) l(ci) else l(ci.~.map[Idx.O.Event[A]](v => {
    val r = v.range >> headSize
    v match
      case v:  Idx.Event.Add[A]                   => Idx.Event.Add(r, v.items)
      case v:  Idx.Event.Remove[A]                => Idx.Event.Remove(r, v.items)
      case v:  Idx.Event.Update[A] if v.isRefresh => Idx.Event.Update.refresh(r, v.items)
      case v:  Idx.Event.Update[A]                => Idx.Event.Update(r, v.items, v.oldItems)
      case v:  Idx.Event.Reposition[A]            => Idx.Event.Reposition(r, v.positions.~.map(_ + headSize).><)
      case _                                      => J.illegalState()
  }).><)))

private object HeaderFooter:

  class Base[A](val head: ><[A], val foot: ><[A], val real:  Idx.M[A]) extends Idx.M.X.Base[A]:
    /**/                val headSize              : Int  = head.size
    /**/                val footSize              : Int  = foot.size
    /**/                def size                  : Int  = headSize + footSize + real.size
    /**/                def apply(idx: Int)       : A    = { val i = idx - headSize; if (idx < headSize) head(idx) else if (i < real.size) real(i) else foot(i - real.size) }
    /**/                def addAt(i: Int, e: A)   : Unit = real.addAt(mapPos(i), e)
    /**/                def updateAt(i: Int, e: A): Unit = real.updateAt(mapPos(i), e)
    @tn("remove_Range") def remove_<>(r: Int.<>)  : Unit = if (r.size > 0) { mapPos(r.start); mapPos(r.end); real.remove_<>(r << headSize) }

    private def mapPos(i: Int) : Int  =
      if (i < headSize) J.illegalState("Updating head: " + i)
      if ({ val v = i - headSize - real.size; v >= 0 && v < footSize }) { J.illegalState("Updating footer: " + i) }
      i - headSize

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
