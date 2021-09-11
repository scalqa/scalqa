package scalqa; package `val`; package pack; package z; import language.implicitConversions

private[`val`] object Few:

  final class Pack_ofOne[A](val v1: A) extends Base[A]:
    /**/                   def apply(i: Int) = if (i == 0) v1 else J.illegalArgument("Index "+i+" not in range 0 <> 0")
    /**/                   def size          = 1
    @tn("stream") override def ~             = stream.z.x.VarArg.Stream_ofOne(v1)
    /**/                   def join(v: A)    = new Pack_ofTwo(v1, v)

  final class Pack_ofTwo[A] (val v1: A, val v2: A) extends Base[A]:
    /**/                   def apply(i: Int) = i match { case 1 => v2; case 0 => v1; case _ => J.illegalArgument("Index "+i+" not in range 0 <> 1") }
    /**/                   def size          = 2
    @tn("stream") override def ~             = stream.z.x.VarArg.Stream_ofTwo(v1,v2)
    /**/                   def join(v: A)    = new Pack_ofThree(v1, v2, v)

  final class Pack_ofThree[A] (val v1: A, val v2: A, val v3: A) extends Base[A]:
    /**/                   def apply(i: Int) = i match { case 2 => v3; case 1 => v2; case 0 => v1; case _ => J.illegalArgument("Index "+i+" not in range i, 0 <> 2") }
    /**/                   def size          = 3
    @tn("stream") override def ~             = stream.z.x.VarArg.Stream_ofThree(v1,v2,v3)
    /**/                   def join(v: A)    = new ArrayPack(v1,v2,v3,v)

  abstract class Base[A] private[Few]() extends ><[A]:
    type THIS_TYPE = ><[A]
    /**/                       def join(v: A)                 : ><[A]
    /**/                       def joinAt(i: Int, v: A)       : ><[A]     = this.~.joinAt(i, v).><
    /**/                       def joinAll(v: ~[A])           : ><[A]     = v.nonEmpty_?.map(v => (this.~ ++ v).><) or this
    /**/                       def joinAllAt(i: Int, v: ~[A]) : ><[A]     = v.nonEmpty_?.map(v => (this.~ ++@ (i,v)).><) or this
    @tn("take_Range") override def take_<>(f:Int,sz:Int)      : ><[A]     = this.~.take_<>(f <>= sz).><
    @tn("drop_Range") override def drop_<>(f:Int,sz:Int)      : ><[A]     = this.~.drop_<>(f <>= sz).><
    /**/                       def compact                    : this.type = this
    /**/                       def toBuffer                   : Buffer[A] = new AnyRef.Buffer(this.~)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
