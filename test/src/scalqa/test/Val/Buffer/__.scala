package scalqa; package test.Val.Buffer; import language.implicitConversions

object Main extends J.Test:

  test_~(
    Buffer[Int]().^(_ ++= 1 <> 50),
    1 <> 50
  )

  include(
    add)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/