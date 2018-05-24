package scalqa; package Lookup; package The

class _Class[A, B] protected (protected val createOptFunOpt: Opt[A => Opt[B]] = \/, protected var real: Val[A, B] = \/) extends Proxy.Like[A, B] {
  def this(createOptFun: A => Opt[B]) = this(createOptFun.Opt)
  def this(p: ~[(A, B)]) = this(Opt.Void, Val.get(p))

  override def opt(key: A) = real.opt(key) orOpt this.synchronized { real.opt(key) orOpt createOptFunOpt.letMap(_(key).apply(real += (key, _))) }

  protected def put(p: ~[(A, B)]): Unit = this.synchronized { real +~= p }

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
