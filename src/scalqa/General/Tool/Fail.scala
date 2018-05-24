package scalqa; package General.Tool

object Fail {

  def apply(message: Any*): Nothing = if (message.isEmpty) throw new WithNoMessage else throw new Message(message.all.format(" "))

  def validate(message: Any*): Nothing = throw new Validate(message.all.format(" "))

  def toDo(message: Any*): Nothing = throw new ToDo(message.all.format(" "))

  def unsupported(message: Any*): Nothing = throw new UnsupportedOperation(message.all.format(" "))

  def state(message: Any*): Nothing = throw new IllegalState(message.all.format(" "))

  def argument(message: Any*): Nothing = throw new IllegalArgument(message.all.format(" "))

  def idxSized(i: Int, size: Int): Nothing = apply("Index :", i, "out of range", ((size == 0) ? ("for 0 size", "0 <>> " + size)))

  // ------------------------------------------------------------------
  val Function0: () => Any = _Function0; private object _Function0 extends (() => Any) with Void { def apply = Fail("Fail.Function0") }
  val Function1: ((Any) => Any) = _Function1; private object _Function1 extends ((Any) => Any) with Void { def apply(a: Any) = Fail("Fail.Function3") }
  val Function2: ((Any, Any) => Any) = _Function2; private object _Function2 extends ((Any, Any) => Any) with Void { def apply(a: Any, b: Any) = Fail("Fail.Function3") }

  // ------------------------------------------------------------------
  import scala.language.implicitConversions
  implicit def zzFunction0[A](v: Fail.type): Function0[A] = _Function0.cast
  implicit def zzFunction1[A, B](v: Fail.type): Function1[A, B] = _Function1.cast
  implicit def zzFunction2[A, B, C](v: Fail.type): Function2[A, B, C] = _Function2.cast

  // *******************************************************************
  trait Exception extends java.lang.RuntimeException {
    setStackTrace(getStackTrace.drop(1))

    override def toString = this.Class.lastName.I.to(n => { val m = getLocalizedMessage(); (m != null) ? (n + ": " + m, n) })
  }
  class WithNoMessage extends Exception
  class Message(m: String) extends java.lang.RuntimeException(m ? null) with Exception
  class ToDo(m: String) extends java.lang.RuntimeException(m ? null) with Exception
  class IllegalState(m: String) extends java.lang.RuntimeException(m ? null) with Exception
  class IllegalArgument(m: String) extends java.lang.IllegalArgumentException(m ? null) with Exception
  class UnsupportedOperation(m: String) extends java.lang.UnsupportedOperationException(m ? null) with Exception
  class Validate(m: String) extends java.lang.RuntimeException(m ? null) with Exception
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def apply(message -> throws Fail.Exception
 *
 *     Throws new Fail.Message or Fail.WithNoMessage exception
 *
 *     @param message 0 to many objects put together as String with a space as separator
 *
 * @def toDo -> throws Fail.ToDo
 *
 *     Throws new Fail.ToDo exception
 *
 *     @param message 0 to many objects put together as String with space as separator
 *
 * @def unsupported -> throws Fail.unsupported
 *
 *     Throws new Fail.unsupported exception
 *
 *     @param message 0 to many objects put together as String with space as separator
 *
 * @def state -> throws Fail.state
 *
 *     Throws new Fail.state exception
 *
 *     @param message 0 to many objects put together as String with space as separator
 *
 * @def argument -> throws Fail.IllegalArgument
 *
 *     Throws new Fail.IllegalArgument exception
 *
 *     @param message 0 to many objects put together as String with space as separator
 *
 * @def validate -> throws Fail.Validate
 *
 *     Throws new Fail.Validate exception
 *
 *     @param message 0 to many objects put together as String with space as separator
 *
 * @def idxSized -> throws Fail.Message
 *
 *     Throws new Fail.Message exception with index problem description
 *
 * @val Function0 -> Always fail function
 *
 *     Generic [[Function0]] which always fails on use
 *
 * @val Function1 -> Always fail function
 *
 *     Generic [[Function1]] which always fails on use
 *
 * @val Function2 -> Always fail function
 *
 *     Generic [[Function2]] which always fails on use
 *
 * @object Fail ->
 *
 *     Scalqa does not generally use Java exceptions to indicate recoverable state
 *
 *     So, if there is a failure, this Tool is recommended for use to throw some Fail.Exception
 *
 *     Some methods allow to create more customized exceptions, but this is mostly for information purposes, not for recovery
 *
 *     {{{
 *       throw new RuntimeException   // Java way
 *       Fail()                       // Scalqa way, throws new Fail.WithNoMessage
 *     }}}
 */
