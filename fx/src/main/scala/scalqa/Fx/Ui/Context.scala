package scalqa; package Fx; package Ui

trait Context extends Paint.Color.Z.Named {

  def PositiveNegative = Style.Pseudo.Group.PositiveNegative
  def SmallMediumLarge = Style.Pseudo.Group.SmallMediumLarge

  lazy val dm_time: Style.Class = "dm-time"

  lazy val TimeConfig = Table.Column.Config.make[Time](c => {
    c.labelPro.updateIfVoid("Time");
    c.prefWidth = 120;
    c.styleClass = dm_time;
    c.onFormat(_ match {
      case t if (t.isVoid)        => ""
      case t if (t.day.isCurrent) => { val ct = Time.now; val s = (t durationTo ct).round(5.Seconds, DOWN).toBrief; if (ct < t) "in " + s else s }
      case t                      => t.round(1.Second, DOWN).toString
    })
    c.onGetOptProEnhance((_, p) => if (p().map(_.day.isCurrent).or(true)) p.asMappedView(v => v, Time.currentPro(1.Second).I.~) else p)
  })
}

object Context extends Context
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
