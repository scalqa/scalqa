package scalqa; package gen; package time; package z; import language.implicitConversions

private class CurrentProperty(length: Time.Length) extends Long.Pro.O.X.Base:
  override def doc     : Doc      = Doc("Time.current_*@" + this.##) += ("length", length)
  private  val nanos   : Long     = length.nanosTotal
  private  var nextRun : Long     = { val t = System.nanoTime; t - (t % nanos) + nanos }
  private  var emptyRun: Int      = 0
  private  var value   : Long     = System.currentTimeMillis
  /**/     def apply() : Long     = value
  /**/     def update(t: Long, cur: Long) = if (cur >= nextRun) {
    nextRun += nanos
    value = t
    val v = super.fireChange
    if (v > 0) emptyRun = 0
    else { emptyRun += 1; if (emptyRun >= 3) CurrentProperty.theMap.remove(length) }
  }

private[gen] object CurrentProperty:
  private val theMap = Lookup.M.concurrent[Time.Length,CurrentProperty]()

  private def runJobs =
    val nt  = System.nanoTime
    val tm  = System.currentTimeMillis
    theMap.~.load.foreach(_.update(tm,nt))

  def apply(changeEvery: Time.Length): Time.Pro.O = {
    theMap.get_?(changeEvery) or {
      val p = new CurrentProperty(changeEvery)
      theMap.put(changeEvery,p)
      if (theMap.size == 1) J.scheduleEvery(50.Millis, runJobs).cancelIfTrue(theMap.isEmpty)
      p
    }
  }.cast[Time.Pro.O]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
