package scalqa; package lang; package float; package g; import language.implicitConversions

 trait Pro[A<:Raw] extends Val.Pro[A] with any.z.PrimitiveTag.Float:
  def apply(): A

object Pro:

  trait  Mutable[A<:Raw] extends Pro[A] with Val.Pro.M[A] { def update(v: A): Unit }
  object Mutable:
    object X:
      class Basic[A<:Raw](v: A) extends Mutable[A]:
        private var value        : A     = v
        /**/    def apply()      : A     = value
        /**/    def update(v: A) : Unit  = value = v

  trait  Observable[A<:Raw] extends Pro[A] with Val.Pro.O[A]
  object Observable:
    object X:
      abstract class Abstract[A<:Raw] extends Val.Pro.Observable.X.Abstract[A] with Observable[A]

  trait  ObservableMutable[A<:Raw] extends Mutable[A] with Observable[A] with Val.Pro.OM[A]
  object ObservableMutable:
    object X:
      abstract class Abstract[A<:Raw] extends Observable.X.Abstract[A] with ObservableMutable[A]
      class Basic[A<:Raw](v: A) extends Mutable.X.Basic[A](v) with Val.Pro.Observable.X.Base[A] with ObservableMutable[A]:
        override def update(v: A) = if(apply() != v) { super.update(v); fireChange }

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait Pro -> ### Float Specialized Generic Provider/Property

        To be used with Float based opaque values.

@object X -> ### Type Extentions \n\n This object contains all provided base type implementations
@object X -> ### Type Extentions \n\n This object contains all provided base type implementations
@object X -> ### Type Extentions \n\n This object contains all provided base type implementations
*/