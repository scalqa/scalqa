package scalqa; package Concurrent

class _library[+A] private[Concurrent] (private val This: Concurrent[A]) extends AnyVal {
  def asValidated(f: A => Boolean, msg: String = \/)(implicit e: Executor = \/): Concurrent[A] = asResultMap(_.validate(f, msg))

  def asValidatedMap[B](f: A => Opt[B], msg: String = \/)(implicit e: Executor = \/): Concurrent[B] = asResultMap(_.validateMap(f, msg))

  def asMap[B](f: A => B)(implicit e: Executor = \/): Concurrent[B] = asResultMap(_ map f)

  def asResultMap[B](f: Opt.orError[A] => Opt.orError[B])(implicit e: Executor = \/): Concurrent[B] = Promise.get[B].I(p => This.onResult(r => p.completeTry(f(r))))

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def asValidated( -> Validated view
 *
 *    Creates a new [[Concurrent]] value, which is a validated view of ''this''
 *
 *    @param msg message to include if validation fails
 *    @example
 *    {{{
 *       val c = Concurrent.get { 2 * 2 }
 *
 *       c.asValidated(_ > 5, "Need > 5").onResult(_ lp)
 *       c.asValidated(_ < 5, "Need < 5").onResult(_ lp)
 *
 *       // Output
 *       Opt.Error(Fail\$Validate: Need > 5)
 *       Opt(4)
 *    }}}
 *
 * @def asValidatedMap -> Validated mapped view
 *
 *    Creates a new [[Concurrent]] value, which is a validated and mapped view of ''this''
 *
 *    @param msg message to include if validation fails
 *    @example
 *    {{{
 *       val c = Concurrent.get { 2 * 2 }
 *
 *       c.asValidatedMap(_.I.let(_ > 5).map(_ * 10d), "Need > 5").onResult(_ lp)
 *       c.asValidatedMap(_.I.let(_ < 5).map(_ * 10d), "Need < 5").onResult(_ lp)
 *
 *       // Output
 *       Opt.Error(Fail\$Validate: Need > 5)
 *       Opt(40.0)
 *    }}}
 *
 * @def asMap[ -> Mapped view
 *
 *    Creates a new [[Concurrent]] value, which is mapped view of ''this''
 *    {{{
 *       val c = Concurrent.get { 2 * 2 }
 *
 *       c.asMap(_ * 10).onResult(_ lp)    // Prints: Opt(40)
 *
 *       c.asMap(_ * 100).onResult(_ lp)   // Prints: Opt(400)
 *
 *       c.asMap(_ * 1000).onResult(_ lp)  // Prints: Opt(4000)
 *    }}}
 *
 * @def asResultMap -> Mapped result view
 *
 *    Creates a new [[Concurrent]] value, which is mapped result view of ''this''
 *
 *    {{{
 *      Concurrent.get(2 * 2).asResultMap(_.map(_ + 10).default(99)).onResult(_ lp)
 *      Concurrent.get(2 / 0).asResultMap(_.map(_ + 10).default(99)).onResult(_ lp)
 *      // Output
 *      Opt(14)
 *      Opt(99)
 *
 *      Concurrent.get(2 / 2).asResultMap[String](_.isValue ? ("OK", Fail("No luck"))).onResult(_ lp)
 *      Concurrent.get(2 / 0).asResultMap[String](_.isValue ? ("OK", Fail("No luck"))).onResult(_ lp)
 *      // Output
 *      Opt(OK)
 *      Opt.Error(Fail\$Message: No luck)
 *    }}}
 */
