package scalqa; package j; package util; package test; package z; import language.implicitConversions

object streamsEqual:

  def result[A](s1: Stream[A], s2: Stream[A], ms: Stream[Stream[A]]): Result[true] =
    val firstPack = s1.pack
    val restPack  = ms.pack
    (Stream(s2) ++ restPack.stream)
      .zipIndex(2)
      .map(t => {
        var v: Result[true] = firstPack.stream.equalsSequenceResult(t._2)
        if(v.isProblem) v = new Problem((if(restPack.isEmpty) "Streams" else "1 and "+t._1+" streams") + " are not equal. " + v.problem.message)
        v
      })
      .take(_.isProblem)
      .readOpt or Result(true)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/