package scalqa; package `val`; package pro; package observableMutable

object X:

  class Base[A] extends pro.X.Base[A] with observable.X.Basis[A] with ObservableMutable[A]:
    private var value: A = _

    def apply()      : A    = value
    def update(v: A) : Unit = if (value != v) { value = v; fireChange }

  // ************************************************************************************************************
  trait Basis[A] extends observable.X.Basis[A] with ObservableMutable[A]:
      private var value: A = _
      def apply()      = value
      def update(v: A) = if (value != v){ value = v; fireChange }

  // ************************************************************************************************************
  class Basic[A] private() extends Base[A]:
    def this(v: A) = { this(); super.update(v) }

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object X -> ###  \n\n Object [[X]] defines standard parent type extensions
*/