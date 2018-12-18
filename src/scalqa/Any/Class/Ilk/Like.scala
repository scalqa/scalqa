package scalqa; package Any; package Class; package Ilk

private[scalqa] trait Like {

  private[Ilk] val shiftId = Z.Shift.id(this)

  def isPrimitive: Boolean

  def isObject = !isPrimitive

  private[scalqa] val RootClass: java.lang.Class[_]
  private[scalqa] val ArrayClass: java.lang.Class[_]
  private[scalqa] val BoxedClass: java.lang.Class[_]

  private[scalqa] def mkArray[A](size: Int = App.initSize): Array[A]

  private[scalqa] def mkValue[A](v: Stream.Flow[A]): Idx.I[A]
  private[scalqa] def mkValue[A](v: Array[A]): Idx.I[A]
  private[scalqa] def mkValueVoid[A]: Idx.I[A]

  private[scalqa] def mkBuffer[A](initSize: Opt.Int = \/): Idx.Array.Buffer[A]

  private[scalqa] def mkStream[A](a: Array[A]): Stream[A]

  private[scalqa] def mkRange[A](start: A, startEx: Boolean, end: A, endEx: Boolean, o: Ordering[A]): Range[A]

  private[scalqa] def mkMapRefIlk[A, B](s: Stream[A], f: Stream.Mapping[A, B]): Stream[B]
  private[scalqa] def mkMapIlkRef[A, B](s: Stream[A], f: Stream.Mapping[A, B]): Stream[B]

  private[scalqa] def mkFlatMapRefIlk[A, B](s: Stream[A], f: Stream.Mapping[A, ~[B]]): Stream[B]
  private[scalqa] def mkFlatMapIlkRef[A, B](s: Stream[A], f: Stream.Mapping[A, ~[B]]): Stream[B]

  private[scalqa] def mkLetMapRefIlk[A, B](s: Stream[A], f: Stream.Mapping[A, Opt[B]]): Stream[B]
  private[scalqa] def mkLetMapIlkRef[A, B](s: Stream[A], f: Stream.Mapping[A, Opt[B]]): Stream[B]

  private[scalqa] def mkFoldAsIlkWithRef[A, B](s: Stream[A], start: B, op: Stream.Folding.As[B, A]): B
  private[scalqa] def mkFoldAsRefWithIlk[A, B](s: Stream[A], start: B, op: Stream.Folding.As[B, A]): B
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
