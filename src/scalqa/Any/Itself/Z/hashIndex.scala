package scalqa; package Any; package Itself; package Z

private[Itself] object hashIndex {
  private var cnt = 0;
  private val Map = Lookup.M.make[Int, Int]

  def apply(v: Any): Int = Map(v.##, { cnt += 1; cnt })

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
