package scalqa; package `val`; package opt; import language.implicitConversions;

abstract class _givens extends givenDefailts:
  self: Opt.type =>

  inline given givenUsingOpt[A[B],B](using v: A[B]) : Opt[A[B]]                = v.cast[Opt[A[B]]]
  given givenCanEqualOpt[A,B](using CanEqual[A,B])  : CanEqual[Opt[A], Opt[B]] = CanEqual.derived
  given givenClassTag[A]  (using t: ClassTag[A])    : ClassTag[Opt[A]]         = t.cast[ClassTag[Opt[A]]]
  given givenTypeDef [A]                            : Given.TypeDef[Opt[A]]    = Given.TypeDef("Opt")
  given givenVoidDef [A]                            : Given.VoidDef[Opt[A]]    with { inline def value_isVoid(v: Opt[A]) = v eq ZZ.None }

  given givenDocDef[A](using t: Given.DocDef[A]) : Given.DocDef[Opt[A]] with
    def value_tag(v: Opt[A]): String   = if(v eq ZZ.None) "Opt(\\/)" else "Opt("+t.value_tag(v.cast[A])+")"
    def value_doc(v: Opt[A]): Doc      = Doc("Opt@"+v.self_^.hash)

// ******************************************************
class givenDefailts:
  inline given givenUsingOptNone[A[B],B]      : Val.Opt[A[B]]    = \/
  inline given givenOrdering[T<:Comparable[T]]: Opt[Ordering[T]] = gen.math.ordering.Z.OrderingForComparable.cast[Ordering[T]]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**

*/