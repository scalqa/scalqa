package scalqa; package fx; package scene; package chart; package axis; package x; package custom; package z; import language.implicitConversions

object calcTick:

  def stream(r: Range[Double]): Stream[Double] =
    val size = r.end - r.start
    val unitCount = size / r.unit
    if (r.isSingularity) Stream(r.start)
    else if (r.unit <= 0) Stream(r.start, r.end)
    else {
      val l =  Idx.M[Double]()
      l += r.start
      if (unitCount > 2000)   System.err.println("Warning we tried to create " + unitCount + " major tick marks for Scale = " + r)
      else
        val v = if (r.unit.isWhole) Math.ceil(r.start) else r.start + r.unit
        (v <>> r.end).stepStream(_ + r.unit).drop(l.stream contains _).foreach(l add _)
      l += r.end
      l
    }

  def minorStream(r: Range[Double], minorTickCount: Int): Stream[Double] =
    import r.*
    if (unit <= 0) return VOID
    val size = end - start
    val minorUnit = unit / (minorTickCount max 1)
    if (size / minorUnit > 10000) J.illegalState("Warning we tried to create more than 10000 minor tick marks: " + r)
    Stream.void[Double] ++ { if (!unit.isWhole) VOID else ((Math.floor(start) + minorUnit <>> Math.ceil(start)).stepStream(_ + minorUnit).take(_ > start)) } ++
                    Val.Range(unit.isWhole ? Math.ceil(start) or start, end, false).stepStream(_ + unit).flatMap(u => Val.Range(u + minorUnit, end min u + unit).stepStream(_ + minorUnit))

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
