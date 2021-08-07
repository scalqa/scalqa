package scalqa; package `val`; package stream; package z; package _build; package _group; import language.implicitConversions

class group[A,U](x: ~[A], groupper: (A,A) => Boolean, peeker: (A,Boolean)=>U = \/) extends a.Pipe[~[A]](x):
  private val preview : Preview[A] = x.enablePreview
  private var value   : A          = _

  @tn("read_Opt") def read_? =
    var isFirst = true
    preview.readWhile_~(v => {
      var take = true
      if (isFirst.not) take=groupper(value,v)
      if (take) peeker(v,isFirst)
      isFirst = false
      value = v
      take
    }).?.drop(_.isEmpty)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
