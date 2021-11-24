package scalqa; package gen; package math; import language.implicitConversions

trait Sum[A]:
  def sumOpt(s: Stream[A]): Opt[A]
  def zero                : A
  def plus(x: A,y:A)      : A

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
