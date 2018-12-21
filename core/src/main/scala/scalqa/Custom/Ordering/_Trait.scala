package scalqa; package Custom; package Ordering

trait _Trait[@specialized(DATA) A] extends math.Ordering[A] {

  def compare(x: A, y: A): Int

  def map[B](f: B => A): Ordering[B] = new Ordering[B] {
    def compare(x: B, y: B) = _Trait.this.compare(f(x), f(y))
  }

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
