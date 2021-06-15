package scalqa; package `val`; package pro; package z; import language.implicitConversions

private[`val`] object Observable_View:

  def apply[A](p: Pro[A], v1: Gen.Observable, v2: Opt[Gen.Observable]): Observable[A] = p match
    case v: Pro.O[A] if v2 => new Z.Three(v, v, v1, v2.get)
    case v: Pro.O[A]       => new Z.Two(v, v, v1)
    case v if v2           => new Z.Two(v, v1, v2.get)
    case v                 => new Z.One(v, v1)


  private object Z:

    abstract class Base[A](val real: Pro[A]) extends pro.X.Base[A] with Observable[A]:
      def apply() = real()

    class One[A](p: Pro[A], d: Gen.Observable) extends Base[A](p) with Observable[A]:
      def onChange[U](l: () => U): Event.Control = Gen.Observable.onObservableChange(d)(l) //.^(ref += _.removeHardReference)

    class Two[A](p: Pro[A], d1: Gen.Observable, d2: Gen.Observable) extends Base[A](p) with Observable[A]:
      def onChange[U](l: () => U): Event.Control = Event.Control.join(Gen.Observable.onObservableChange(d1)(l), Gen.Observable.onObservableChange(d2)(l)) //.^(ref += _.removeHardReference)

    class Three[A](p: Pro[A], d1: Gen.Observable, d2: Gen.Observable, d3: Gen.Observable) extends Base[A](p) with Observable[A]:
      def onChange[U](l: () => U): Event.Control = Event.Control.join(Gen.Observable.onObservableChange(d1)(l), Gen.Observable.onObservableChange(d2)(l), Gen.Observable.onObservableChange(d3)(l)) //.^(ref += _.removeHardReference)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
