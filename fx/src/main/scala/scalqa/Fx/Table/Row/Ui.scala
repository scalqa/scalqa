package scalqa; package Fx; package Table; package Row

class Ui[ENTRY, VIEW](protected val cellFilter: Cell[ENTRY, VIEW] => Boolean) extends Fx.Cell.Ui[Cell[ENTRY, VIEW]] {
  private[Row] var refreshList: Refs[ENTRY => Opt[Any.O]] = \/

  def refreshOnOpt(dep: ENTRY => Opt[Any.O]*): Unit = refreshList +~= dep

  def refreshOn(dep: ENTRY => Any.O*): Unit = refreshOnOpt(dep.all.map[ENTRY => Opt[Any.O]](f => f(_).I.Opt).to[Seq]: _*)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
