package scalqa; package J; package Format

trait _Trait[A] {

  def read(in: Input): A

  def write(a: A, out: Output)

}

object _Trait {

  def apply[A](sf: String.Format[A]): Format[A] = new Format[A] {
    def read(in: Input): A = sf.parse(in.asText.readAllAndClose);
    def write(a: A, out: Output) = out.asText.string(sf.apply(a))
  }

  def apply[A](f: Format[A]): String.Format[A] = new String.Format[A] {
    def parse(s: String): A = f.read(Input.get(s))
    def apply(a: A): String = Output.Buffer.get(1000).I(b => { f.write(a, b); b.flush }).toInput.asText.readAllAndClose
  }

  import scala.language.implicitConversions

  implicit def zzGet[A](sf: String.Format[A]): Format[A] = apply(sf)

  implicit def zzGet[A](f: Format[A]): String.Format[A] = apply(f)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
