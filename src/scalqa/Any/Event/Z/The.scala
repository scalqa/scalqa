package scalqa; package Any; package Event; package Z

private[Event] object The {

  class _0(val id: Any, f: () => Any) extends (() => Any) with Event { def apply = f() }

  class _1[A](val id: Any, f: (A) => Any) extends (A => Any) with Event { def apply(a: A) = f(a) }

  class _2[A, B](val id: Any, f: (A, B) => Any) extends ((A, B) => Any) with Event { def apply(a: A, b: B) = f(a, b) }

  class _3[A, B, C](val id: Any, f: (A, B, C) => Any) extends ((A, B, C) => Any) with Event { def apply(a: A, b: B, c: C) = f(a, b, c) }

  class _4[A, B, C, D](val id: Any, f: (A, B, C, D) => Any) extends ((A, B, C, D) => Any) with Event { def apply(a: A, b: B, c: C, d: D) = f(a, b, c, d) }

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
