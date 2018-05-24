package scalqa; package Int; package Range; package Z

private[Range] object array {
  private lazy val Idx: Ints = Array.get[Int](200).I(_.load(200.all))

  def apply(r: Range): Array[Int] = Array.get[Int](r.size).I(a =>
    if (Idx.size.Range.contains(r)) Idx.copyToArray(a, 0, r)
    else a.load(r))

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
