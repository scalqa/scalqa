package scalqa; package `val`; package stream; package z; package x; import language.implicitConversions

class Void[A] extends Stream[A] with Able.Stream[A] with Able.Size.Zero with Gen.Void:
  def stream  : Stream[A] = this
  def readOpt : Opt[A]    = \/

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
