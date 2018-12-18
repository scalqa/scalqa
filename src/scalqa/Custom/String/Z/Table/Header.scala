package scalqa; package Custom; package String; package Z; package Table

private[Table] class Header(t: Table) extends Row(t, -1) {
  private[Table] override def cf(i: Int) = new Column(i)

  // *******************************************************************
  class Column(index: Int, var width: Int = 1) extends Cell(this, index, "?")

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/