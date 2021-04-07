package scalqa; package `val`; package opt; import language.implicitConversions;

abstract class _givens extends givenDefailts:
  self: Opt.type =>

  inline given xxUsingOpt[A[B],B](using v: A[B]) : Opt[A[B]]                = v.cast[Opt[A[B]]]
  given xxCanEqual[A,B](using CanEqual[A,B])     : CanEqual[Opt[A], Opt[B]] = CanEqual.derived
  given xxClassTag[A]  (using t: ClassTag[A])    : ClassTag[Opt[A]]         = t.cast[ClassTag[Opt[A]]]
  given xxDefName [A]                            : Def.Name[Opt[A]]         = Def.Name("Opt")
  given xxDefVoid [A]                            : Def.Void[Opt[A]]         with { inline def isVoid(v: Opt[A]) = v eq ZZ.None }

  given xxDefDoc[A](using t: Def.Doc[A]) : Def.Doc[Opt[A]] with
    def tag(v: Opt[A]): String = if(v eq ZZ.None) "Opt(\\/)" else "Opt("+t.tag(v.cast[A])+")"
    def doc(v: Opt[A]): Doc   = Doc("Opt@"+v.self_^.hash)

// ******************************************************
class givenDefailts:
  inline given xxUsingOptNone[A[B],B] : Val.Opt[A[B]] = \/

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**

*/