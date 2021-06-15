package scalqa; package `val`; package pro; import language.implicitConversions

private[`val`] object Z:

  class Function0[A](source: => A) extends pro.X.Base[A] { def apply() = source }

  class Named[A](val name: String, source: => A, dependencies: ~[Gen.Observable]) extends observable.X.Basic(source, dependencies) with Able.Name

  class NamedRefreshable[A](name: String, source: => A, dependencies: ~[Gen.Observable]) extends Named[A](name, source, dependencies) with Able.Refresh { def refresh = fireChange }

  class Refreshable[A](source: => A, dependencies: ~[Gen.Observable]) extends observable.X.Basic(source, dependencies) with Able.Refresh { def refresh = fireChange }

  class NoEventsWrap[A](value: A) extends Observable[A]:
    def apply()                = value
    def onChange[U](f: () => U) = \/

  class Constant[A](v: A) extends Observable[A]:
    def apply(): A = v
    def onChange[U](f: () => U) = \/

  class Sealable[A](v: A) extends mutable.X.Basic[A](v) with Able.Seal:
    private var _sealed = false
    def isSealed = _sealed
    def seal: this.type = { _sealed = true; this }
    override def update(v: A) = { Able.Seal.check(this); super.update(v) }

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
