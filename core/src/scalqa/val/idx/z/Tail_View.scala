package scalqa; package `val`; package idx; package z; import language.implicitConversions

private[`val`] class Tail_View[A](idx: Idx[A], off: Int) extends Idx[A] :
  def apply(i: Int) : A      = idx(i + off)
  def size          : Int    = idx.size - off
  def tail          : Idx[A] = if(size<=1) VOID else new Tail_View[A](idx,off+1)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
