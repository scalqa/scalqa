package scalqa; package lang; package anyref; package g; package customized; package companion; import language.implicitConversions

class Stream[A]:
  def apply                              : ~[A] = \/
  def apply(v: A)                        : ~[A] = ~~(v)
  def apply(v1: A, v2: A)                : ~[A] = ~~(v1, v2)
  def apply(v1: A, v2: A, v3: A, vs: A*) : ~[A] = ~~(v1, v2, v3, vs *)

object Stream extends Stream[AnyRef]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
