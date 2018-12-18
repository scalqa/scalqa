package scalqa; package App; package Z; package Benchmark

import Util.ByteSize

private[Z] class Result(
    val id: Int,
    val label: String,
    val count: Long,
    var memory: ByteSize,
    val valueSum: Long,
    var maxCount: Long = \/,
    var maxMemory: ByteSize = \/) extends Any.Able.ToInfo {

  def +(that: Result) = {
    def sum(m1: ByteSize, m2: ByteSize): ByteSize =
      if (m1 < 0) if (m2 < 0) \/ else m2 * 2
      else if (m2 < 0) m1 * 2
      else m1 + m2

    new Result(
      id,
      label,
      this.count + that.count,
      sum(this.memory, that.memory) / 2,
      this.valueSum + that.valueSum,
      this.maxCount + that.maxCount,
      sum(this.maxMemory, that.maxMemory) / 2)
  }

  def toInfo = new Pro.Info(this) +=
    ("Num", id + 1) +=
    ("Name", label) +=
    ("Run Count", count.toBrief) +=
    ("%", count %@ maxCount toInt) +=
    ("Memory", memory.toBrief) +=
    ("%", memory %@ maxMemory toInt) +=
    ("Control Value Avg", if (count == 0) 0 else valueSum / count)
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
