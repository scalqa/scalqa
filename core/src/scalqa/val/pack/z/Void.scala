package scalqa; package `val`; package pack; package z; import language.implicitConversions

private[scalqa] final class Void[A] extends Pack[A] with Gen.Void:
  type THIS_TYPE = Pack[A]
  override def stream                      : Stream[A]=VOID
  /**/     def apply(i: Int)               : A         = J.illegalState("Empty")
  /**/     def size                        : Int       = 0
  /**/     def join(v: A)                  : Pack[A]   = Few.Pack_ofOne(v)
  /**/     def joinAt(i: Int, v: A)        : Pack[A]   = Few.Pack_ofOne(v)
  /**/     def joinAll(v: Stream[A])       : Pack[A]   = v.pack
  /**/     def joinAllAt(i:Int,v:Stream[A]): Pack[A]   = v.pack
  override def takeRange(f:Int, sz:Int)    : Pack[A]   = this
  override def dropRange(f:Int, sz:Int)    : Pack[A]   = this
  /**/     def pack                        : this.type = this
  /**/     def toBuffer                    : Buffer[A] = new AnyRef.G.Buffer()
  override def z_foreach[U](f: A=>U)       : Unit      = ()

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
