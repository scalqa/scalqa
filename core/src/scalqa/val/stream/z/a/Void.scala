package scalqa; package `val`; package stream; package z; package a; import language.implicitConversions

class Void[A] private() extends ~[A] with Able.~[A] with Able.Size.Zero with Self.Void:
  @tn("stream")   def ~      : ~[A]   = this
  @tn("read_Opt") def read_? : Opt[A] = \/

object Void extends Void[Any]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
