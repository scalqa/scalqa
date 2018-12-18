package scalqa; package Util; package Calendar; package Z

private[Calendar] object CurrentPro {
  private val proLookup = Lookup.M.make[Duration, The]

  def apply(changeEvery: Duration): Pro.O[Time] = proLookup.synchronized(proLookup(changeEvery, new The(changeEvery).I(p => {
    if (proLookup.isEmpty)
      App.runEvery(50.Millis, Time.now.real.I(ms => proLookup.synchronized(proLookup.all.to[Idx]).all.foreach(_.fireRefresh(ms)))).cancelIf(() => proLookup.isEmpty)
  })))

  // ************************************************************************************************
  private class The(val timeLength: Duration) extends scalqa.Pro.O.A.Basic[Time](Time.now) {
    var nextRun: Long = next(Time.now.real)
    var emptyRun = 0

    def fireRefresh(cur: Long) = if (cur >= nextRun) {
      nextRun = next(cur);
      val v = super.fireChange;
      if (v > 0) emptyRun = 0
      else { emptyRun += 1; if (emptyRun >= 3) proLookup.synchronized { proLookup.remove(timeLength) } }
    }

    private def next(c: Long) = { val m = timeLength.real; c - (c % m) + m }
  }

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
