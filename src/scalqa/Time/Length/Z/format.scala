package scalqa; package Time; package Length; package Z

private[Time] object format {

  def apply(tl: Base, brief: Boolean): String = {
    val all = *(tl.totalDays, tl.subHours, tl.subMinutes).dropVoid.map(_.toString(brief))
    val secOpt = *(tl.subNanos, tl.subMicros, tl.subMillis)
      .dropWhile(_.isVoid).map(_.toPaddedString)
      .reverse
      .format()
      .Opt
      .map(s => tl.subSeconds.toString(brief).replace(" ", "." + s + " "))
      .orOpt(tl.subSeconds.Opt.map(_.toString(brief)))
    (all ~~ secOpt).format(", ")
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
