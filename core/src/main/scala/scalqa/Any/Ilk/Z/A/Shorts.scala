package scalqa; package Any; package Ilk; package Z; package A

private[Ilk] object Shorts extends Base[Short] {

  val RootClass = java.lang.Short.TYPE
  val BoxedClass = classOf[java.lang.Short]
  val ArrayClass = Array.emptyShortArray.getClass

  @inline def mkArray[T](s: Int) = { if (s == 0) Array.emptyShortArray else new Array[Short](s) }.asInstanceOf[Array[T]]

  @inline def mkValue[A](v: Stream.Flow[A]) = Idx.I.Shorts.fromFlow(v.asInstanceOf[Stream.Flow[Short]]).asInstanceOf[Idx.I[A]]
  @inline def mkValue[A](v: Array[A]) = Idx.I.Shorts.fromArray(v.asInstanceOf[Array[Short]]).asInstanceOf[Idx.I[A]]
  @inline def mkValueVoid[A] = (\/ : Idx.I.Shorts).asInstanceOf[Idx.I[A]]

  @inline def mkBuffer[T](s: Opt.Int) = new Idx.Array.Buffer.Shorts(s).asInstanceOf[Idx.Array.Buffer[T]]

  @inline def mkStream[A](a: Array[A]): Stream[A] = Custom.Array.Z.stream[Short](a.asInstanceOf[Array[Short]]).asInstanceOf[Stream[A]]

  @inline def mkRange[A](s: A, sx: Boolean, e: A, ex: Boolean, t: Ordering[A]) = new Custom.Short.Z.Range(s.asInstanceOf[Short], sx, e.asInstanceOf[Short], ex).asInstanceOf[Range[A]]

  @inline def mkMapRefIlk[A, B](s: Stream[A], f: Stream.Mapping[A, B]) = Stream.Z.extend.map.map.refPrim[A, Short](s, f.asInstanceOf[Stream.Mapping.Z.RefPrim[A, Short]], this).asInstanceOf[Stream[B]]
  @inline def mkMapIlkRef[A, B](s: Stream[A], f: Stream.Mapping[A, B]) = Stream.Z.extend.map.map.primRef[Short, B](s.asInstanceOf[Stream[Short]], f.asInstanceOf[Stream.Mapping.Z.PrimRef[Short, B]], Refs).asInstanceOf[Stream[B]]

  @inline def mkFlatMapRefIlk[A, B](s: Stream[A], f: Stream.Mapping[A, ~[B]]) = Stream.Z.extend.map.flatMap.refPrim[A, Short](s, f.asInstanceOf[Stream.Mapping[A, ~[Short]]], this).asInstanceOf[Stream[B]]
  @inline def mkFlatMapIlkRef[A, B](s: Stream[A], f: Stream.Mapping[A, ~[B]]) = Stream.Z.extend.map.flatMap.primRef[Short, B](s.asInstanceOf[Stream[Short]], f.asInstanceOf[Stream.Mapping.Z.PrimRef[Short, ~[B]]], Refs).asInstanceOf[Stream[B]]

  @inline def mkLetMapRefIlk[A, B](s: Stream[A], f: Stream.Mapping[A, Opt[B]]) = Stream.Z.extend.filter.letMap.refPrim[A, Short](s, f.asInstanceOf[Stream.Mapping[A, Opt[Short]]], this).asInstanceOf[Stream[B]]
  @inline def mkLetMapIlkRef[A, B](s: Stream[A], f: Stream.Mapping[A, Opt[B]]) = Stream.Z.extend.filter.letMap.primRef[Short, B](s.asInstanceOf[Stream[Short]], f.asInstanceOf[Stream.Mapping.Z.PrimRef[Short, Opt[B]]], Refs).asInstanceOf[Stream[B]]

  @inline def mkFoldAsIlkWithRef[A, B](s: Stream[A], start: B, op: Stream.Folding.As[B, A]): B = Stream.Z.consume.aggregate.fold.asPrimRef(s, start.asInstanceOf[Short], op.asInstanceOf[Stream.Folding.Z.PrimRef[Short, A]]).asInstanceOf[B]
  @inline def mkFoldAsRefWithIlk[A, B](s: Stream[A], start: B, op: Stream.Folding.As[B, A]): B = Stream.Z.consume.aggregate.fold.asRefPrim(s.asInstanceOf[Stream[Short]], start, op.asInstanceOf[Stream.Folding.Z.RefPrim[B, Short]])
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
