package scalqa; package Lookup; package W; package Z

trait LibraryBase[A, B, TRGT <: W[A, B]] extends Any with Lookup.Z.LibraryBase[A, B] with Able.Add[(A, B)] with Able.Remove[A] {
  protected override type TARGET = TRGT

  def getOrElsePut(key: A, b: ⇒ B): B = This.opt(key) or b.I(This.put(key, _))

  def getOrElsePutOpt(key: A, op: ⇒ Opt[B]): Opt[B] = This.opt(key) orOpt op.map(getOrElsePut(key, _))

  def put(p: ~[(A, B)]): Unit = p(_(This.put))

  protected def This: TRGT
  protected override def _target = This
  protected def _add(t: (A, B)) = This.put(t._1, t._2)
  protected def _remove(v: A) = This.remove(v)
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
