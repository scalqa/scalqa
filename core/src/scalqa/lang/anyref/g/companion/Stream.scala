package scalqa; package lang; package anyref; package g; package companion; import language.implicitConversions

class Stream[A]:
  def apply                              : Val.Stream[A] = \/
  def apply(v: A)                        : Val.Stream[A] = Val.Stream(v)
  def apply(v1: A, v2: A)                : Val.Stream[A] = Val.Stream(v1, v2)
  def apply(v1: A, v2: A, v3: A, vs: A*) : Val.Stream[A] = Val.Stream(v1, v2, v3, vs *)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
