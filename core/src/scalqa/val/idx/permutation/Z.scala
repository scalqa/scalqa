package scalqa; package `val`; package idx; package permutation; import language.implicitConversions

object Z:

  def random(r: Int.Range): Permutation =
    var a = r.toArray
    val ii = 0 <>> a.length
    ii.foreach(i => { val j = J.Random.int(ii); val v=a(i); a(i)=a(j); a(j)=v })
    Permutation(r, a.stream.pack)

  // --------------------------------------------------------------------------------------------------
  def sorting[A](l: Idx[A], fullRange: Boolean = false, o: Ordering[A]): Permutation =
    val ar = l.stream.zipIndex.toArray
    ar.sort(using o.on(_._2))
    val r: Int.Range =
      if (fullRange) 0 <>> ar.length
      else ar.stream.zipIndex.findOpt(t => t._1 != t._2._1).map(t => t._1 <> (0 <>> ar.length).stream.reverse.findOpt(i => i != ar(i)._1).get) or VOID
    if(r.isEmpty) VOID // No change
    else
      val a = new Array[Int](r.size)
      ar.stream.takeRange(r).map(_._1 - r.start).foreachIndexed((i, v) => a(v) = i, r.start)
      Permutation(r, a.stream.pack)

  // --------------------------------------------------------------------------------------------------
  def pairs(lst: Idx[(Int, Int)]): Permutation = if (lst.size == 0) VOID else
    val r: Int.Range = lst.stream.flatMap(t => Int.Stream(t._1,t._2)).range.raw
    Permutation(r, r.toArray.self(a => lst.stream.foreach(t => a(t._1 - r.start) = t._2)).stream.pack)

  // --------------------------------------------------------------------------------------------------
  def validate(p: Permutation): Unit =
    val list = p.positions
    if (p.range.size != list.size)
      J.illegalState("sizes:" + p.range.size + "!=" + list.size)
    val a = new Array[Boolean](list.size)
    list.stream.foreach(i => {
      if (a(i)) J.illegalArgument("List map is inconsistent " + list.stream.zipIndex);
      a(i) = true
    })

  // ***************************************************************************************
  class Basic(val range : Int.Range, val positions: Int.Pack) extends Permutation:
    assert(range.size == positions.size)

  object Void extends Permutation with Gen.Void:
    def range               = 0 <>> 0;
    def positions: Int.Pack=VOID

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
