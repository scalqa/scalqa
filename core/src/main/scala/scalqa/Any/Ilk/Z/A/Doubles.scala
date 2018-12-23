package scalqa; package Any; package Ilk; package Z; package A

private[Ilk] object Doubles extends Base[Double] {

  val RootClass = java.lang.Double.TYPE
  val BoxedClass = classOf[java.lang.Double]
  val ArrayClass = Array.emptyDoubleArray.getClass

  @inline final def mkArray[T](s: Int) = { if (s == 0) Array.emptyDoubleArray else new Array[Double](s) }.asInstanceOf[Array[T]]

  @inline final def mkValue[A](v: Stream.Flow[A]) = Idx.I.Doubles.fromFlow(v.asInstanceOf[Stream.Flow[Double]]).asInstanceOf[Idx.I[A]]
  @inline final def mkValue[A](v: Array[A]) = Idx.I.Doubles.fromArray(v.asInstanceOf[Array[Double]]).asInstanceOf[Idx.I[A]]
  @inline final def mkValueVoid[A] = (\/ : Idx.I.Doubles).asInstanceOf[Idx.I[A]]

  @inline final def mkBuffer[T](s: Opt.Int) = new Idx.Array.Buffer.Doubles(s).asInstanceOf[Idx.Array.Buffer[T]]

  @inline final def mkStream[A](a: Array[A]): Stream[A] = Custom.Array.Z.stream[Double](a.asInstanceOf[Array[Double]]).asInstanceOf[Stream[A]]

  @inline final def mkRange[A](s: A, sx: Boolean, e: A, ex: Boolean, t: Ordering[A]) = new Custom.Double.Z.Range(s.asInstanceOf[Double], sx, e.asInstanceOf[Double], ex).asInstanceOf[Range[A]]

  @inline final def mkMapRefIlk[A, B](s: Stream[A], f: Stream.Mapping[A, B]) = Stream.Z.extend.map.map.refPrim[A, Double](s, f.asInstanceOf[Stream.Mapping.Z.RefPrim[A, Double]], this).asInstanceOf[Stream[B]]
  @inline final def mkMapIlkRef[A, B](s: Stream[A], f: Stream.Mapping[A, B]) = Stream.Z.extend.map.map.primRef[Double, B](s.asInstanceOf[Stream[Double]], f.asInstanceOf[Stream.Mapping.Z.PrimRef[Double, B]], Refs).asInstanceOf[Stream[B]]

  @inline final def mkFlatMapRefIlk[A, B](s: Stream[A], f: Stream.Mapping[A, ~[B]]) = Stream.Z.extend.map.flatMap.refPrim[A, Double](s, f.asInstanceOf[Stream.Mapping[A, ~[Double]]], this).asInstanceOf[Stream[B]]
  @inline final def mkFlatMapIlkRef[A, B](s: Stream[A], f: Stream.Mapping[A, ~[B]]) = Stream.Z.extend.map.flatMap.primRef[Double, B](s.asInstanceOf[Stream[Double]], f.asInstanceOf[Stream.Mapping.Z.PrimRef[Double, ~[B]]], Refs).asInstanceOf[Stream[B]]

  @inline final def mkLetMapRefIlk[A, B](s: Stream[A], f: Stream.Mapping[A, Opt[B]]) = Stream.Z.extend.filter.letMap.refPrim[A, Double](s, f.asInstanceOf[Stream.Mapping[A, Opt[Double]]], this).asInstanceOf[Stream[B]]
  @inline final def mkLetMapIlkRef[A, B](s: Stream[A], f: Stream.Mapping[A, Opt[B]]) = Stream.Z.extend.filter.letMap.primRef[Double, B](s.asInstanceOf[Stream[Double]], f.asInstanceOf[Stream.Mapping.Z.PrimRef[Double, Opt[B]]], Refs).asInstanceOf[Stream[B]]

  @inline final def mkFoldAsIlkWithRef[A, B](s: Stream[A], start: B, op: Stream.Folding.As[B, A]): B = Stream.Z.consume.aggregate.fold.asPrimRef(s, start.asInstanceOf[Double], op.asInstanceOf[Stream.Folding.Z.PrimRef[Double, A]]).asInstanceOf[B]
  @inline final def mkFoldAsRefWithIlk[A, B](s: Stream[A], start: B, op: Stream.Folding.As[B, A]): B = Stream.Z.consume.aggregate.fold.asRefPrim(s.asInstanceOf[Stream[Double]], start, op.asInstanceOf[Stream.Folding.Z.RefPrim[B, Double]])
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
