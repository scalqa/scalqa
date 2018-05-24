package scalqa; package J

package object Output {

  def get(s: java.io.OutputStream): Output = new Z.Bytes(s)

  def get(f: File): Output = get(new java.io.FileOutputStream(f.real))

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/