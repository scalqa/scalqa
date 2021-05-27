package scalqa; package test.`val`.stream._build._extend; import language.implicitConversions

object default extends J.Test:

  test{
    assertTrue((1 <> 3).~.drop(_ => true).default(333).sum == 333)
    assertTrue((1 <> 3).~.default(333).sum == 6)
  }

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
