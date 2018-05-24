package scalqa; package J; package Input; package Z; package Bytes

private[J] object readAll {

  def apply(in: Input.Bytes): Array[Byte] = {
    var a, buf = Array.get[Byte](1000);
    var len = 0;
    var i = in.read(buf);
    while (i != -1) {
      a.ensureCapacity(len + i, a = _, 100.Percent)
      buf.copyToArray(a, len, i.Range)
      len += i;
      i = in.read(buf);
    }
    a.copyResize(len)
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/