package scalqa; package Index; package Val; package Z

private abstract class TupledLike[A] private[Z] extends Val[A] {

  def v0: A

  def tag = v0.Class.tag

  def _minusRange(vl: Val[A], r: Int.Range): Val[A] = vl.all.dropAt(r).to(Pipe.To.IndexVal, tag)

  def _plusAt(i: Int, v: A, t: Tag[A]): Val[A] = if (i == size) this + v else all.~@(i, v).to(Pipe.To.IndexVal, t ? tag)

  def _plusAllAt(i: Int, all: ~[A], sz: Int, t: Tag[A]): Val[A] = all.~~@(i, all).to(Pipe.To.IndexVal, t ? tag)

  override def +(v: A)(implicit t: Tag[A] = \/): Val[A]

  override def all = new all(this)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/