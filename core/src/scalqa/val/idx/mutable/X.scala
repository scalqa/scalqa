package scalqa; package `val`; package idx; package mutable; import language.implicitConversions

object X:

  abstract class Base[A] extends idx.X.Base[A] with Mutable[A]:
    override def add(v: A)                : Unit = addAt(size, v)
    override def addAll(stream: ~[A])     : Unit = addAllAt(size, stream)
    override def addAllAt(i: Int, p: ~[A]): Unit = p.zipIndex(i).foreach(v => addAt(v._1, v._2))

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object X -> ###  \n\n Object [[X]] defines standard parent type extensions
*/