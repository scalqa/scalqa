package scalqa; package Lookup; package Z; package A

private[scalqa] class Basic[A, B] protected (protected val createOptFunOpt: Opt[A => Opt[B]] = \/, protected var real: I.Value[A, B] = \/) extends Custom.Proxy.Lookup.Like[A, B] {
  def this(createOptFun: A => Opt[B]) = this(createOptFun.Opt)
  def this(s: ~[(A, B)]) = this(Opt.Void, I.Value.make(s))

  override def getOpt(key: A) = real.getOpt(key) orOpt this.synchronized { real.getOpt(key) orOpt createOptFunOpt.letMap(_(key).apply(real += (key, _))) }

  protected def put(s: ~[(A, B)]): Unit = this.synchronized { real +~= s }

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
