package scalqa; package j; package util; package test; package z; import language.implicitConversions

object streamsEqual:

  def result[A](s1: ~[A], s2: ~[A], ms: ~[~[A]]): Result[true] =
    val firstList = s1.><
    val restList  = ms.><
    (~~(s2) ++ restList.~)
      .zipIndex(2)
      .map(t => {
        var v: Result[true] = firstList.~.equalsAll_??(t._2)
        if(v.isProblem) v = new Problem((if(restList.isEmpty) "Streams" else "1 and "+t._1+" streams") + " are not equal. " + v.problem.message)
        v
      })
      .take(_.isProblem)
      .read_? or Result(true)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/