package scalqa; package test.`val`.stream._build._filter; import language.implicitConversions

object takeType extends J.Test:

  testEqualStream(
    1 <> 10,
    (Stream.void[Any] + "Abc" ++ ('a' <> 'z') ++ (1 <> 10) ++ (1L to 10L)).reverseEvery(3).takeType[Int].sort
  )

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
