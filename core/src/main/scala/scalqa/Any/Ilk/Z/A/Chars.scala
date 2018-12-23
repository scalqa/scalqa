package scalqa; package Any; package Ilk; package Z; package A

private[Ilk] object Chars extends Base[Char] {

  val RootClass = java.lang.Character.TYPE
  val BoxedClass = classOf[java.lang.Character]
  val ArrayClass = Array.emptyCharArray.getClass

  @inline final def mkArray[T](s: Int) = { if (s == 0) Array.emptyCharArray else new Array[Char](s) }.asInstanceOf[Array[T]]

  @inline final def mkValue[A](v: Stream.Flow[A]) = Idx.I.Chars.fromFlow(v.asInstanceOf[Stream.Flow[Char]]).asInstanceOf[Idx.I[A]]
  @inline final def mkValue[A](v: Array[A]) = Idx.I.Chars.fromArray(v.asInstanceOf[Array[Char]]).asInstanceOf[Idx.I[A]]
  @inline final def mkValueVoid[A] = (\/ : Idx.I.Chars).asInstanceOf[Idx.I[A]]

  @inline final def mkBuffer[T](s: Opt.Int) = new Idx.Array.Buffer.Chars(s).asInstanceOf[Idx.Array.Buffer[T]]

  @inline final def mkStream[A](a: Array[A]): Stream[A] = Custom.Array.Z.stream[Char](a.asInstanceOf[Array[Char]]).asInstanceOf[Stream[A]]

  @inline final def mkRange[A](s: A, sx: Boolean, e: A, ex: Boolean, t: Ordering[A]) = new Custom.Char.Z.Range(s.asInstanceOf[Char], sx, e.asInstanceOf[Char], ex).asInstanceOf[Range[A]]

  @inline final def mkMapRefIlk[A, B](s: Stream[A], f: Stream.Mapping[A, B]) = Stream.Z.extend.map.map.refPrim[A, Char](s, f.asInstanceOf[Stream.Mapping.Z.RefPrim[A, Char]], this).asInstanceOf[Stream[B]]
  @inline final def mkMapIlkRef[A, B](s: Stream[A], f: Stream.Mapping[A, B]) = Stream.Z.extend.map.map.primRef[Char, B](s.asInstanceOf[Stream[Char]], f.asInstanceOf[Stream.Mapping.Z.PrimRef[Char, B]], Refs).asInstanceOf[Stream[B]]

  @inline final def mkFlatMapRefIlk[A, B](s: Stream[A], f: Stream.Mapping[A, ~[B]]) = Stream.Z.extend.map.flatMap.refPrim[A, Char](s, f.asInstanceOf[Stream.Mapping[A, ~[Char]]], this).asInstanceOf[Stream[B]]
  @inline final def mkFlatMapIlkRef[A, B](s: Stream[A], f: Stream.Mapping[A, ~[B]]) = Stream.Z.extend.map.flatMap.primRef[Char, B](s.asInstanceOf[Stream[Char]], f.asInstanceOf[Stream.Mapping.Z.PrimRef[Char, ~[B]]], Refs).asInstanceOf[Stream[B]]

  @inline final def mkLetMapRefIlk[A, B](s: Stream[A], f: Stream.Mapping[A, Opt[B]]) = Stream.Z.extend.filter.letMap.refPrim[A, Char](s, f.asInstanceOf[Stream.Mapping[A, Opt[Char]]], this).asInstanceOf[Stream[B]]
  @inline final def mkLetMapIlkRef[A, B](s: Stream[A], f: Stream.Mapping[A, Opt[B]]) = Stream.Z.extend.filter.letMap.primRef[Char, B](s.asInstanceOf[Stream[Char]], f.asInstanceOf[Stream.Mapping.Z.PrimRef[Char, Opt[B]]], Refs).asInstanceOf[Stream[B]]

  @inline final def mkFoldAsIlkWithRef[A, B](s: Stream[A], start: B, op: Stream.Folding.As[B, A]): B = Stream.Z.consume.aggregate.fold.asPrimRef(s, start.asInstanceOf[Char], op.asInstanceOf[Stream.Folding.Z.PrimRef[Char, A]]).asInstanceOf[B]
  @inline final def mkFoldAsRefWithIlk[A, B](s: Stream[A], start: B, op: Stream.Folding.As[B, A]): B = Stream.Z.consume.aggregate.fold.asRefPrim(s.asInstanceOf[Stream[Char]], start, op.asInstanceOf[Stream.Folding.Z.RefPrim[B, Char]])
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
