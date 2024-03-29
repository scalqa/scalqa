package scalqa; package test.`val`.stream._use._aggregate; import language.implicitConversions

object sumFew extends J.Test:

  def all = (1 <> 100).stream

  testEqualStream(
    Stream(all.map(_ * 10).sum, all.map(_ % 10).sum, all.sum),
    {val (x,y,z) = all.sumFew(_ * 10, _ % 10, v => v); Stream(x,y,z) })

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
