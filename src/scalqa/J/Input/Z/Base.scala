package scalqa; package J; package Input; package Z

private[J] class Base(val real: java.io.InputStream) extends Variety {

  def input: J.Input = this.I.as(classOf[Input], _ => Input.get(real))

  def close: Unit = real.close

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
