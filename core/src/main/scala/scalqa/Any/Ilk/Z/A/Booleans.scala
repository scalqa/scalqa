package scalqa; package Any; package Ilk; package Z; package A

private[Ilk] object Booleans extends Base[Boolean] {

  val RootClass = java.lang.Boolean.TYPE
  val BoxedClass = classOf[java.lang.Boolean]
  val ArrayClass = Array.emptyBooleanArray.getClass

  @inline final def mkArray[T](s: Int) = { if (s == 0) Array.emptyBooleanArray else new Array[Boolean](s) }.asInstanceOf[Array[T]]

  @inline final def mkValue[A](v: Stream.Flow[A]) = Idx.I.Booleans.fromFlow(v.asInstanceOf[Stream.Flow[Boolean]]).asInstanceOf[Idx.I[A]]
  @inline final def mkValue[A](v: Array[A]) = Idx.I.Booleans.fromArray(v.asInstanceOf[Array[Boolean]]).asInstanceOf[Idx.I[A]]
  @inline final def mkValueVoid[A] = (\/ : Idx.I.Booleans).asInstanceOf[Idx.I[A]]

  @inline final def mkBuffer[T](s: Opt.Int) = new Idx.Array.Buffer.Booleans(s).asInstanceOf[Idx.Array.Buffer[T]]

  @inline final def mkStream[A](a: Array[A]): Stream[A] = Custom.Array.Z.stream[Boolean](a.asInstanceOf[Array[Boolean]]).asInstanceOf[Stream[A]]

  @inline final def mkRange[A](start: A, startEx: Boolean, end: A, endEx: Boolean, o: Ordering[A]) = App.Fail("No range for Boolean")

  @inline final def mkMapRefIlk[A, B](s: Stream[A], f: Stream.Mapping[A, B]): Stream[B] = Stream.Z.extend.map.map.refRef(s, f, this)
  @inline final def mkMapIlkRef[A, B](s: Stream[A], f: Stream.Mapping[A, B]): Stream[B] = Stream.Z.extend.map.map.refRef(s, f, Refs)

  @inline final def mkFlatMapRefIlk[A, B](s: Stream[A], f: Stream.Mapping[A, ~[B]]): Stream[B] = Stream.Z.extend.map.flatMap.refRef(s, f, Refs)
  @inline final def mkFlatMapIlkRef[A, B](s: Stream[A], f: Stream.Mapping[A, ~[B]]): Stream[B] = Stream.Z.extend.map.flatMap.refRef(s, f, Refs)

  @inline final def mkLetMapRefIlk[A, B](s: Stream[A], f: Stream.Mapping[A, Opt[B]]) = Stream.Z.extend.filter.letMap.refPrim[A, Boolean](s, f.asInstanceOf[Stream.Mapping[A, Opt[Boolean]]], this).asInstanceOf[Stream[B]]
  @inline final def mkLetMapIlkRef[A, B](s: Stream[A], f: Stream.Mapping[A, Opt[B]]) = Stream.Z.extend.filter.letMap.primRef[Boolean, B](s.asInstanceOf[Stream[Boolean]], f.asInstanceOf[Stream.Mapping.Z.PrimRef[Boolean, Opt[B]]], Refs).asInstanceOf[Stream[B]]

  @inline final def mkFoldAsIlkWithRef[A, B](s: Stream[A], start: B, op: Stream.Folding.As[B, A]): B = Stream.Z.consume.aggregate.fold.as(s, start, op)
  @inline final def mkFoldAsRefWithIlk[A, B](s: Stream[A], start: B, op: Stream.Folding.As[B, A]): B = Stream.Z.consume.aggregate.fold.as(s, start, op)
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
