package scalqa; package `val`; package idx; package observable; package event; import language.implicitConversions

import recorder.Z
import observable.{ event as C }

class Recorder[A](protected val real: Idx.Mutable[A]) extends Idx.M.X.Abstract[A] with J.Util.Proxy.Idx.Base[A]:
  protected   var list                           : Pack[Event[A]] =VOID
  protected   var last                           : Event[A]        = null
  protected   def add(v: Event[A])               : Unit            = { if(last != null) list += last; last = v}
  private     def strm(r: Int.Range)             : Stream[A]       = real.stream.takeRange(r)

  /**/        def pack                           : Pack[Event[A]]  = { if(last != null) { list += last; last = null}; list }
  override    def reposition(p: Idx.Permutation) : Unit            = if (p.range.size > 0) { add(C.Reposition(p)); real.reposition(p)}
  override    def sort    (using o: Ordering[A]) : Unit            = reposition(Idx.Permutation.sorting(real)(using o))

  override def addAt(i: Int, a: A) =
    last match
      case v: Z.Add[A] if v.range.endX == i => v += a
      case v: C.Add[A] if v.range.endX == i => last = Z.Add(v.range.start).self(_ ++= v.items += a)
      case _                                => add(C.Add(i, a))
    real.addAt(i,a)

  override def addAllAt(i: Int, v: Stream[A]): Unit = v.nonEmptyOpt.forval(s => {
    val sz = size
    real.addAllAt(i, s)
    val r = i <>= (size - sz)
    last match
      case v: Z.Add[A] if v.range.endX == i => v ++= strm(r)
      case v: C.Add[A] if v.range.endX == i => last = Z.Add(v.range.start).self(_ ++= v.items.stream ++= strm(r))
      case _                                => add(C.Add(i, strm(r).pack))
  })

  override def updateAt(i: Int, a: A): Unit =
    last match
      case v: Z.Update[A] if v.range.endX == i => v += (a, real(i))
      case v: C.Update[A] if v.range.endX == i => last = Z.Update(v.range.start).self(_ ++= (v.items.stream, v.oldItems.stream) += (a, real(i)))
      case _                                   => add(C.Update(i, a, real(i)))
    real(i) = a

  override def updateAllAt(i: Int, s: Stream[A]): Unit =
    val itm = s.pack
    val r = i <>= itm.size
    last match
      case v: Z.Update[A] if v.range.endX == i => v ++= (itm, strm(r))
      case v: C.Update[A] if v.range.endX == i => last = Z.Update(v.range.start).self(_ ++= (v.items.stream, v.oldItems.stream) ++= (itm, strm(r)))
      case _                                   => add(C.Update(i, itm, strm(r).pack))
    real.updateAllAt(i, itm)

  override def removeAt(i: Int): Unit =
    last match
      case v: Z.Remove[A] => v += real(i)
      case v: C.Remove[A] => last = Z.Remove(v.range.start).self(_ ++= v.items += real(i))
      case _              => add(C.Remove(i, real(i)))
    real.removeAt(i)

  def removeRange(r: Int.Range): Unit =
    last match
      case v: Z.Remove[A] if v.range.start == r.start => v ++= strm(r)
      case v: C.Remove[A] if v.range.start == r.start => last = Z.Remove(v.range.start).self(_ ++= v.items ++= strm(r))
      case _                                          => add(C.Remove(r, strm(r).pack))
    real.removeRange(r)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
