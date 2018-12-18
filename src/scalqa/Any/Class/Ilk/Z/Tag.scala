package scalqa; package Any; package Class; package Ilk; package Z

private[Ilk] object Tag {

  // **********************************************************************************
  object Val extends ObjectLike[AnyVal] {

    def ilkOpt = Objects

    override def toString = "ValTag"

  }

  // **********************************************************************************
  object Void extends ObjectLike[Any] with Void {

    def ilkOpt = Opt.Void

    override def toString = "VoidTag"

  }

  // **********************************************************************************
  trait ObjectLike[A] extends Tag[A] {

    def primitiveOpt = Opt.Void

    def isPrimitive = false

    val RootClass = classOf[AnyRef]
    val BoxedClass = classOf[AnyRef]
    val ArrayClass = Array.emptyObjectArray.getClass

    @inline def mkArray[T](s: Int) = { if (s == 0) Array.emptyObjectArray else new Array[Object](s) }.asInstanceOf[Array[T]]
    @inline def mkValue[A](v: Stream.Flow[A]) = Idx.I.Refs.fromFlow(v.asInstanceOf[Stream.Flow[A]]).asInstanceOf[Idx.I[A]]
    @inline def mkValue[A](v: Array[A]) = Idx.I.Refs.copy(v)
    @inline def mkValueVoid[T]: Idx.I[T] = Idx.I.Refs.void[T](this.asInstanceOf[Tag[T]])

    @inline def mkBuffer[T](s: Opt.Int) = new Idx.Array.Buffer.Refs[T](s)
    @inline def mkStream[A](a: Array[A]): Stream[A] = Custom.Array.Z.stream[A](a)
    @inline def mkRange[A](start: A, startEx: Boolean, end: A, endEx: Boolean, o: Ordering[A]): Range[A] = new Util.Range.Z.A.Any[A](start, startEx, end, endEx, o)

    @inline def mkMapRefIlk[A, B](s: Stream[A], f: Stream.Mapping[A, B]): Stream[B] = Stream.Z.extend.map.map.refRef(s, f, Objects)
    @inline def mkMapIlkRef[A, B](s: Stream[A], f: Stream.Mapping[A, B]): Stream[B] = Stream.Z.extend.map.map.refRef(s, f, Objects)

    @inline def mkFlatMapRefIlk[A, B](s: Stream[A], f: Stream.Mapping[A, ~[B]]): Stream[B] = Stream.Z.extend.map.flatMap.refRef(s, f, Objects)
    @inline def mkFlatMapIlkRef[A, B](s: Stream[A], f: Stream.Mapping[A, ~[B]]): Stream[B] = Stream.Z.extend.map.flatMap.refRef(s, f, Objects)

    @inline def mkLetMapRefIlk[A, B](s: Stream[A], f: Stream.Mapping[A, Opt[B]]) = Stream.Z.extend.filter.letMap.refRef(s, f, Objects)
    @inline def mkLetMapIlkRef[A, B](s: Stream[A], f: Stream.Mapping[A, Opt[B]]) = Stream.Z.extend.filter.letMap.refRef(s, f, Objects)

    @inline def mkFoldAsIlkWithRef[A, B](s: Stream[A], start: B, op: Stream.Folding.As[B, A]): B = Stream.Z.consume.aggregate.fold.as(s, start, op)
    @inline def mkFoldAsRefWithIlk[A, B](s: Stream[A], start: B, op: Stream.Folding.As[B, A]): B = Stream.Z.consume.aggregate.fold.as(s, start, op)
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
