package scalqa; package Opt; package Z; package Like

private[Opt] trait _use[+A] extends Any with __[A] with scalqa.Able.Void {

  def value: A = if (_isVal) _val else throw new IllegalStateException("called 'value' for Empty Opt")

  override def isVoid = _target == Z.Empty.Void || _target == Z.Empty.VoidAlt

  def isValue = _isVal

  def contains(parameter: Any): Boolean = parameter == _target

  def run(f: => Any): __[A]

  def apply(f: A => Any): __[A]

  def voidRun(f: => Any): __[A]

  def orElse[B >: A](default: => B): B = if (_isVal) _val else default

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
 * @def orElse[ ->  Value or default
 *
 *     Returns value, or if none, then given default
 *
 *     Note. [[Opt._use_library.or Opt.or]] is strictly typed equivalent, which should be used in most cases
 *
 *     {{{
 *         "Abc".Opt or "Xyz".lp  // Prints: Abc
 *
 *         Opt.Void  or "Xyz".lp  // Prints: Xyz
 *     }}}
 *
 * @def isVoid -> Check if void
 *
 *   Returns ''true'' if this is void option, 'false' - otherwise
 *   {{{
 *       12.Opt.isVoid.lp            // Prints: false
 *
 *       12.Opt.let(NONE).isVoid.lp  // Prints: true
 *   }}}
 *
 * @def isValue -> Check for value
 *
 *   Returns ''true'' if ''this'' option holds value, 'false' - otherwise
 *   {{{
 *       12.Opt.isValue.lp            // Prints: true
 *
 *       12.Opt.let(NONE).isValue.lp  // Prints: false
 *   }}}
 *
 * @def value -> Value
 *
 *   Returns value, or if void - fails
 *   {{{
 *       12.Opt.value.lp            // Prints: 12
 *
 *       12.Opt.let(NONE).value.lp  // Fails on execution
 *   }}}
 *
 * @def apply -> Process value
 *
 *   Executes given function with value, only if there is value
 *
 *   {{{
 *       12.Opt.apply(_ * 2 lp) // Prints: 24
 *
 *       12.Opt(_ * 4 lp)       // Prints: 48
 *   }}}
 *
 * @def run( ->  Run for value
 *
 *   Executes given function, only if there is value
 *   {{{
 *       12.Opt.run("111".lp)           // Prints: 111
 *
 *       12.Opt.let(NONE).run("222".lp) // Prints: <nothing>
 *   }}}
 *
 * @def voidRun -> Run if void
 *
 *   Executes given function, only if there is no value
 *
 *   {{{
 *       12.Opt.voidRun("111".lp)           // Prints: <nothing>
 *
 *       12.Opt.let(NONE).voidRun("222".lp) // Prints: 222
 *   }}}
 *
 * @def contains -> Check contains
 *
 *   Returns 'true' only if there is value and it is equal to the given ''parameter''
 *
 *   'false' - otherwise
 *
 *   {{{
 *       12.Opt.contains(12).lp            // Prints: true
 *
 *       12.Opt.let(NONE).contains(12).lp  // Prints: false
 *   }}}
 */
