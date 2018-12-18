package scalqa; package Lookup

trait _library[A, B] extends Any with Any.Wrap[Lookup[A, B]] with Stream.Mapping[A, B] {

  def apply(v: A): B = real.getOpt(v).value

  def allKeys: ~[A] = real.allPairs.map(_._1)

  def asMappedView[C](f: B => C): Lookup[A, C] = new Z.A.MappedView(real, f)

  def asScalaMapView: collection.Map[A, B] = new Z.A.ScalaMapView(real)

  def asPartialFunctionView: PartialFunction[A, B] = new PartialFunction[A, B] { def isDefinedAt(a: A) = real.getOpt(a); def apply(a: A): B = real.getOpt(a).value }

}

object _library {

  class _Class[A, B] private[Lookup] (protected val real: Lookup[A, B]) extends AnyVal with _library[A, B]
}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def apply(v -> Element by key
 *
 *    Returns element associated with the given `key`
 *
 *    Fails, if none is found
 *
 */
