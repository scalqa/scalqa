package scalqa; package `val`; package idx; package permutation; import language.implicitConversions

object Z:

  def random(r: Int.<>): Permutation =
    var a = r.toArray
    val ii = 0 <>> a.length
    ii.foreach(i => { val j = J.Random.int(ii); val v=a(i); a(i)=a(j); a(j)=v })
    Permutation(r, a.~.><)

  // --------------------------------------------------------------------------------------------------
  def sorting[A](l: Idx[A], fullRange: Boolean = false, o: Ordering[A]): Permutation =
    val ar = l.~.zipIndex.toArray
    ar.sort(using o.on(_._2))
    val r: Int.<> =
      if (fullRange) 0 <>> ar.length
      else ar.~.zipIndex.find_?(t => t._1 != t._2._1).map(t => t._1 <> (0 <>> ar.length).~.reverse.find_?(i => i != ar(i)._1).get) or \/
    if(r.isEmpty) \/  // No change
    else
      val a = new Array[Int](r.size)
      ar.~.take_<>(r).map(_._1 - r.start).foreachIndexed((i, v) => a(v) = i, r.start)
      Permutation(r, a.~.><)

  // --------------------------------------------------------------------------------------------------
  def pairs(lst: Idx[(Int, Int)]): Permutation = if (lst.size == 0) \/ else
    val r: Int.<> = lst.~.flatMap(t => Int.~(t._1,t._2)).range.raw
    Permutation(r, r.toArray.^(a => lst.~.foreach(t => a(t._1 - r.start) = t._2)).~.><)

  // --------------------------------------------------------------------------------------------------
  def validate(p: Permutation): Unit =
    val list = p.rangeMutated
    if (p.range.size != list.size)
      J.illegalState("sizes:" + p.range.size + "!=" + list.size)
    val a = new Array[Boolean](list.size)
    list.~.foreach(i => {
      if (a(i)) J.illegalArgument("List map is inconsistent " + list.~.zipIndex);
      a(i) = true
    })

  // ***************************************************************************************
  class Basic(val range: Int.<>, val rangeMutated: Int.><) extends Permutation:
    assert(range.size == rangeMutated.size)

  object Void extends Permutation with Gen.Void { def range = 0 <>> 0;  def rangeMutated: Int.>< = \/}

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
