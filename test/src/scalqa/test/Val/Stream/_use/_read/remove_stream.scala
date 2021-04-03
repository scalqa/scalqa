package scalqa; package test.Val.Stream._use._read; import language.implicitConversions

object remove_stream extends J.Test("read_~"):

  test{
    val r = 1 to 1000
    val s = r.~
    assertEqual_~(r.drop(0)  .take(100),  s.read_~(100))
    assertEqual_~(r.drop(100).take(100),  s.read_~(100))
    assertEqual_~(r.drop(200).take(100),  s.read_~(100))
    assertEqual_~(r.drop(300).take(100),  s.read_~(100))
    assertEqual_~(r.drop(400).take(100),  s.read_~(100))
    assertEqual_~(r.drop(500).take(100),  s.read_~(100))
    assertEqual_~(r.drop(600).take(100),  s.read_~(100))
    assertEqual_~(r.drop(700).take(100),  s.read_~(100))
    assertEqual_~(r.drop(800).take(100),  s.read_~(100))
    assertEqual_~(r.drop(900).take(100),  s.read_~(100))
    assertEqual_~(r.drop(1000).take(100), s.read_~(100))
  }

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
