package scalqa; package Custom; package Array; package Z

private[scalqa] object contains {

  def apply[@specialized(DATA) A](a: Array[A], v: A): Boolean = {
    val sz = a.length
    var i = 0;
    while (i < sz) {
      if (a(i) == v) return true
      i += 1
    }
    false
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
