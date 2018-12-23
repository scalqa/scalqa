package scalqa; package Any; package Ilk; package Z; package A

private[Ilk] object Floats extends Base[Float] {

  val RootClass = java.lang.Float.TYPE
  val BoxedClass = classOf[java.lang.Float]
  val ArrayClass = Array.emptyFloatArray.getClass

  @inline final def mkArray[T](s: Int) = { if (s == 0) Array.emptyFloatArray else new Array[Float](s) }.asInstanceOf[Array[T]]

  @inline final def mkValue[A](v: Stream.Flow[A]) = Idx.I.Floats.fromFlow(v.asInstanceOf[Stream.Flow[Float]]).asInstanceOf[Idx.I[A]]
  @inline final def mkValue[A](v: Array[A]) = Idx.I.Floats.fromArray(v.asInstanceOf[Array[Float]]).asInstanceOf[Idx.I[A]]
  @inline final def mkValueVoid[A] = (\/ : Idx.I.Floats).asInstanceOf[Idx.I[A]]

  @inline final def mkBuffer[T](s: Opt.Int) = new Idx.Array.Buffer.Floats(s).asInstanceOf[Idx.Array.Buffer[T]]

  @inline final def mkStream[A](a: Array[A]): Stream[A] = Custom.Array.Z.stream[Float](a.asInstanceOf[Array[Float]]).asInstanceOf[Stream[A]]

  @inline final def mkRange[A](s: A, sx: Boolean, e: A, ex: Boolean, t: Ordering[A]) = new Custom.Float.Z.Range(s.asInstanceOf[Float], sx, e.asInstanceOf[Float], ex).asInstanceOf[Range[A]]

  @inline final def mkMapRefIlk[A, B](s: Stream[A], f: Stream.Mapping[A, B]) = Stream.Z.extend.map.map.refPrim[A, Float](s, f.asInstanceOf[Stream.Mapping.Z.RefPrim[A, Float]], this).asInstanceOf[Stream[B]]
  @inline final def mkMapIlkRef[A, B](s: Stream[A], f: Stream.Mapping[A, B]) = Stream.Z.extend.map.map.primRef[Float, B](s.asInstanceOf[Stream[Float]], f.asInstanceOf[Stream.Mapping.Z.PrimRef[Float, B]], Refs).asInstanceOf[Stream[B]]

  @inline final def mkFlatMapRefIlk[A, B](s: Stream[A], f: Stream.Mapping[A, ~[B]]) = Stream.Z.extend.map.flatMap.refPrim[A, Float](s, f.asInstanceOf[Stream.Mapping[A, ~[Float]]], this).asInstanceOf[Stream[B]]
  @inline final def mkFlatMapIlkRef[A, B](s: Stream[A], f: Stream.Mapping[A, ~[B]]) = Stream.Z.extend.map.flatMap.primRef[Float, B](s.asInstanceOf[Stream[Float]], f.asInstanceOf[Stream.Mapping.Z.PrimRef[Float, ~[B]]], Refs).asInstanceOf[Stream[B]]

  @inline final def mkLetMapRefIlk[A, B](s: Stream[A], f: Stream.Mapping[A, Opt[B]]) = Stream.Z.extend.filter.letMap.refPrim[A, Float](s, f.asInstanceOf[Stream.Mapping[A, Opt[Float]]], this).asInstanceOf[Stream[B]]
  @inline final def mkLetMapIlkRef[A, B](s: Stream[A], f: Stream.Mapping[A, Opt[B]]) = Stream.Z.extend.filter.letMap.primRef[Float, B](s.asInstanceOf[Stream[Float]], f.asInstanceOf[Stream.Mapping.Z.PrimRef[Float, Opt[B]]], Refs).asInstanceOf[Stream[B]]

  @inline final def mkFoldAsIlkWithRef[A, B](s: Stream[A], start: B, op: Stream.Folding.As[B, A]): B = Stream.Z.consume.aggregate.fold.asPrimRef(s, start.asInstanceOf[Float], op.asInstanceOf[Stream.Folding.Z.PrimRef[Float, A]]).asInstanceOf[B]
  @inline final def mkFoldAsRefWithIlk[A, B](s: Stream[A], start: B, op: Stream.Folding.As[B, A]): B = Stream.Z.consume.aggregate.fold.asRefPrim(s.asInstanceOf[Stream[Float]], start, op.asInstanceOf[Stream.Folding.Z.RefPrim[B, Float]])
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
