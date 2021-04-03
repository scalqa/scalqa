package scalqa; package `val`; package opt; import language.implicitConversions;

import Info.Tag

abstract class _givens extends givenDefailts:
  self: Opt.type =>

  inline given xxUsingOpt[A[B],B](using v: A[B]) : Opt[A[B]] = v.cast[Opt[A[B]]]
  given xxCanEqual[A,B](using CanEqual[A,B]) : CanEqual[Opt[A], Opt[B]] = CanEqual.derived

  given xxTagClass[A](using t: ClassTag[A]): ClassTag[Opt[A]] = t.cast[ClassTag[Opt[A]]]
  given xxTagType [A]: Tag.Type[Opt[A]] = Tag.Type("Opt")
  given xxTagVoid[A]: Tag.Void[Opt[A]] with { inline def isVoid(v: Opt[A]) = v eq ZZ.None }

  given xxTagDoc[A](using t: Tag.Doc[A]) : Tag.Doc[Opt[A]] with
    def tag(v: Opt[A]) : String = if(v eq ZZ.None) "Opt(\\/)" else "Opt("+t.tag(v.cast[A])+")"
    def info(v: Opt[A]): Info   = Info("Opt@"+v.self_^.hash)

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