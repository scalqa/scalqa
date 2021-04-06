package scalqa; package lang; package any; package ref; package custom; package framework; package companion; import language.implicitConversions

class Idx[A]:
  def apply(v: A)                        : Val.Idx[A] = Val.Idx(v)
  def apply(v1: A, v2: A)                : Val.Idx[A] = Val.Idx(v1, v2)
  def apply(v1: A, v2: A, v3: A, vs: A*) : Val.Idx[A] = Val.Idx(v1, v2, v3, vs *)

  type   Mutable = Val.Idx.M[A]
  object Mutable:
    def apply(initSize: Int = J.initSize) : M  = Val.Idx.M(initSize)

  type   Observable = Val.Idx.O[A]
  object Observable

  type   ObservableMutable = Val.Idx.OM[A]
  object ObservableMutable:
    def apply(initSize: Int = J.initSize) : OM = Val.Idx.OM(initSize)

  type M  = Mutable;           inline def M  = Mutable
  type O  = Observable;        inline def O  = Observable
  type OM = ObservableMutable; inline def OM = ObservableMutable

private[scalqa] object Idx extends Idx[AnyRef]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
