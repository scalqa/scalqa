package scalqa; package Array; package Z

import Able.Copy.ToArray

private[Array] object loadAt {

  def apply[A](a: Array[A], from: Int, flow: Pipe.Flow[A], sizeOpt: Opt[Int] = \/) = {
    flow match {
      case ca: ToArray[_] if (sizeOpt) => ca.cast[ToArray[A]].copyToArray(a, from, sizeOpt.value.Range)
      case ca: ToArray[_]              => ca.cast[ToArray[A]].copyToArray(a, from)
      case l => {
        var i = from
        l.synchronize.apply(v => {
          if (sizeOpt.let(_ <= i)) Fail("All values did not fit the size: " + sizeOpt.value)
          a(i) = v
          i += 1
        })
        if (sizeOpt.let(_ > i)) Fail("Low value count = " + i + " for size: " + sizeOpt.value)
      }
    }
    a
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/