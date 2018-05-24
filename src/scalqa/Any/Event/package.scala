package scalqa; package Any

package object Event {

  def get0(key: Any, f: () => Any): () => Any = new Z.The._0(key, f)

  def get1[A](key: Any, f: A => Any): A => Any = new Z.The._1(key, f)

  def get2[A, B](key: Any, f: (A, B) => Any): (A, B) => Any = new Z.The._2(key, f)

  def get3[A, B, C](key: Any, f: (A, B, C) => Any): (A, B, C) => Any = new Z.The._3(key, f)

  def get4[A, B, C, D](key: Any, f: (A, B, C, D) => Any): (A, B, C, D) => Any = new Z.The._4(key, f)

  // -------------------------------------------------------------------------------
  def getCancel0(key: Any): (() => Any) = new Z.Cancel(key)

  def getCancel1[A](key: Any): (A => Any) = new Z.Cancel(key)

  def getCancel2[A, B](key: Any): ((A, B) => Any) = new Z.Cancel(key)

  def getCancel3[A, B, C](key: Any): ((A, B, C) => Any) = new Z.Cancel(key)

  def getCancel4[A, B, C, D](key: Any): ((A, B, C, D) => Any) = new Z.Cancel(key)

  // -------------------------------------------------------------------------------
  def moveId0(in: Any, out: () => Any): () => Any = in.I.letAs(classOf[Event]).map(v => if (v.isCancel) v.cast else get0(v.id, out)) or out

  def moveId1[A](in: Any, out: (A) => Any): A => Any = in.I.letAs(classOf[Event]).map(v => if (v.isCancel) v.cast else get1(v.id, out)) or out

  def moveId2[A, B](in: Any, out: (A, B) => Any): ((A, B) => Any) = in.I.letAs(classOf[Event]).map(v => if (v.isCancel) v.cast else get2(v.id, out)) or out

  def moveId3[A, B, C](in: Any, out: (A, B, C) => Any): ((A, B, C) => Any) = in.I.letAs(classOf[Event]).map(v => if (v.isCancel) v.cast else get3(v.id, out)) or out

  def moveId4[A, B, C, D](in: Any, out: (A, B, C, D) => Any): ((A, B, C, D) => Any) = in.I.letAs(classOf[Event]).map(v => if (v.isCancel) v.cast else get4(v.id, out)) or out

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
