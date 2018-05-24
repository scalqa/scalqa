package scalqa; package Index; package W; package Z

private[scalqa] trait LibraryBase[A, IndexW <: W[A]] extends Any with Index.Z.LibraryBase[A] with Coll.W.Z.LibraryBase[A, IndexW] with Able.Sort[A, IndexW] with Able.Add.At[A] with Able.Remove.At[IndexW] {
  protected override type TARGET = IndexW

  def asBiMap[B](m: BiMap[A, B]): W[B] = new Z.As.BiMapped[A, B](This, m)

  def asBiMap[B](m: A => B, u: B => A): W[B] = asBiMap(BiMap.get(m, u))

  def sort(implicit o: Sorting[A]) = { This.order(o); This }

  override def asSynchronized(lockOpt: Opt[AnyRef] = \/): W[A] = new Z.As.Synchronized(This, lockOpt)

  def update(i: Int, v: A) = This.replaceAt(i, v)

  def removeAt(i: Int): Unit = This.removeAt(i <>!)

  def replaceFor(filter: A => Boolean, value: A): Int = { var cnt = 0; This.all.applyIdx((i, v) => if (filter(v)) { cnt += 1; This.replaceAt(i, value) }); cnt }

  def replaceForOrElseAdd(filter: A => Boolean, value: A): Int = replaceFor(filter, value).I(c => if (c == 0) This.add(value))

  def removeFo1(filter: A => Boolean): Int = { var cnt = 0; This.size.all.reverse.apply(i => if (filter(This(i))) { cnt += 1; this =-@ i }); cnt }
  
  def removeFor(filter: A => Boolean): Int = { var cnt = 0; This.size.all.reverse.apply(i => if (filter(This(i))) { cnt += 1; this =-@ i }); cnt }

  // ---------------------------------------------------------------------
  protected def _addAt(i: Int, e: A) = { This.addAt(i, e); This }
  protected def _removeRange(i: Int.Range) = This.removeAt(i)
  protected def This: IndexW
  protected override def _target = This
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
