package scalqa; package Custom; package Ordering; package Z

private[Ordering] object VoidPosition {

  class FirstView[A](val real: math.Ordering[A]) extends Ordering[A] {

    def compare(x: A, y: A): Int =
      if (x.isVoid) { if (y.isVoid) 0 else 1 }
      else if (y.isVoid) -1
      else real.compare(x, y)
  }

  // ********************************************************************************
  class LastView[A](val real: math.Ordering[A]) extends Ordering[A] {

    def compare(x: A, y: A): Int =
      if (x.isVoid) { if (y.isVoid) 0 else -1 }
      else if (y.isVoid) 1
      else real.compare(x, y)
  }
}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @object Void ->
 *
 *  [[A.Void]] can be applied to anything, but comparing two elements will always return [[Position.Either]]
 *
 *
 */
