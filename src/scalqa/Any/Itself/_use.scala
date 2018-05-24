package scalqa; package Any; package Itself

trait _use[A] extends Any with __[A] {

  def as[B](c: java.lang.Class[B], f: A => B): B = if (c.isInstance(This)) This.cast else f(This)

  @inline def apply(f: A => Any): A = { f(This); This }

  @inline def run(f: => Any): A = { f; This }

  @inline def to[B](f: A => B): B = f(This)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def as -> Adapt
 *
 *    Adapts ''this'' to the target type
 *
 *    If ''this'' implements target type, simple ''cast'' is returned
 *
 *    Otherwise conversion function is used and the result is returned
 *
 *    {{{
 *       val x:  Index[Int]   = Index.get(1, 2, 3)
 *       val xw: Index.W[Int] = x.I.as(classOf[Index.W[Int]], x => Index.W.get[Int](x.size).I(_ =+~ x))
 *
 *       // check
 *       xw.isInstanceOf[Index.W[Int]].lp  // Prints: true
 *       xw.all.lp                         // Prints: ~(1, 2, 3)
 *    }}}
 *
 * @def apply -> Process
 *
 *    Runs specified function for ''this''
 *
 *    Returns ''this''
 *    {{{
 *      // Defining array and data in one line
 *      val array = Array.get[Int](3).I(a => {a(1)=1;a(2)=2})
 *    }}}
 *
 * @def run -> Execute
 *
 *    Executes specified function, but still returns original value
 *    {{{
 *        var c = 0 // counter
 *
 *        def next = c.I.run(c+=1)        // makes sense in long chains of method calls
 *        // VS.
 *        def next = {val v = c; c+=1; v} // more transparant
 *    }}}
 *
 *
 * @def to -> Convert
 *
 *    Executes function and returns its value.
 *
 *    Though it looks like doing simple things in a complex way, there are benefits when large chain of method calls is involved
 *
 *    {{{
 *        val fun : Int => Int = _ * 2
 *
 *        // Simple case --------------------------------
 *
 *        2.I.to(fun)
 *
 *        // VS.
 *
 *        fun(2)
 *
 *        // Very long statement to apply ---------------
 *
 *        // Logic can be read sequentially
 *        2.<convert>.<convert>.<convert>
 *          .<convert>.<convert>.<convert>
 *          .<convert>.<convert>.<convert>
 *          .<convert>.<convert>.<convert>.I.to(fun)
 *
 *        // VS.
 *
 *        // Logic can be read sequentially
 *        fun(2.<convert>.<convert>.<convert>
 *          .<convert>.<convert>.<convert>
 *          .<convert>.<convert>.<convert>
 *          .<convert>.<convert>.<convert>)
 *    }}}
 */
