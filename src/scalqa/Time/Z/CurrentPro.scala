package scalqa; package Time; package Z

private[Time] object CurrentPro {
  private val proLookup = Lookup.W.get[Time.Length, The]

  def apply(changeEvery: Time.Length): Pro.O[Time] = proLookup.synchronized(proLookup.getOrElsePut(changeEvery, new The(changeEvery).I(p => {
    if (proLookup.isEmpty)
      Schedule.every(50.Millis, Time.get.totalMillis.I(ms => proLookup.synchronized(proLookup.all.as[Index]).all(_.fireRefresh(ms)))).cancelIf(() => proLookup.isEmpty)
  })))

  // ************************************************************************************************
  private class The(val timeLength: Time.Length) extends scalqa.Pro.O.The[Time](Time.get) {
    var nextRun: Long = next(Time.get.totalMillis)
    var emptyRun = 0

    def fireRefresh(cur: Long) = if (cur >= nextRun) {
      nextRun = next(cur);
      super.fireObservableChangeEvent.I.to(v => if (v > 0) emptyRun = 0 else { emptyRun += 1; if (emptyRun >= 3) proLookup.synchronized { proLookup.remove(timeLength) } })
    }

    private def next(c: Long) = c - (c % timeLength.totalMillis) + timeLength.totalMillis
  }

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
