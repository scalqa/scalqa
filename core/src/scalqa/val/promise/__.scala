package scalqa; package `val`; import promise.*; import language.implicitConversions

import Promise.Context

trait Promise[+A]:
  @tn("result_Opt") def result_?                                                 : Opt[Result[A]]
  // ------------------------------------------------------------------------------------------------------------------------------------------
  /**/              def take(f:A=>Boolean,p:A=>Result.Problem)  (using c:Context): Promise[A]     = {val c=Control[A](); onResult(r => c.complete(r.take(f,p)));  c.promise}
  /**/              def drop(f:A=>Boolean,p:A=>Result.Problem)  (using c:Context): Promise[A]     = {val c=Control[A](); onResult(r => c.complete(r.drop(f,p))); c.promise}
  /**/              def map[B](f: A => B)                       (using c:Context): Promise[B]     = mapAll(_.map(f))
  @tn("map_Result") def map_??[B](f: A => Result[B])            (using c:Context): Promise[B]     = mapWith(v => Promise.ready(f(v).cast[B | Result.Problem]))
  /**/              def mapWith[B](f: A => Promise[B])          (using c:Context): Promise[B]     = Z.flatMap(this,f)
  /**/              def mapAll[B](f:Result[A]=>Result[B])       (using c:Context): Promise[B]     = {val c=Control[B](); onResult(v => c.tryComplete(f(v))); c.promise}
  /**/              def zip[B](v: Promise[B])                   (using c:Context): Promise[(A,B)] = Z.zip(this, v)
  // ------------------------------------------------------------------------------------------------------------------------------------------
  /**/              def onResult[U](f: Result[A] => U)          (using c:Context): Unit
  /**/              def forval[U](f: A => U)                    (using c:Context): Promise[A]     = { onResult(_.forval(f));   this }
  /**/              def fornil[U](p: Result.Problem => U)       (using c:Context): Promise[A]     = { onResult(_.fornil(p));   this }
  /**/              def process[U,W](f:A=>U,p:Result.Problem=>W)(using c:Context): Promise[A]     = { onResult(_.process(f,p)); this }
  /**/              def await(v: Time.Length)                   (using c:Context): Result[A]      = Z.await(this, v)

object Promise:
  def apply[A](calc: => A)(using c:Context) : Promise[A] = { val pc=Control[A](); c.execute(new Runnable{def run:Unit=pc.tryComplete(calc.??)}); pc.promise }
  def ready[A](v: A | Result.Problem)       : Promise[A] = v match {case p:Result.Problem => Z.Failed(p); case v => Z.Completed(v.cast[A])}

  extension[A](x: Promise[A])
    inline def withFilter(inline f: A=>Boolean)(using inline c:Context): Promise[A] = x.take(f,_ => Result.Problem.failedFilter)
    inline def flatMap[B](f: A => Promise[B])  (using inline c:Context): Promise[B] = Z.flatMap(x,f)
    inline def foreach[U](inline f: A=>U)      (using inline c:Context): Unit       = x.onResult(_.forval(f))

  given givenDocDef[A](using t: Any.Def.Doc[A]): Any.Def.Doc[Promise[A]] with
    def value_tag(v: Promise[A]) : String   = v.result_?.map(v => "Promise("+v.tag+")") or "Promise(NOT_READY)"
    def value_doc(v: Promise[A]) : Doc      = Doc(v)

  given givenCanEqualPromise[A,B](using CanEqual[A,B]) : CanEqual[Promise[A], Promise[B]] = CanEqual.derived

  // Members ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  transparent inline def Control = promise.Control;  type Control[A] = promise.Control[A]
  transparent inline def Context = promise.Context;  type Context    = promise.Context.TYPE.DEF

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait Promise -> ### Value Promise

     [[Promise]] represents value which will be available later (at some point of time),
     but it can now be incorporated in current calculations

     ```
      val s: String = "Hello"

      val v: Promise[String] = Promise(s + " Concurrent Promise!")

      v.result_?.TP    // Value is likely not available yet

      v.onResult(_.TP) // Will run when value is available

      // Output
      Opt(\/)
      Result(Hello Concurrent Promise!)
     ```

@def map -> Convert value

     Creates a new promise where future value will be converted with given function

     The result with problem will not be affected

@def map_?? -> Map result

     Creates a new promise where future value will be converted to given function result

@def mapWith -> Map with Promise

     Creates a new promise, which will be completed based on promise created with the given function result.

@def mapAll -> Change completly

     Creates a new promise where all outcomes of current promise, both: value and problem will be processed

@def zip -> Join two promises

     Creates a new promise where values of two promises will be returned as tuple.  If either promise fails, the new promise will also be a failure

@def take -> Filter

     Creates a new promise where in case if future value will not satisfy given predicate, it will be replaced with generated problem result

     The result with problem will not be affected

@def drop -> Reversed filter

     Creates a new promise where in case if future value will satisfy given predicate, it will be replaced with generated problem result

     The result with problem will not be affected

@def result_?  -> Optional result

       Returns calculation result if it is available

       ```
         val v = Promise{ 2 * 2 }

         v.result_?.TP        // Likely prints: \/

         J.sleep(1.Second)

         v.result_?.TP        // Likely prints: Opt(Result(4))
       ```
@def onResult -> Run when ready

       Will run the given function, when the result will become available

       ```
        val v = Promise{ 2 * 2 }

        v.onResult("onResult: " + _.tag TP())

        "Immediate Result: " + v.result_? TP()

         // Output
        Immediate Result: Opt(\/)
        onResult: Result(4)
       ```
@def forval -> Process value

    Will run the given function, when value will become available

    Note. The function will never run if promise fails

@def fornil -> Process failure

    Will run the given function, when promise is fulfilled and the result is a problem

    Note. The function will never run if promise is a success

@def process -> Process result

    When promise is fulfilled with a result, the apropriate given function is executed either with value or problem

*/
