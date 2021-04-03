package sample.J.WeakRef;  import scalqa.{*, given};  import language.implicitConversions

import java.lang.ref.WeakReference

object Loose:

  class Foo:
    override def toString = "Foo"

  def main(sa:  Array[String]): Unit =

    var hard  = new Foo
    val weak  = J.WeakRef(hard)

    "------------------------ Hard and Weak Ref created".tp
    weak.tp

    J.Memory.gc
    "-------------------------------- Garbage Collected".tp

    weak.tp

    hard = null
    "-------------------------------Hard Reference Lost".tp

    J.Memory.gc
    "-------------------------------- Garbage Collected".tp

    weak.tp

