package scalqa; package Any; package Ilk; package Z

private[Ilk] object Tag {

  // **********************************************************************************
  object Val extends ObjectLike[AnyVal] {

    def ilkOpt = Refs

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

    @inline final def mkArray[B](s: Int) = { if (s == 0) Array.emptyObjectArray else new Array[Object](s) }.asInstanceOf[Array[B]]
    @inline final def mkValue[B](v: Stream.Flow[B]) = Idx.I.Refs.fromFlow(v.asInstanceOf[Stream.Flow[B]]).asInstanceOf[Idx.I[B]]
    @inline final def mkValue[B](v: Array[B]) = Idx.I.Refs.copy(v)
    @inline final def mkValueVoid[B]: Idx.I[B] = Idx.I.Refs.void[B](this.asInstanceOf[Tag[B]])

    @inline final def mkBuffer[B](s: Opt.Int) = new Idx.Array.Buffer.Refs[B](s)
    @inline final def mkStream[B](a: Array[B]): Stream[B] = Custom.Array.Z.stream[B](a)
    @inline final def mkRange[B](start: B, startEx: Boolean, end: B, endEx: Boolean, o: Ordering[B]): Range[B] = new Util.Range.Z.A.Any[B](start, startEx, end, endEx, o)

    @inline final def mkMapRefIlk[B, C](s: Stream[B], f: Stream.Mapping[B, C]): Stream[C] = Stream.Z.extend.map.map.refRef(s, f, Refs)
    @inline final def mkMapIlkRef[B, C](s: Stream[B], f: Stream.Mapping[B, C]): Stream[C] = Stream.Z.extend.map.map.refRef(s, f, Refs)

    @inline final def mkFlatMapRefIlk[B, C](s: Stream[B], f: Stream.Mapping[B, ~[C]]): Stream[C] = Stream.Z.extend.map.flatMap.refRef(s, f, Refs)
    @inline final def mkFlatMapIlkRef[B, C](s: Stream[B], f: Stream.Mapping[B, ~[C]]): Stream[C] = Stream.Z.extend.map.flatMap.refRef(s, f, Refs)

    @inline final def mkLetMapRefIlk[B, C](s: Stream[B], f: Stream.Mapping[B, Opt[C]]) = Stream.Z.extend.filter.letMap.refRef(s, f, Refs)
    @inline final def mkLetMapIlkRef[B, C](s: Stream[B], f: Stream.Mapping[B, Opt[C]]) = Stream.Z.extend.filter.letMap.refRef(s, f, Refs)

    @inline final def mkFoldAsIlkWithRef[B, C](s: Stream[B], start: C, op: Stream.Folding.As[C, B]): C = Stream.Z.consume.aggregate.fold.as(s, start, op)
    @inline final def mkFoldAsRefWithIlk[B, C](s: Stream[B], start: C, op: Stream.Folding.As[C, B]): C = Stream.Z.consume.aggregate.fold.as(s, start, op)
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
