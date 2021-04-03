package sample.Fx.Chart;  import scalqa.{*, given};  import language.implicitConversions

object Lines extends Fx.Application(1000, 500, "Chart Test"):

  val Ints = Idx.OM[Int]().^(l =>{
    l ++= (0 <> 1)
    l.onChange(_.~.print)

    val s : Int.~ = 2 <> 1000
    J.scheduleEvery(1.Second, l += s.read).cancelIfTrue(isStopped)
  })

  object View extends Fx.Chart.XY.As.Lines(new Fx.Chart.Axis.As.Time(), new Fx.Chart.Axis.As.Ints("Int")):
    val Now = Gen.Time()
    data += new Line("Seconds", (0 <>> 100).~.map(i => (Now + i.Seconds, i)))
    data += new Line("Minutes", (0 <>> 100).~.map(i => (Now + i.Minutes, i)))
    data += new Line("Hours",   Ints.twoWay_^(i => new ItemBase(Now + i.Hours, i), (it: ItemBase) => it.y))
