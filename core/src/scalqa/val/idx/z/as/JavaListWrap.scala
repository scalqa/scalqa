package scalqa; package `val`; package idx; package z; package as; import language.implicitConversions

private[scalqa] class JavaListWrap[A](val real: java.util.List[A]) extends idx.X.Abstract[A]:
  def size          = real.size
  def apply(i: Int) = real.get(i)

private[scalqa] object JavaListWrap:

  class Mutable[A](val real: java.util.List[A]) extends Idx.Mutable.X.Abstract[A]:
    def size                     : Int  = real.size
    def apply(i: Int)            : A    = real.get(i)
    def addAt(i: Int, e: A)      : Unit = real.add(i, e)
    def updateAt(i: Int, e: A)   : Unit = real.set(i, e)
    def removeRange(r: Int.Range): Unit = r.stream.reverse.foreach(real.remove)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
