package scalqa; package `val`; package pro; import language.implicitConversions

object X:

  abstract class Base[A] extends Basis[A]

  // ***************************************************
  trait Basis[A] extends Pro[A] with Able.Doc:
    def doc = Doc(this) ++= this.?.takeType[Able.Name].map(n => ("name", n.name)) += ("value", apply())

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object X -> ### Type Extention
*/