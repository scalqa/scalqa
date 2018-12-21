package scalqa; package Fx; package Menu; package A

class List[A] private extends Menu {
  def this(name: String, initValues: ~[A], allNameOpt: Opt[String] = \/, format: A => String = (a: A) => a.toString) = {
    this();
    val vals = initValues.to[Idx]
    text = name + ": " + vals.size;
    enable = !vals.isEmpty
    items.add(new Item.A.Basic(new Fx.List[String]().I(l => {
      allNameOpt(l.items += _)
      l.items +~= vals.all.map(a => format(a))
      l.onMouseClicked(e => l.selection.positions.getOpt(0).let(_ => allNameOpt).map(_ - 1).apply(i => { if (i == -1) selectAllJob.all(_(vals.all)) else selectJob.all(_(vals(i))) }))
    })))
  }
  private var selectJob: Refs[A => Any] = \/
  private var selectAllJob: Refs[~[A] => Any] = \/

  def onSelect(f: A => Any) = selectJob += f

  def onSelectAll(f: ~[A] => Any) = selectAllJob = selectAllJob + f

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
