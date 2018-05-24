package scalqa; package Index; package Val; package Z

import scala.language.higherKinds

private[scalqa] class all[A](ival: Val[A]) extends Pipe.The.IndexBasic[A](ival) with Able.Copy.ToArray[A] {

  override def isMutable = false

  protected override def _copyToArray(a: Array[A], p: Int, r: Int.Range) = ival match {
    case al: ArrayBased[A] => al.copyToArray(a, p, r)
    case _                 => super._copyToArray(a, p, r)
  }

  protected override def toTarget[TRGT[A]](isTo: Boolean)(implicit c: Pipe.To[TRGT], t: Tag[A] = \/): TRGT[A] =
    if (c == Pipe.To.IndexVal && !_isProjected) ival.cast else if (isTo) super.to(c, t) else super.as(c, t)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
