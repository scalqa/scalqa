package scalqa; package App

object Fail {

  def apply(message: Any*): Nothing = if (message.isEmpty) throw new NoMessage else throw new Message(message.all.format(" "))

  def validate: Nothing = throw new Validate(\/)
  def validate(message: Any*): Nothing = throw new Validate(message.all.format(" "))

  def toDo: Nothing = throw new ToDo(\/)
  def toDo(message: Any*): Nothing = throw new ToDo(message.all.format(" "))

  def unsupported: Nothing = throw new UnsupportedOperation(\/)
  def unsupported(message: Any*): Nothing = throw new UnsupportedOperation(message.all.format(" "))

  def state: Nothing = throw new IllegalState(\/)
  def state(message: Any*): Nothing = throw new IllegalState(message.all.format(" "))

  def argument: Nothing = throw new IllegalArgument(\/)
  def argument(message: Any*): Nothing = throw new IllegalArgument(message.all.format(" "))

  private var count = 0;

  def count(cnt: Int, message: => String = \/): Unit = { count += 1; if (count >= cnt) throw new Message({ val m = message; if (m == null) "count: " + cnt else m }) }

  // ------------------------------------------------------------------
  implicit def zzFunction0[A](v: Fail.type): () => A = Function0.asInstanceOf[() => A]
  implicit def zzFunction1[A, B](v: Fail.type): A => B = Function1.asInstanceOf[A => B]
  implicit def zzFunction2[A, B, C](v: Fail.type): (A, B) => C = Function2.asInstanceOf[(A, B) => C]

  private object Function0 extends (() => Any) with Void { def apply = Fail("App.Fail.Function0") }
  private object Function1 extends ((Any) => Any) with Void { def apply(a: Any) = Fail("App.Fail.Function3") }
  private object Function2 extends ((Any, Any) => Any) with Void { def apply(a: Any, b: Any) = Fail("App.Fail.Function3") }

  // **************************************************************************************************************************
  trait Exception extends java.lang.RuntimeException {
    setStackTrace(getStackTrace.drop(1))

    override def toString = { val n = this.I.Class.lastName; val m = getLocalizedMessage(); if (m != null) n + ": " + m else n }
  }
  class NoMessage extends Exception
  class Message(m: String) extends java.lang.RuntimeException(m \/ null) with Exception
  class ToDo(m: String) extends java.lang.RuntimeException(m \/ null) with Exception
  class IllegalState(m: String) extends java.lang.RuntimeException(m \/ null) with Exception
  class IllegalArgument(m: String) extends java.lang.IllegalArgumentException(m \/ null) with Exception
  class UnsupportedOperation(m: String) extends java.lang.UnsupportedOperationException(m \/ null) with Exception
  class Validate(m: String) extends java.lang.RuntimeException(m \/ null) with Exception
}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @object Fail ->
 *
 *     A shortcut object to throw runtime exceptions
 *
 *     {{{
 *       throw new RuntimeException     // Java way
 *
 *       App.Fail()                     // Scalqa way, throws new [[App.Fail.NoMessage]]
 *     }}}
 *
 * @def apply(message -> Fails execution
 *
 *     Throws new [[App.Fail.Message]] or [[App.Fail.NoMessage]] exception
 *
 *     @param message 0 to many objects put together as String with a space as separator
 *
 * @def toDo: -> Fails "toDo"
 *
 *     Throws new [[App.Fail.ToDo]]
 *
 * @def toDo( -> Fails "toDo"
 *
 *     Throws new [[App.Fail.ToDo]]
 *
 *     @param message 0 to many objects put together as String with space as separator
 *
 * @def unsupported: -> Fails with "Unsupported Operation"
 *
 *     Throws new [[App.Fail.UnsupportedOperation]]
 *
 * @def unsupported( -> Fails with "Unsupported Operation"
 *
 *     Throws new [[App.Fail.UnsupportedOperation]]
 *
 *     @param message 0 to many objects put together as String with space as separator
 *
 * @def state: -> Fails with "Illegal State"
 *
 *     Throws new [[App.Fail.IllegalState]]
 *
 * @def state( -> Fails with "Illegal State"
 *
 *     Throws new [[App.Fail.IllegalState]]
 *
 *     @param message 0 to many objects put together as String with space as separator
 *
 * @def argument: -> Fails with "Illegal Argument"
 *
 *     Throws new [[App.Fail.IllegalArgument]]
 *
 * @def argument( -> Fails with "Illegal Argument"
 *
 *     Throws new [[App.Fail.IllegalArgument]]
 *
 *     @param message 0 to many objects put together as String with space as separator
 *
 * @def validate: -> Fails to validate
 *
 *     Throws new [[App.Fail.Validate]]
 *
 * @def validate( -> Fails to validate
 *
 *     Throws new [[App.Fail.Validate]]
 *
 *     @param message 0 to many objects put together as String with space as separator
 */
