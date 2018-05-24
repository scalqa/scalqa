package scalqa; package Opt

trait _use[+A] extends Any with __[A] with Z.Like._use[A] {

  def orElseOpt[B >: A](that: => Opt[B]): Opt[B] = if (_isVal) This else that

  override def apply(f: A => Any): Opt[A] = { if (_isVal) f(_val); This }

  def applyOr(f: A => Any, or: => Any): Opt[A] = { if (_isVal) f(_val) else or; This }

  override def run(f: => Any): Opt[A] = { if (_isVal) f; This }

  override def voidRun(f: => Any): Opt[A] = { if (isVoid) f; This }

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait _use -> '''Use Interface'''
 *
 * @def orElseOpt -> Default option
 *
 *     Returns ''this'' [[Opt]], or if it is void, then given default
 *
 *     Note. [[Opt._use_library.orOpt Opt.orOpt]] is strictly typed equivalent, which should be used in most cases
 *
 *     {{{
 *         "Abc".Opt orOpt "Xyz".Opt.lp  // Prints: Opt(Abc)
 *
 *         Opt.Void  orOpt "Xyz".Opt.lp  // Prints: Opt(Xyz)
 *     }}}
 */
