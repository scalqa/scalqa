package scalqa; package Any; package Class; package Tag

abstract class _Class[-A] private[Class] (t: Tag[_] = null, p: Boolean = true) extends Able.Void {
  type TYPE <: Any

  def name = this.Class.lastName.copyAfterLast("$")

  val isValue: Boolean = t != null

  val isPrimitive: Boolean = p

  val valueTag: Tag[_] = t

  def apply[T]: Tag[T] = this.cast

  def newArray[T](size: Int, dflt: Opt[T] = \/): Array[T] = new Array(newArrayRaw(size, dflt.cast)).cast

  def newArrayRaw[T <: A](size: Int, dflt: Opt[T] = \/): Array.Raw[_ >: T] = _get(size).cast[Array.Raw[T]].I(a => dflt.let(size > 0 && a(0) != _).apply(v => { var i = 0; while (i < size) { a(i) = v; i += 1 } }))

  override def toString = "Tag." + name

  private[Class] def _get(size: Int): Array.Raw[_] = Array.Z.Raw.getObject(size)
}

object _Class extends Z.Implicits.Primary {

  import scala.language.implicitConversions

  implicit def zzGet[A](v: \/.type): Tag[A] = Void

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @class _Class ->
 *
 *    [[Class.Tag]] is a way to categorize all types into 19 groups.
 *
 *    The reason is how Array are implemented by JVM, and each group has its own algorithms in regards to Arrays.
 *
 *    The groups are:
 *
 *       - Primitives: Boolean, Byte, Char, Short,Int, Long,Float, Double
 *
 *       - Primitive Data: ByteValue, CharValue,ShortValue,IntValue,LongValue,FloatValue, DoubleValue
 *
 *       - Objects: RefValue, AnyVal, AnyRef
 *
 *     For example, when we are dealing with primitives, JVM primitive array will be created, which is more efficient.
 *
 *     The good news Scalqa will automatically select which array to use, without user input.
 *
 *     In this regard it is simpler than Scala, where ClassTag is really required.
 *
 *
 */
