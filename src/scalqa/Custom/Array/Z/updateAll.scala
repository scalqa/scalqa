package scalqa; package Custom; package Array; package Z

private[Array] object updateAll {

  def at[A](a: Array[_ >: A], from: Int, flow: Stream.Flow[A], sizeOpt: Opt.Int = \/) = {
    var i = from
    flow.foreachSynchronized(v => {
      if (sizeOpt.let(_ <= i)) App.Fail("All values did not fit the size: " + sizeOpt.value)
      a(i) = v
      i += 1
    })
    if (sizeOpt.let(_ > i)) App.Fail("Low value count = " + i + " for size: " + sizeOpt.value)
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
