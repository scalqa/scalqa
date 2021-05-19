package scalqa; package fx; package control; package table; package z; package idxProxy; import language.implicitConversions

private[fx] class Entry[A](var index: Int, val value: A) extends Able.Doc:

  override def equals(a: Any): Boolean  = a match{ case v: Entry[_] => v.index == index && v.value == value; case _ => false }
  /**/     def doc           : Self.Doc = Self.Doc(this) += ("index", index) += ("value", value)

private[scalqa] object Entry:

  def indexSorting[A]: Ordering[Entry[A]] = zIndexOrdering.cast[Ordering[Entry[A]]]; private val zIndexOrdering = Int.ordering.on[Entry[Any]](_.index)

  trait IndexBase[A] extends Idx.M.X.Abstract[A]:
    /**/                def target                 : Idx.M[A]
    /**/                def entries                : Idx.M[Entry[A]]
    /**/                def apply(i: Int)          : A                = entries(i).value
    /**/                def size                   : Int              = entries.size
    /**/                def addAt(i: Int, a: A)    : Unit             = target.synchronized(target.add(a))
    /**/                def updateAt(i: Int, e: A) : Unit             = target.synchronized(target.update(entries(i).index, e))
    @tn("remove_Range") def remove_<>(r: Int.<>)   : Unit             = target.synchronized(entries.~.take_<>(r).map(_.index).sort.reverse.foreach(target removeAt _))

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
