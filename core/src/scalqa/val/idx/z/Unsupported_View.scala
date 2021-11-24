package scalqa; package `val`; package idx; package z; import language.implicitConversions

private[scalqa] object Unsupported_View:

  class O[A](protected val real: Idx[A]) extends J.Util.Proxy.Idx[A] with O.Base[A]

  object O:
    trait Base[A] extends Idx.Observable[A]:
      def onChange[U](l: Pack[Observable.Event[A]] => U): Event.Control = \/

    class OM[A](protected val real: Idx.Observable[A]) extends Idx.OM.X.Abstract[A] with J.Util.Proxy.Idx.O.Base[A] with Unsupported_View.OM.Base[A]:
      override def onChange[U](l: Pack[Observable.Event[A]] => U): Event.Control = real.onChange(l)

  class M[A](protected val real: Idx[A]) extends Idx.Mutable.X.Abstract[A] with J.Util.Proxy.Idx.Base[A] with M.Base[A]

  object M:
    trait Base[A] extends Idx.Mutable[A]:
      def addAt(i: Int, e: A)      : Unit = J.unsupportedOperation()
      def updateAt(i: Int, e: A)   : Unit = J.unsupportedOperation()
      def removeRange(r: Int.Range): Unit = J.unsupportedOperation()

    class OM[A](protected val real: Idx.Mutable[A]) extends J.Util.Proxy.Idx.M[A] with Unsupported_View.OM.Base[A]:
      override def addAt(i: Int, e: A)                            : Unit          = real.addAt(i, e)
      override def updateAt(i: Int, e: A)                         : Unit          = real.update(i, e)
      override def removeRange(r: Int.Range)                      : Unit          = real.removeRange(r)
      override def modify(ch: Idx.Mutable[A] => Unit)             : Unit          = ch(this)
      override def onChange[U](l: Pack[Observable.Event[A]] => U) : Event.Control = \/

  class OM[A](protected val real: Idx[A]) extends Idx.OM.X.Abstract[A] with J.Util.Proxy.Idx.Base[A] with OM.Base[A]

  object OM:
    trait Base[A] extends Idx.ObservableMutable[A] with M.Base[A] with O.Base[A]:
      def refreshRange(r: Int.Range)        : Unit = J.unsupportedOperation()
      def modify(ch: Idx.Mutable[A] => Unit): Unit = J.unsupportedOperation()

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
