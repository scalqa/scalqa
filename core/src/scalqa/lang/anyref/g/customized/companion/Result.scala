package scalqa; package lang; package anyref; package g; package customized; package companion; import language.implicitConversions

class Result[A]:
  def apply(v: A | Val.Result.Problem) : Val.Result[A] = Val.Result[A](v)
  def fail(message: String)            : Val.Result[A] = Val.Result.fail(message)

object Result extends Result[AnyRef]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/

