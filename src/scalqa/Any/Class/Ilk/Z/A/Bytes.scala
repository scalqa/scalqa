package scalqa; package Any; package Class; package Ilk; package Z; package A

private[Ilk] object Bytes extends Base[Byte] {

  val RootClass = java.lang.Byte.TYPE
  val BoxedClass = classOf[java.lang.Byte]
  val ArrayClass = Array.emptyByteArray.getClass

  @inline def mkArray[T](s: Int) = { if (s == 0) Array.emptyByteArray else new Array[Byte](s) }.asInstanceOf[Array[T]]

  @inline def mkValue[A](v: Stream.Flow[A]) = Idx.I.Bytes.fromFlow(v.asInstanceOf[Stream.Flow[Byte]]).asInstanceOf[Idx.I[A]]
  @inline def mkValue[A](v: Array[A]) = Idx.I.Bytes.fromArray(v.asInstanceOf[Array[Byte]]).asInstanceOf[Idx.I[A]]
  @inline def mkValueVoid[A] = (\/ : Idx.I.Bytes).asInstanceOf[Idx.I[A]]

  @inline def mkBuffer[T](s: Opt.Int) = new Idx.Array.Buffer.Bytes(s).asInstanceOf[Idx.Array.Buffer[T]]

  @inline def mkStream[A](a: Array[A]): Stream[A] = Custom.Array.Z.stream[Byte](a.asInstanceOf[Array[Byte]]).asInstanceOf[Stream[A]]

  @inline def mkRange[A](s: A, sx: Boolean, e: A, ex: Boolean, t: Ordering[A]) = new Custom.Byte.Z.Range(s.asInstanceOf[Byte], sx, e.asInstanceOf[Byte], ex).asInstanceOf[Range[A]]

  @inline def mkMapRefIlk[A, B](s: Stream[A], f: Stream.Mapping[A, B]) = Stream.Z.extend.map.map.refPrim[A, Byte](s, f.asInstanceOf[Stream.Mapping.Z.RefPrim[A, Byte]], this).asInstanceOf[Stream[B]]
  @inline def mkMapIlkRef[A, B](s: Stream[A], f: Stream.Mapping[A, B]) = Stream.Z.extend.map.map.primRef[Byte, B](s.asInstanceOf[Stream[Byte]], f.asInstanceOf[Stream.Mapping.Z.PrimRef[Byte, B]], Objects).asInstanceOf[Stream[B]]

  @inline def mkFlatMapRefIlk[A, B](s: Stream[A], f: Stream.Mapping[A, ~[B]]) = Stream.Z.extend.map.flatMap.refPrim[A, Byte](s, f.asInstanceOf[Stream.Mapping[A, ~[Byte]]], this).asInstanceOf[Stream[B]]
  @inline def mkFlatMapIlkRef[A, B](s: Stream[A], f: Stream.Mapping[A, ~[B]]) = Stream.Z.extend.map.flatMap.primRef[Byte, B](s.asInstanceOf[Stream[Byte]], f.asInstanceOf[Stream.Mapping.Z.PrimRef[Byte, ~[B]]], Objects).asInstanceOf[Stream[B]]

  @inline def mkLetMapRefIlk[A, B](s: Stream[A], f: Stream.Mapping[A, Opt[B]]) = Stream.Z.extend.filter.letMap.refPrim[A, Byte](s, f.asInstanceOf[Stream.Mapping[A, Opt[Byte]]], this).asInstanceOf[Stream[B]]
  @inline def mkLetMapIlkRef[A, B](s: Stream[A], f: Stream.Mapping[A, Opt[B]]) = Stream.Z.extend.filter.letMap.primRef[Byte, B](s.asInstanceOf[Stream[Byte]], f.asInstanceOf[Stream.Mapping.Z.PrimRef[Byte, Opt[B]]], Objects).asInstanceOf[Stream[B]]

  @inline def mkFoldAsIlkWithRef[A, B](s: Stream[A], start: B, op: Stream.Folding.As[B, A]): B = Stream.Z.consume.aggregate.fold.asPrimRef(s, start.asInstanceOf[Byte], op.asInstanceOf[Stream.Folding.Z.PrimRef[Byte, A]]).asInstanceOf[B]
  @inline def mkFoldAsRefWithIlk[A, B](s: Stream[A], start: B, op: Stream.Folding.As[B, A]): B = Stream.Z.consume.aggregate.fold.asRefPrim(s.asInstanceOf[Stream[Byte]], start, op.asInstanceOf[Stream.Folding.Z.RefPrim[B, Byte]])
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
