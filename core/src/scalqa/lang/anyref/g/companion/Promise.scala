package scalqa; package lang; package anyref; package g; package companion; import language.implicitConversions

import concurrent.{ ExecutionContext as CONTEXT }

class Promise[A]:
  def apply[A](calc: => A)(using e: CONTEXT) : Val.Promise[A] = Val.Promise(calc)
  def ready[A](v: A | Val.Result.Problem)    : Val.Promise[A] = Val.Promise.ready(v)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
