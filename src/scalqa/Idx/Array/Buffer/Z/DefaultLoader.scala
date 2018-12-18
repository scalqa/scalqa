package scalqa; package Idx.Array; package Buffer; package Z

private[Buffer] object DefaultLoader {

  def apply[@specialized(DATA) A](real: Buffer[A]): Loader[A] = new Loader[A] {

    @inline def add(v: A) = real.add(v)

    @inline def _array = real._array

    @inline def _arrayResize(s: Int) = real._arrayResize(s)

    @inline def _size = real._size

    @inline def _size_=(v: Int) = real._size = v
  }
}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
