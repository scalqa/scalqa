package scalqa; package `val`; package opt; import language.implicitConversions;

abstract class _givens extends givenDefailts:
  self: Opt.type =>

  inline given givenUsingOpt[A[B],B](using v: A[B]) : Opt[A[B]]                = v.cast[Opt[A[B]]]
  given givenCanEqualOpt[A,B](using CanEqual[A,B])  : CanEqual[Opt[A], Opt[B]] = CanEqual.derived
  given givenClassTag[A]  (using t: ClassTag[A])    : ClassTag[Opt[A]]         = t.cast[ClassTag[Opt[A]]]
  given givenNameTag [A]                            : Self.NameTag[Opt[A]]         = Self.NameTag("Opt")
  given givenVoidTag [A]                            : Self.VoidTag[Opt[A]]         with { inline def isVoid(v: Opt[A]) = v eq ZZ.None }

  given givenDocTag[A](using t: Self.DocTag[A]) : Self.DocTag[Opt[A]] with
    def tag(v: Opt[A]): String   = if(v eq ZZ.None) "Opt(\\/)" else "Opt("+t.tag(v.cast[A])+")"
    def doc(v: Opt[A]): Self.Doc = Self.Doc("Opt@"+v.self_^.hash)

// ******************************************************
class givenDefailts:
  inline given givenUsingOptNone[A[B],B] : Val.Opt[A[B]] = \/

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**

*/