package scalqa; package test.`val`.stream._use._aggregate; import language.implicitConversions

object sum extends J.Test:

  testTrue{
    (1 to 100).sum == (1 <> 100).~.sum
  }

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
