package scalqa; package Index; package Val

abstract class _Class[A] private[Val] extends Index[A] with Able.Plus.Tagged[A] with Able.Plus.At.Tagged[A] with Able.Minus[A] with Able.Minus.At[A] {
  protected type TARGET = _Class[A]

  def size: Int

  protected def _target = this

}

object _Class {

  import scala.language.implicitConversions

  implicit def zzGet[A](v: \/.type): Val[A] = Z.Void.cast

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @class _Class -> '''Immutable Index Collection'''
 *
 *   [[Index.Val]] is an immutable structure
 *
 *   [[Index.Val]] creates custom implementation for every primitive or [[Any.Value]] in order to minimize storage footprint
 *
 *   Main storage structure is an Array, however for AnyRef types sized up to 12, Array is not created in favor of even more efficient Tuple like storage
 *
 *   {{{
 *       Index.Val.get("1").I.lp            // Prints: scalqa.Index.Val.Z.Tupled$_1@17a7cec2
 *       Index.Val.get("1", "2", "3").I.lp  // Prints: scalqa.Index.Val.Z.Tupled$_3@37a71e93
 *       Index.Val.get(1L, 2L).I.lp         // Prints: scalqa.Index.Val.Z.ArrayBased{size=2,raw=LongArray@7eda2dbb}
 *       Index.Val.get('A', 'B', 'C').I.lp  // Prints: scalqa.Index.Val.Z.ArrayBased{size=3,raw=CharArray@3f91beef}
 *   }}}
 *
 */
