package scalqa; package `val`; package pro; import language.implicitConversions

object X:

  abstract class Abstract[A] extends AbstractTrait[A]

  // ***************************************************
  trait AbstractTrait[A] extends Pro[A] with Able.Info:
    def info = Info(this) ++= this.?.takeType[Able.Name].map(n => ("name", n.name)).~ += ("value", apply())

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object X -> ###  \n\n Object [[X]] defines standard parent type extensions
*/