package scalqa; package Idx.Array; package Buffer; package Z

private[Buffer] object RangeLoader {

  def apply[@specialized(DATA) A](real: Buffer[A], r: Idx.Range): Loader[A] = new Loader[A] {

    var _size = r.start
    override val loadLimit = r.end

    @inline final def add(v: A) = {
      val c = _size
      if (c > loadLimit) failLimit
      real.update(c, v);
      _size += 1
    }

    @inline final def _array = real._array

    @inline final def _arrayResize(s: Int) = App.Fail()
  }
}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
