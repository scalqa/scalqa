package scalqa; package `val`; package promise; import language.implicitConversions

trait Control[A]:
  def promise                          : Promise[A]
  def complete(v: Result[A])                : Boolean
  def tryComplete(expression: => Result[A]) : Boolean     = try { complete(expression) } catch { case t: Throwable => complete(Result(Result.Problem(t))) }

object Control:
  def apply[T](): Control[T] = z.Control[T]()

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait Control -> ###

Promise control provides the ability to "complete" the controlled promise instance.

    For each promise, there is a control, which is not part of promise API, it is a behind the scenes handle for code fulfilling the promise.


@def promise ->  Controlled promise

    Returns promise attached to this control. There is one to one relation.

@def complete -> Provide result

    Fulfills promise with given result

    Returns `false` if the result is already complete

@def tryComplete -> Try provide result

    Same as [[complete]], but with try-catch block, which will handle any runtime exceptions and turn them into result with problem.

*/