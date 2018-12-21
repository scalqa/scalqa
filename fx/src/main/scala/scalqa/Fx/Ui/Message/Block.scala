package scalqa; package Fx; package Ui; package Message

class Block extends Ui.Block[Message] with Service {

  def publish(m: Message) = synchronized { entries.addAt(0, m) }

  protected lazy val table = new Fx.Table[Message] {

    new Column[String]("Message", 400, _.text) {
      onFormat(s => s.replaceAll("\n", " "))
      onStyleOpt(c => c.entryOpt.map(_.typ).letLookup {
        case Type.Error   => "red";
        case Type.Warning => "blue"
        case Type.Info    => if (c.entry.time.age < 30.Seconds) "white" else "grey"
      }.map("-real-text-fill:" + _: Style))
      refreshEvery(5.Seconds)
      alignment = LEFT
      onTooltip(v => v)
    }

    new Column[String]("Context", 80, _.context) {
      style = "-real-text-fill:grey"
    }

    new Column[Boolean] {
      onGetPro(_.acknowledgedPro)
      prefWidth = 35
      graphic = Button.make("Ok", entries.all.countFew(_.acknowledged, !_.acknowledged).I(l =>
        if (l(1) == 0) entries.clear
        else if (l(0) == 0) entries.all(_.acknowledged = true)
        else entries.removeFor(_.acknowledged)))
      graphic = Button.make("Ok", entries.all.countFew(_.acknowledged, !_.acknowledged).toTuple2((ok, not) =>
        if (not == 0) entries.clear
        else if (ok == 0) entries.all(_.acknowledged = true)
        else entries.removeFor(_.acknowledged)))
      setupEdit(new CheckBox, _.acknowledged = _)
    }

    new Column[Time] {
      Context.TimeConfig(this)
      style = "-real-text-fill:grey"
      prefWidth = 60
      onGet(_.time)
      refreshEvery(5.Seconds)
    }

    columns.all(_.sortable = true)
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
