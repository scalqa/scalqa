package scalqa; package `val`; package idx; package z; package mutable; import language.implicitConversions

private[idx] class AsSealable[A](idx: Mutable[A]) extends J.Util.Proxy.Idx.M[A] with Able.Seal:
  private   var _sealed         = false
  /**/      def isSealed        = _sealed
  /**/      def seal: this.type = { _sealed = true; this }
  override  def size            = idx.size
  override  def apply(i: Int)   = idx(i)
  override  def stream          = idx.stream
  protected def real            = { Able.Seal.check(this); idx }

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
