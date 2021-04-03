package scalqa; package test.Val.Stream._use._process; import language.implicitConversions

object process extends J.Test:

  testTrue{
    var i = 0
    (0 <>> 9).~.process(v => i += 1, {i = -1})
    (0 <>> 0).~.process(v => i += 1, {i *= 10})
    i == 90
  }

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
