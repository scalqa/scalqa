package scalqa; package Any; package Ilk; package Z; package A

private[Ilk] object Longs extends Base[Long] {

  val RootClass = java.lang.Long.TYPE
  val BoxedClass = classOf[java.lang.Long]
  val ArrayClass = Array.emptyLongArray.getClass

  @inline def mkArray[T](s: Int) = { if (s == 0) Array.emptyLongArray else new Array[Long](s) }.asInstanceOf[Array[T]]

  @inline def mkValue[A](v: Stream.Flow[A]) = Idx.I.Longs.fromFlow(v.asInstanceOf[Stream.Flow[Long]]).asInstanceOf[Idx.I[A]]
  @inline def mkValue[A](v: Array[A]) = Idx.I.Longs.fromArray(v.asInstanceOf[Array[Long]]).asInstanceOf[Idx.I[A]]
  @inline def mkValueVoid[A] = (\/ : Idx.I.Longs).asInstanceOf[Idx.I[A]]

  @inline def mkBuffer[T](s: Opt.Int) = new Idx.Array.Buffer.Longs(s).asInstanceOf[Idx.Array.Buffer[T]]

  @inline def mkStream[A](a: Array[A]): Stream[A] = Custom.Array.Z.stream[Long](a.asInstanceOf[Array[Long]]).asInstanceOf[Stream[A]]

  @inline def mkRange[A](s: A, sx: Boolean, e: A, ex: Boolean, t: Ordering[A]) = new Custom.Long.Z.Range(s.asInstanceOf[Long], sx, e.asInstanceOf[Long], ex).asInstanceOf[Range[A]]

  @inline def mkMapRefIlk[A, B](s: Stream[A], f: Stream.Mapping[A, B]) = Stream.Z.extend.map.map.refPrim[A, Long](s, f.asInstanceOf[Stream.Mapping.Z.RefPrim[A, Long]], this).asInstanceOf[Stream[B]]
  @inline def mkMapIlkRef[A, B](s: Stream[A], f: Stream.Mapping[A, B]) = Stream.Z.extend.map.map.primRef[Long, B](s.asInstanceOf[Stream[Long]], f.asInstanceOf[Stream.Mapping.Z.PrimRef[Long, B]], Refs).asInstanceOf[Stream[B]]

  @inline def mkFlatMapRefIlk[A, B](s: Stream[A], f: Stream.Mapping[A, ~[B]]) = Stream.Z.extend.map.flatMap.refPrim[A, Long](s, f.asInstanceOf[Stream.Mapping[A, ~[Long]]], this).asInstanceOf[Stream[B]]
  @inline def mkFlatMapIlkRef[A, B](s: Stream[A], f: Stream.Mapping[A, ~[B]]) = Stream.Z.extend.map.flatMap.primRef[Long, B](s.asInstanceOf[Stream[Long]], f.asInstanceOf[Stream.Mapping.Z.PrimRef[Long, ~[B]]], Refs).asInstanceOf[Stream[B]]

  @inline def mkLetMapRefIlk[A, B](s: Stream[A], f: Stream.Mapping[A, Opt[B]]) = Stream.Z.extend.filter.letMap.refPrim[A, Long](s, f.asInstanceOf[Stream.Mapping[A, Opt[Long]]], this).asInstanceOf[Stream[B]]
  @inline def mkLetMapIlkRef[A, B](s: Stream[A], f: Stream.Mapping[A, Opt[B]]) = Stream.Z.extend.filter.letMap.primRef[Long, B](s.asInstanceOf[Stream[Long]], f.asInstanceOf[Stream.Mapping.Z.PrimRef[Long, Opt[B]]], Refs).asInstanceOf[Stream[B]]

  @inline def mkFoldAsIlkWithRef[A, B](s: Stream[A], start: B, op: Stream.Folding.As[B, A]): B = Stream.Z.consume.aggregate.fold.asPrimRef(s, start.asInstanceOf[Long], op.asInstanceOf[Stream.Folding.Z.PrimRef[Long, A]]).asInstanceOf[B]
  @inline def mkFoldAsRefWithIlk[A, B](s: Stream[A], start: B, op: Stream.Folding.As[B, A]): B = Stream.Z.consume.aggregate.fold.asRefPrim(s.asInstanceOf[Stream[Long]], start, op.asInstanceOf[Stream.Folding.Z.RefPrim[B, Long]])
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
