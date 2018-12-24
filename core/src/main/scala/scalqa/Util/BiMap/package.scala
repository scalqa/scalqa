package scalqa; package Util

package object BiMap {
  private[scalqa] def This = this

  def apply[A, B](applyFun: A => B, undoFun: B => A): BiMap[A, B] = new BiMap[A, B] { def apply(a: A) = applyFun(a); def undo(b: B) = undoFun(b) }

  def make[A, B](applyFun: A => B, undoFun: B => A): BiMap[A, B] = new BiMap[A, B] { def apply(a: A) = applyFun(a); def undo(b: B) = undoFun(b) }

  def oneWay[A, B](applyFun: A => B): BiMap[A, B] = new BiMap[A, B] { def apply(a: A) = applyFun(a); def undo(b: B) = App.Fail.unsupported() }

  def asCast[A, B]: BiMap[A, B] = Cast.asInstanceOf[BiMap[A, B]]

  // ********************************************
  private object Cast extends BiMap[Any, Any] {
    def apply(a: Any) = a
    def undo(b: Any) = b
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 *  @def apply[ -> 'make' overload
 *
 *     Same as 'make' for shorter expression where applicable
 *
 *  @def make[ -> By functions
 *
 *    Creates [[BiMap]] with provided `applyFun` and `undoFun` functions
 *    {{{
 *        val bm: BiMap[Int, Long] = BiMap(_ * 1000, l => (l / 1000).toInt)
 *    }}}
 *
 *  @def oneWay -> By function
 *
 *    Creates [[BiMap]] with provided `applyFun`
 *
 *    `undo` functionality will `App.Fail.unsupported`
 *
 *  @def asCast -> Simple cast
 *
 *    Returns [[BiMap]] where all conversion is done by simple cast
 *
 *    Essentially, target and result types must be same
 *    {{{
 *        val bm : BiMap[Int,Int] = BiMap.getCast
 *    }}}
 */
