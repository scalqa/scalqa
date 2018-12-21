package scalqa; package Any; package Ilk; package Z; package A

private[scalqa] object Ints extends Base[Int] {

  val RootClass = java.lang.Integer.TYPE
  val BoxedClass = classOf[java.lang.Integer]
  val ArrayClass = Array.emptyIntArray.getClass

  @inline def mkArray[T](s: Int) = { if (s == 0) Array.emptyIntArray else new Array[Int](s) }.asInstanceOf[Array[T]]

  @inline def mkValue[A](v: Stream.Flow[A]) = Idx.I.Ints.fromFlow(v.asInstanceOf[Stream.Flow[Int]]).asInstanceOf[Idx.I[A]]
  @inline def mkValue[A](v: Array[A]) = Idx.I.Ints.fromArray(v.asInstanceOf[Array[Int]]).asInstanceOf[Idx.I[A]]
  @inline def mkValueVoid[A] = (\/ : Idx.I.Ints).asInstanceOf[Idx.I[A]]

  @inline def mkBuffer[T](s: Opt.Int) = new Idx.Array.Buffer.Ints(s).asInstanceOf[Idx.Array.Buffer[T]]

  @inline def mkStream[A](a: Array[A]): Stream[A] = Custom.Array.Z.stream[Int](a.asInstanceOf[Array[Int]]).asInstanceOf[Stream[A]]

  @inline def mkRange[A](s: A, sx: Boolean, e: A, ex: Boolean, t: Ordering[A]) = new Custom.Int.Z.Range(s.asInstanceOf[Int], sx, e.asInstanceOf[Int], ex).asInstanceOf[Range[A]]

  @inline def mkMapRefIlk[A, B](s: Stream[A], f: Stream.Mapping[A, B]) = Stream.Z.extend.map.map.refPrim[A, Int](s, f.asInstanceOf[Stream.Mapping.Z.RefPrim[A, Int]], this).asInstanceOf[Stream[B]]
  @inline def mkMapIlkRef[A, B](s: Stream[A], f: Stream.Mapping[A, B]) = Stream.Z.extend.map.map.primRef[Int, B](s.asInstanceOf[Stream[Int]], f.asInstanceOf[Stream.Mapping.Z.PrimRef[Int, B]], Refs).asInstanceOf[Stream[B]]

  @inline def mkFlatMapRefIlk[A, B](s: Stream[A], f: Stream.Mapping[A, ~[B]]) = Stream.Z.extend.map.flatMap.refPrim[A, Int](s, f.asInstanceOf[Stream.Mapping[A, ~[Int]]], this).asInstanceOf[Stream[B]]
  @inline def mkFlatMapIlkRef[A, B](s: Stream[A], f: Stream.Mapping[A, ~[B]]) = Stream.Z.extend.map.flatMap.primRef[Int, B](s.asInstanceOf[Stream[Int]], f.asInstanceOf[Stream.Mapping.Z.PrimRef[Int, ~[B]]], Refs).asInstanceOf[Stream[B]]

  @inline def mkLetMapRefIlk[A, B](s: Stream[A], f: Stream.Mapping[A, Opt[B]]) = Stream.Z.extend.filter.letMap.refPrim[A, Int](s, f.asInstanceOf[Stream.Mapping[A, Opt[Int]]], this).asInstanceOf[Stream[B]]
  @inline def mkLetMapIlkRef[A, B](s: Stream[A], f: Stream.Mapping[A, Opt[B]]) = Stream.Z.extend.filter.letMap.primRef[Int, B](s.asInstanceOf[Stream[Int]], f.asInstanceOf[Stream.Mapping.Z.PrimRef[Int, Opt[B]]], Refs).asInstanceOf[Stream[B]]

  @inline def mkFoldAsIlkWithRef[A, B](s: Stream[A], start: B, op: Stream.Folding.As[B, A]): B = Stream.Z.consume.aggregate.fold.asPrimRef(s, start.asInstanceOf[Int], op.asInstanceOf[Stream.Folding.Z.PrimRef[Int, A]]).asInstanceOf[B]
  @inline def mkFoldAsRefWithIlk[A, B](s: Stream[A], start: B, op: Stream.Folding.As[B, A]): B = Stream.Z.consume.aggregate.fold.asRefPrim(s.asInstanceOf[Stream[Int]], start, op.asInstanceOf[Stream.Folding.Z.RefPrim[B, Int]])
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
