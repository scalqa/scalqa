package example.fx.table;  import scalqa.{*, given};  import language.implicitConversions

object Fri13ThExplorer extends Fx.Application(400, 600, "Fri the 13th Explorer"):

  object View extends Fx.Pane.Split:                                        // Creating UI
    orientation = HORIZONTAL
    add(Centuries, 40.Percent)
    add(Days)

  object Centuries extends Fx.Table[Int]:                                   // Century Table Definition
    new Column[String]("Centuries", 100, _.toString + " Century")
    items ++= 1 <> 21                                                       // Centuries from 1st to 21st
    sortMode = \/                                                           // No sorting
    selection.mode = Fx.Selection.Mode.Multiple                             // Allow multi selection

  object Days extends Fx.Table[Day]:                                        // Days Table Definition
    new Column[Int](   "Year",  50, _.year.number)
    new Column[Int](   "Month", 70, _.month.number)
    new Column[String]("Day",   70, d => d.weekDay.tag + ", " + d.number)

    Centuries.selection.onChangeRun {                                       // On change, re-build days
      ordering = \/                                                         // order could be re-set by user
      items.replaceAll(
        Centuries.selection.~                                               // Stream of selected centuries
          .flatMap(c => (c - 1) * 100 <>> c * 100).map(_.Year)              // ~[Year]
          .flatMap(_.days).filter(_.number == 13).filter(_.weekDay.isFri)   // ~[Day]
      )
    }

