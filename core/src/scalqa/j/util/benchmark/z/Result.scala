package scalqa; package j; package util; package benchmark; package z; import language.implicitConversions

private[j] class Result(
    val number           : Int,
    val label            : String,
    val count            : Int,
    val time             : Time.Length,
    val totalMemory      : ByteCount,
    val lastOpt          : Opt[AnyRef],
    val sumOpt           : Double.Opt,
    var maxOpsPerSec     : Long  = 0,
    var maxMemoryAverage : ByteCount = 0.ByteCount
  ) extends Able.Doc:

  def +(that: Result): Result     = new Result(number, label, count + that.count, time + that.time, totalMemory + that.totalMemory, that.lastOpt, sumOpt.mix(that.sumOpt, _ + _))
  def opsPerSec      : Long       = time.??.map(count * 1_000_000_000L / _.nanosTotal) or 0L
  def memoryAverage  : ByteCount  = if (count == 0) \/ else totalMemory / count

  def doc =
    def percent(v: Long, t: Long) = if (t == 0) 0 else (v * 100D / t).toInt
    Doc(this)
      +=  ("Num", number)
      ++= (label != number.toString) ? ("Name", label)
      +=  ("Ops/Sec", if (time <= \/) "Too many" else opsPerSec.tagBrief)
      +=  ("%",        percent(opsPerSec, maxOpsPerSec))
      +=  ("Memory",   memoryAverage.tagBrief)
      +=  ("%",        percent(memoryAverage.toLong, maxMemoryAverage.toLong))
      ++= ( sumOpt.drop(_ => count == 0).map(v => ("Avg Value",(v / count).tag)) orOpt lastOpt.map(v => ("Last Value" , v.tag)))
/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
