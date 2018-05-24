package scalqa

package object Concurrent {
  type Executor = Executor._Class
  type Scheduler = Scheduler._Class
  type Promise[A] = Promise._Trait[A]
  type Control = Control._Trait

  def get[A](calculation: => A)(implicit e: Executor = \/): Concurrent[A] = Promise.get[A].I(p => e.execute(new Runnable {
    def run = p.complete(Opt.orError.get(calculation))
  }))

  def getCompleted[A](value: A): Concurrent[A] = new Z.The.Completed(value)

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def get[ -> By implied function
 *
 *   Creates [[Concurrent]] value with given ''calculation''
 *
 *   @param e executor to run ''calculation'' with. Default will use [[App.Pro.DefaultExecutor]]
 *   @example
 *   {{{
 *     val c = Concurrent.get(2 + 2)
 *
 *     c.onValue( _ lp)  // Prints 4 when value gets available
 *   }}}
 *
 * @def getCompleted -> Already completed calculation
 *
 *    Creates already completed calculation [[Concurrent]] with set result
 *
 */
