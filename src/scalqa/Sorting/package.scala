package scalqa

package object Sorting {
  type Itself = Itself._Trait

  def get[A](implicit o: Sorting[A]): Sorting[A] = o

  def getBy[A, B](f: A => B)(implicit o: Sorting[B]): Sorting[A] = o.asMap(f)

  def get[A](v: java.util.Comparator[A]) : Sorting[A] = new Sorting[A] {    def position(x: A, y: A) = Sorting.Position.getByInt(v.compare(x, y))  }

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
