package scalqa; package fx; package scene; package chart; package axis; package x; package custom; package z; import language.implicitConversions

object calcTick:

  def stream(r: Range[Double]): ~[Double] =
    val size = r.end - r.start
    val unitCount = size / r.unit
    if (r.isSingularity) ~~(r.start)
    else if (r.unit <= 0) ~~(r.start, r.end)
    else {
      val l =  Idx.M[Double]()
      l += r.start
      if (unitCount > 2000)   System.err.println("Warning we tried to create " + unitCount + " major tick marks for Scale = " + r)
      else
        val v = if (r.unit.isWhole) Math.ceil(r.start) else r.start + r.unit
        (v <>> r.end).step_~(_ + r.unit).drop(l.~ contains _).foreach(l add _)
      l += r.end
      l
    }

  def minorStream(r: Range[Double], minorTickCount: Int): ~[Double] =
    import r.*
    if (unit <= 0) return \/
    val size = end - start
    val minorUnit = unit / (minorTickCount max 1)
    if (size / minorUnit > 10000) J.illegalState("Warning we tried to create more than 10000 minor tick marks: " + r)
    ~~.void[Double] ++ { if (!unit.isWhole) \/ else ((Math.floor(start) + minorUnit <>> Math.ceil(start)).step_~(_ + minorUnit).take(_ > start)) } ++
                    <>(unit.isWhole ? Math.ceil(start) or start, end, false).step_~(_ + unit).flatMap(u => <>(u + minorUnit, end min u + unit).step_~(_ + minorUnit))

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
