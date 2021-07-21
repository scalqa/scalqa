package scalqa; package `val`; package pack; package z; import language.implicitConversions

private[scalqa] final class Void[A] extends ><[A] with Gen.Void:
  type THIS_TYPE = Pack[A]
  @tn("stream")     override def ~                           : ~[A]      = ZZ.voidStream
  /**/                       def apply(i: Int)               : A         = J.illegalState()
  /**/                       def size                        : Int       = 0
  /**/                       def join(v: A)                  : ><[A]     = Few.Pack_ofOne(v)
  /**/                       def joinAt(i: Int, v: A)        : ><[A]     = Few.Pack_ofOne(v)
  /**/                       def joinAll(v: ~[A])            : ><[A]     = v.><
  /**/                       def joinAllAt(i: Int, v: ~[A])  : ><[A]     = v.><
  @tn("take_Range") override def take_<>(f:Int, sz:Int)      : ><[A]     = this
  @tn("drop_Range") override def drop_<>(f:Int, sz:Int)      : ><[A]     = this
  /**/                       def compact                     : this.type = this
  /**/                       def toBuffer                    : Buffer[A] = new Any.Ref.Buffer()

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
