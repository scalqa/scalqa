package scalqa; package j; package util; package benchmark; package z; import language.implicitConversions

case class Setup(totalLength: Time.Length, slotCount: Int, slotLength: Time.Length) extends Able.Doc:
  def doc = Doc(this) += ("totalLength",totalLength) += ("slotCount",slotCount) += ("slotLength",slotLength)

object Setup:

  def apply[A](providedLengthOpt: Time.Length.Opt, targets: Pack[(String, () => A)], repeated: Int): Setup =
    val totalLength    : Time.Length = providedLengthOpt or 3.Seconds
    def maxTargetLength: Time.Length = targets.stream.map(t => {val nt = System.nanoTime; t._2(); (System.nanoTime - nt).Nanos}).max

    val slotLength     : Time.Length = (1 <> 3).stream.map(_ => maxTargetLength).min max 10.Millis
    var slotCount      : Int         = (totalLength.nanosTotal / slotLength.nanosTotal).toInt

    val min            : Int         = targets.size * repeated
    val perfect        : Int         = min * 5

    if     (slotCount >= perfect) Setup(totalLength, perfect,   totalLength / perfect)
    else if(slotCount >= min)     Setup(totalLength, slotCount, slotLength)
    else
      (4 <> 30).stream
        .drop(_ => providedLengthOpt.nonEmpty) // Do not recalculate if length is provided explicitly
        .map(_.Seconds)
        .zipValue(l => (l.nanosTotal / slotLength.nanosTotal).toInt)
        .take(_._2 > targets.size * repeated)
        .map(t => Setup(t._1, t._2, t._1 / t._2 / targets.size * repeated))
        .readOpt or J.illegalArgument("The targets take too much time to execute, cannot setup test with " + (providedLengthOpt.map("given duration:" +- _) or "reasonable duration"))

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
