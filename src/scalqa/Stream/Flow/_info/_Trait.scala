package scalqa; package Stream; package Flow; package _info

trait _Trait[A] { self: Flow[A] =>

  def ilkOpt: Opt[Any.Ilk]

  def sizeOpt: Opt.Int

  def isParallel: Boolean

  def toInfo = Z.info.toInfo(this)

  @inline private[scalqa] def ilkDefault: Any.Ilk = { val o = ilkOpt; if (o.isVoid) Ilk.Refs else o.value }

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait _Trait -> `Metadata Interface`
 *
 *     Metadata methods can be called many times
 *
 * @def isParallel -> Parallel check
 *
 *     Returns `true` if this [[Flow]] is parallel
 *
 * @def sizeOpt -> Size if known
 *
 *     Stream elements count if known for granted
 *
 *     sizeOpt must be trusted
 *
 *     For example, if sizeOpt returns 0, processing logic should not even attempt to confirm that pipeline is empty
 *
 * @def ilkOpt -> Data [[Any.Ilk]] if known
 *
 *     Stream elements [[Any.Ilk]] if known for granted
 *
 * @def toInfo -> Metadata as String
 *
 *     {{{
 *         ('a' <> 'z').all.let(_ > 'X').map(_.toUpper).toInfo.lp
 *
 *         // Output
 *
 *         Stream.Z.extend.map.toChar\$Default\$4{ilk=Chars,chainDepth=3,preIterate=333}
 *     }}}
 *
 */
