package scalqa; package Array; package Z

import scala.language.higherKinds

private[scalqa] class all[A](a: Array.Raw[_ >: A]) extends Pipe.The.ArrayBasic[A](a)

private[scalqa] object all {

  class Public[A](ja: Array.Raw[_ >: A]) extends Pipe.The.ArrayBasic[A](ja) {

    protected override def toTarget[TRGT[A]](b: Boolean)(implicit c: Pipe.To[TRGT], tag: Tag[A] = \/): TRGT[A] = if (!_isProjected && c == Pipe.To.Array) new Array[A](ja).cast else super.toTarget(b)

  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
