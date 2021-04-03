package scalqa; package `def`; package long; package g; import language.implicitConversions

 trait Pro[A<:RAW] extends Val.Pro[A] with any.self.info.Specialized.OnLong:
  def apply(): A

object Pro:

  trait  Mutable[A<:RAW] extends Pro[A] with Val.Pro.M[A] { def update(v: A): Unit }
  object Mutable:
    object X:
      class Basic[A<:RAW](v: A) extends Mutable[A]:
        private var value        : A     = v
        /**/    def apply()      : A     = value
        /**/    def update(v: A) : Unit  = value = v

  trait  Observable[A<:RAW] extends Pro[A] with Val.Pro.O[A]
  object Observable:
    object X:
      abstract class Abstract[A<:RAW] extends Val.Pro.Observable.X.Abstract[A] with Observable[A]

  trait  ObservableMutable[A<:RAW] extends Mutable[A] with Observable[A] with Val.Pro.OM[A]
  object ObservableMutable:
    object X:
      abstract class Abstract[A<:RAW] extends Observable.X.Abstract[A] with ObservableMutable[A]
      class Basic[A<:RAW](v: A) extends Mutable.X.Basic[A](v) with Val.Pro.Observable.X.AbstractTrait[A] with ObservableMutable[A]:
        override def update(v: A) = if(apply() != v) { super.update(v); fireChange }

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object X -> ###  \n\n Object [[X]] defines standard parent type extensions
@object X -> ###  \n\n Object [[X]] defines standard parent type extensions
@object X -> ###  \n\n Object [[X]] defines standard parent type extensions
*/