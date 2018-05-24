package scalqa; package J; package Output; package Z

private[J] class Base[STREAM <: java.io.OutputStream](val real: STREAM) {

  def close { flush; real.close }

  def flush: this.type = { real.flush; this }

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
