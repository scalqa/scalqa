package scalqa; package j; package util; package benchmark; package z; import language.implicitConversions

private[j] object runTrial:

  def apply[A](targets: ><[(String, () => A)], repeated: Int, slotCount: Int, slotLength: Time.Length)(using Opt[Numeric[A]]): ><[Result] =
    (0 <>> (slotCount / targets.size)).~
      .flatMap(_ => (0 <>> targets.size).~.map(i => runSingleTarget[A]((i % (targets.size/repeated)) + 1,targets(i)._1,targets(i)._2,slotLength)))
      .sortBy(_.number)
      .groupBy(_.number)
      .map(v => { val l=v.sortBy(_.opsPerSec).><; val fivePersent=l.size/20; l.dropFirst(fivePersent).dropLast(fivePersent).~}) // get rid of outliers
      .map(_.reduce(_ + _))
      .><

  private def runSingleTarget[A](nbr: Int, label: String, trgt: () => A, slotLength: Time.Length)(using mathOpt: Opt[Numeric[A]]): Result =
    val mem : ByteCount = J.Vm.Memory.used
    var cur : Long      = System.nanoTime
    val end : Long      = cur + slotLength.nanosTotal
    var len : Long      = 0
    var cnt : Int       = 0
    var sum : Double    = 0
    var last: Opt[A]    = \/

    while(cur < end)
      cnt += 1
      val s = System.nanoTime
      val v = trgt() // run test
      cur   = System.nanoTime
      len += cur - s
      mathOpt.forval(sum += _.toDouble(v))
      last  = v

    Result( nbr,
            label,
            cnt,
            len.Nanos,
            (J.Vm.Memory.used - mem).?.take(_ > 0) or \/,
            last.drop(_.isInstanceOf[Unit]),
            sum.?.drop(_ == 0.0))

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
