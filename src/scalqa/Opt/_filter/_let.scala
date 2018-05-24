package scalqa; package Opt; package _filter

trait _let[+A] extends Any with __[A] {

  def let(f: A => Boolean): Opt[A] = if (_isVal && f(_val)) This else Void

  def letOnly[B >: A](v: B): Opt[A] = if (v == _target) This else Void

  def letIf(test: => Boolean): Opt[A] = if (_isVal && test) This else Void

  def letAs[B](clazz: Class[B]): Opt[B] = if (_isVal && clazz.isInstance(_val)) This.cast else Void

  def letAll[B >: A](a: ~[B]): Opt[A] = if (_isVal && a.findOpt(_ == _val)) This else Void

  // ----------------------------------------------------------------------------------------
  def letPartialMap[B](f: PartialFunction[A, B]): Opt[B] = if (_isVal && f.isDefinedAt(_val)) new Opt(f(_val)) else Void

  def letMap[B](f: A => Opt[B]): Opt[B] = if (_isVal) f(_val) else Void

  def letSwap[B](that: Opt[B]): Opt[B] = if (_isVal) that else Void

  def letMix[B, C](that: Opt[B], mixingFunction: (A, B) => C): Opt[C] = if (_isVal && that._isVal) new Opt(mixingFunction(_val, that._val)) else Void

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait _let -> $let
 *
 *   @define let '''Filter Interface'''
 *
 *        Base word '''let''' means 'allow only' certain values
 *
 *        When value is not allowed, [[Opt.Void]] is returned
 *
 *
 * @def let( ->  Main filter
 *
 *    Discards value if it does not pass given filtering function
 *    {{{
 *       "Abc".Opt.let(_.length > 2).lp  // Prints: Opt(Abc)
 *
 *       "Abc".Opt.let(_.length > 3).lp  // Prints: Opt.Void
 *    }}}
 *    @note Nothing is done if ''this'' is void
 *
 * @def letOnly -> Constant filter
 *
 *    Discards value if it is not equal to the given constant
 *    {{{
 *       "Abc".Opt.letOnly("Abc").lp  // Prints: Opt(Abc)
 *
 *       "Abc".Opt.letOnly("Xyz").lp  // Prints: Opt.Void
 *    }}}
 *    @note Nothing is done if ''this'' is void
 *
 * @def letIf -> Valueless filter
 *
 *    Discards value if filter ''test'' is negative
 *    {{{
 *       "Abc".Opt.letIf(true)  lp  // Prints: Opt(Abc)
 *
 *       "Abc".Opt.letIf(false) lp  // Prints: Opt.Void
 *    }}}
 *    @note Nothing is done if ''this'' is void
 *
 * @def letAs -> Filter and type converter
 *
 *    Discards value if it does not belong to the given type
 *
 *    Note, the result is mapped to the given type
 *    {{{
 *       def o: Opt[Any] = "1"
 *
 *       o.letAs(classOf[String]).lp // Prints: Opt(1)
 *
 *       o.letAs(classOf[Int])   .lp // Prints: Opt.Void
 *    }}}
 *    @note Nothing is done if ''this'' is void
 *
 * @def letAll[ -> Group filter
 *
 *    Discards value if it does not belong to the given group
 *    {{{
 *       3.Opt.letAll(1 <> 10)      .lp  // Prints: Opt(3)
 *
 *       3.Opt.letAll(0 ~ 2 ~ 4 ~ 6).lp  // Prints: Opt.Void
 *    }}}
 *    @note Nothing is done if ''this'' is void
 *
 * @def letMap -> Filter and converter
 *
 *    Discards value if given function returns [[Opt.Void]]
 *
 *    Otherwise value is converted to the function result
 *
 *    {{{
 *       "Abc".Opt.letMap(v => if(v.startsWith("A")) \/ else v).lp  // Prints: Opt.Void
 *
 *       "Xyz".Opt.letMap(v => if(v.startsWith("A")) \/ else v).lp  // Prints: Opt(Xyz)
 *
 *       "Cbs".Opt.letMap({
 *           case s if(s.startsWith("A")) =>  ()
 *           case s => s
 *        }).lp                                                     // Prints: Opt(Cbs)
 *    }}}
 *    @note Nothing is done if ''this'' is void
 *
 * @def letSwap -> Filter and converter
 *
 *    Discards value if ''that'' is [[Opt.Void]]
 *
 *    Otherwise ''that'' is returned
 *
 *    {{{
 *        // Use case:  Within the mouse event checks that 'left button' clicked and some 'position'
 *        //            is present, then the 'position' is processed
 *
 *        onCellMouseClicked((e, c) => e.leftButtonOpt.letSwap(positionOpt).apply(p => {/* Do something */})
 *    }}}
 *    @note Nothing is done if ''this'' is void
 *
 * @def letPartialMap -> Filter and converter
 *
 *    Discards value if given partial function is not defined
 *
 *    {{{
 *         2.Opt.letPartialMap({case v if(v < 5) => v * 10}) .lp   // Prints: Opt(20)
 *
 *         7.Opt.letPartialMap({case v if(v < 5) => v * 10}) .lp   // Prints: Opt.Void
 *    }}}
 *    @note Nothing is done if ''this'' is void
 *
 * @def letMix -> Mix filter
 *
 *    Discards value if ''that'' has no value
 *
 *    Otherwise, ''this'' and ''that'' values are converted with ''mixingFunction''
 *
 *    {{{
 *           12.Opt.letMix( 2.Opt,  _ * _) lp  // Prints: 24
 *
 *         Opt.Void.letMix( 2.Opt,  _ * _) lp  // Prints: Opt.Void
 *
 *           12.Opt.letMix( (),     _ * _) lp  // Prints: Opt.Void
 *    }}}
 *    @note Nothing is done if ''this'' is void
 */
