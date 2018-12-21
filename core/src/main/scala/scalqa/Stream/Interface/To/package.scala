package scalqa; package Stream; package Interface

package object To {

  implicit val ArrayView: Converter[scalqa.Idx.I] = Z.consume.convert.ToArray.View
  implicit val ArrayBuffer: Converter[scalqa.Idx.Array.Buffer] = Z.consume.convert.ToArray.Buffer
  implicit val Refs: Converter[scalqa.Idx.I.Refs] = Z.consume.convert.ToArray.Refs

  implicit val Idx: Converter[scalqa.Idx] = ArrayBuffer.I.asInstanceOfTarget
  implicit val IdxW: Converter[scalqa.Idx.M] = ArrayBuffer.I.asInstanceOfTarget
  implicit val IdxWO: Converter[scalqa.Idx.OM] = new Converter[scalqa.Idx.OM] {
    def make[A] = f => { val w = new scalqa.Idx.OM.A.Basic[A](f.sizeOpt or App.initSize); f.foreachSynchronized(w.add); w }
  }
  implicit val IdxArray: Converter[scalqa.Idx.Array] = new Converter[scalqa.Idx.Array] {
    def make[A] = f => new scalqa.Idx.Array[A](f.to[scalqa.Idx.Array.Buffer].arrayBase)
  }

  // "Converter" is not co-variant, so Seq and IndexedSeq are needed both
  implicit val Seq: Converter[scala.Seq] = Z.consume.convert.ToScala.IndexedSeq.I.asInstanceOfTarget
  implicit val IndexedSeq: Converter[scala.IndexedSeq] = Z.consume.convert.ToScala.IndexedSeq
  implicit val List: Converter[scala.List] = Z.consume.convert.ToScala.List
  implicit val Iterator: Converter[scala.Iterator] = Z.consume.convert.ToScala.Iterator
  implicit val Vector: Converter[scala.Vector] = Z.consume.convert.ToScala.Vector
  implicit val Buffer: Converter[scala.collection.mutable.Buffer] = Z.consume.convert.ToScala.Buffer

  implicit val JavaCollection: Converter[java.util.Collection] = Z.consume.convert.ToJava.List.I.asInstanceOfTarget
  implicit val JavaList: Converter[java.util.List] = Z.consume.convert.ToJava.List
  implicit val JavaIterator: Converter[java.util.Iterator] = Z.consume.convert.ToJava.Iterator
  implicit val JavaSpliterator: Converter[java.util.Spliterator] = Z.consume.convert.ToJava.Spliterator
  implicit val JavaStream: Converter[java.util.stream.Stream] = Z.consume.convert.ToJava.Stream
}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @object To ->
 *
 *    [[Converter]] is a standard interface from [[Stream]] to any other type
 *
 *    Once there is an implicit converter instance available in scope, the [[Stream._consume._convert.to  Stream.to]] method will work
 *
 *    {{{
 *       (1 <> 5).all.to[Refs]                     // Returns: Idx.I[Int]
 *
 *       ('A' <> 'D').all.to[List]                 // Returns: scala.List[Char]
 *
 *       ("1" ~+ "2" + "3").all.to[java.util.List]  // Returns: java.util.List[String]
 *    }}}
 */
