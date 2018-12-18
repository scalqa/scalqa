package scalqa; package App; package Event; package Z

private[Event] object A {

  class Id0(val id: Any, f: () => Any) extends (() => Any) with WithId { def apply = f() }

  class Id1[A](val id: Any, f: (A) => Any) extends (A => Any) with WithId { def apply(a: A) = f(a) }

  class Id2[A, B](val id: Any, f: (A, B) => Any) extends ((A, B) => Any) with WithId { def apply(a: A, b: B) = f(a, b) }

  class Id3[A, B, C](val id: Any, f: (A, B, C) => Any) extends ((A, B, C) => Any) with WithId { def apply(a: A, b: B, c: C) = f(a, b, c) }

  class Id4[A, B, C, D](val id: Any, f: (A, B, C, D) => Any) extends ((A, B, C, D) => Any) with WithId { def apply(a: A, b: B, c: C, d: D) = f(a, b, c, d) }

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
