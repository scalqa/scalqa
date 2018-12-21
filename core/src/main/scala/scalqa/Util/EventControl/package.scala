package scalqa; package Util

package object EventControl {
  private[scalqa] def This = this

  def id0(id: Any, f: () => Any): () => Any = new Z.A.Id0(id, f)

  def id1[A](id: Any, f: A => Any): A => Any = new Z.A.Id1(id, f)

  def id2[A, B](id: Any, f: (A, B) => Any): (A, B) => Any = new Z.A.Id2(id, f)

  def id3[A, B, C](id: Any, f: (A, B, C) => Any): (A, B, C) => Any = new Z.A.Id3(id, f)

  def id4[A, B, C, D](id: Any, f: (A, B, C, D) => Any): (A, B, C, D) => Any = new Z.A.Id4(id, f)

  // -------------------------------------------------------------------------------
  def cancelId0(id: Any): (() => Any) = new Z.Cancel(id)

  def cancelId1[A](id: Any): (A => Any) = new Z.Cancel(id)

  def cancelId2[A, B](id: Any): ((A, B) => Any) = new Z.Cancel(id)

  def cancelId3[A, B, C](id: Any): ((A, B, C) => Any) = new Z.Cancel(id)

  def cancelId4[A, B, C, D](id: Any): ((A, B, C, D) => Any) = new Z.Cancel(id)

  // -------------------------------------------------------------------------------
  def moveId0(in: Any, out: () => Any): () => Any = in.I.letType[WithId].map(v => if (v.isCancel) v.asInstanceOf[() => Any] else id0(v.id, out)) or out

  def moveId1[A](in: Any, out: A => Any): A => Any = in.I.letType[WithId].map(v => if (v.isCancel) v.asInstanceOf[A => Any] else id1(v.id, out)) or out

  def moveId2[A, B](in: Any, out: (A, B) => Any): ((A, B) => Any) = in.I.letType[WithId].map(v => if (v.isCancel) v.asInstanceOf[((A, B) => Any)] else id2(v.id, out)) or out

  def moveId3[A, B, C](in: Any, out: (A, B, C) => Any): ((A, B, C) => Any) = in.I.letType[WithId].map(v => if (v.isCancel) v.asInstanceOf[((A, B, C) => Any)] else id3(v.id, out)) or out

  def moveId4[A, B, C, D](in: Any, out: (A, B, C, D) => Any): ((A, B, C, D) => Any) = in.I.letType[WithId].map(v => if (v.isCancel) v.asInstanceOf[((A, B, C, D) => Any)] else id4(v.id, out)) or out

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
