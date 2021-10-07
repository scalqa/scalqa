package scalqa; package `val`; package pro; package z; import language.implicitConversions

private[`val`] object Observable_View:

  def apply[A](p: Pro[A], v1: Gen.Observable, v2: Opt[Gen.Observable]): Observable[A] = p match
    case v: Pro.O[A] if v2 => new Z.Three(v, v, v1, v2.get)
    case v: Pro.O[A]       => new Z.Two(v, v, v1)
    case v if v2           => new Z.Two(v, v1, v2.get)
    case v                 => new Z.One(v, v1)


  private object Z:

    abstract class Abstract[A](val real: Pro[A]) extends pro.X.Abstract[A] with Observable[A]:
      def apply() = real()

    class One[A](p: Pro[A], d: Gen.Observable) extends Abstract[A](p) with Observable[A]:
      def onChange[U](l: () => U): Event.Control = d.onObservableChange(l) //.^(ref += _.removeHardReference)

    class Two[A](p: Pro[A], d1: Gen.Observable, d2: Gen.Observable) extends Abstract[A](p) with Observable[A]:
      def onChange[U](l: () => U): Event.Control = Event.Control.join(d1.onObservableChange(l), d2.onObservableChange(l)) //.^(ref += _.removeHardReference)

    class Three[A](p: Pro[A], d1: Gen.Observable, d2: Gen.Observable, d3: Gen.Observable) extends Abstract[A](p) with Observable[A]:
      def onChange[U](l: () => U): Event.Control = Event.Control.join(d1.onObservableChange(l), d2.onObservableChange(l), d3.onObservableChange(l)) //.^(ref += _.removeHardReference)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
