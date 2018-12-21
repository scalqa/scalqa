package scalqa; package Idx.I; package Z

private[I] object Primitive {

  abstract class Setup[A: ClassTag, TYPE <: Idx.I[A]](create: Array[A] => TYPE, private val voidVal: Array[A]) extends Util.Void.Setup[TYPE](create(voidVal)) {

    def *(vs: A*): TYPE = if (vs.isEmpty) Void else vs match {
      case a: scala.collection.mutable.WrappedArray[_] => create(a.array.asInstanceOf[Array[A]])
      case _ => {
        val b = vs.all.preview
        val sz = b.previewSize
        val a = new Array[A](sz)
        b.foreachIdx(a(_)= _)
        create(a)
      }
    }

    def repeatValue(value: A, size: Int): TYPE = {
      val a = new Array[A](size)
      if (size > 0 && a(0) != value) a.fill(value)
      create(a)
    }

    def fromArray(v: Array[A]): TYPE = create(v.copyFull)

    private[scalqa] def fromFlow(v: Stream.Flow[A]): TYPE = create({
      val b = Idx.Array.Buffer.makeSized[A](v.sizeOpt or App.initSize)(v.ilkDefault)
      v.copyTo(b.loader)
      b.arrayBase
    })
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 *
 * @def fromArray -> Create from array
 *
 *     Array will be copied
 *
 * @def *( -> VarArg constructor
 *
 *     Creates new instance with elements provided
 *
 *     {{{
 *       // Ints generic example
 *       val v = Ints.*(3, 5, 7, 8)
 *
 *       v.all.lp // Prints: ~(3, 5, 7, 8)
 *     }}}
 *
 * @def repeatValue( -> By repeating value
 *
 *     Creates new instance with single `value` repeated to the given size
 *
 *     {{{
 *       // Ints generic example
 *       val v = Ints.getRepeatValue(99, 10)
 *
 *       v.all.lp // ~(99, 99, 99, 99, 99, 99, 99, 99, 99, 99)
 *     }}}
 */
