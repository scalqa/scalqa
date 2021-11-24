package scalqa; package `val`; package pack; package z; import language.implicitConversions

private[`val`] object Few:

  final class Pack_ofOne[A](val v1: A) extends Abstract[A]:
    override def stream                 = `val`.stream.z.x.VarArg.Stream_ofOne(v1)
    /**/     def apply(i: Int)          = if (i == 0) v1 else J.illegalArgument("Index "+i+" not in range 0 <> 0")
    /**/     def size                   = 1
    /**/     def join(v: A)             = new Pack_ofTwo(v1, v)
    /**/     def z_foreach[U](f:A=>U)   = f(v1)

  final class Pack_ofTwo[A] (val v1: A, val v2: A) extends Abstract[A]:
    override def stream                 = `val`.stream.z.x.VarArg.Stream_ofTwo(v1,v2)
    /**/     def apply(i: Int)          = i match { case 1 => v2; case 0 => v1; case _ => J.illegalArgument("Index "+i+" not in range 0 <> 1") }
    /**/     def size                   = 2
    /**/     def join(v: A)             = new Pack_ofThree(v1, v2, v)
    /**/     def z_foreach[U](f:A=>U)   = { f(v1); f(v2) }

  final class Pack_ofThree[A] (val v1: A, val v2: A, val v3: A) extends Abstract[A]:
    override def stream                 = `val`.stream.z.x.VarArg.Stream_ofThree(v1,v2,v3)
    /**/     def apply(i: Int)          = i match { case 2 => v3; case 1 => v2; case 0 => v1; case _ => J.illegalArgument("Index "+i+" not in range i, 0 <> 2") }
    /**/     def size                   = 3
    /**/     def join(v: A)             = new ArrayPack(v1,v2,v3,v)
    /**/     def z_foreach[U](f:A=>U)   = { f(v1); f(v2) ; f(v3) }

  abstract class Abstract[A] private[Few]() extends Pack[A]:
    type THIS_TYPE = Pack[A]
    /**/     def join(v: A)                  : Pack[A]
    /**/     def joinAt(i: Int, v: A)        : Pack[A]   = this.stream.joinAt(i, v).pack
    /**/     def joinAll(v: Stream[A])       : Pack[A]   = v.nonEmptyOpt.map(v => (this.stream ++ v).pack) or this
    /**/     def joinAllAt(i:Int,v:Stream[A]): Pack[A]   = v.nonEmptyOpt.map(v => (this.stream ++@ (i,v)).pack) or this
    override def takeRange(f:Int,sz:Int)     : Pack[A]   = this.stream.takeRange(f <>= sz).pack
    override def dropRange(f:Int,sz:Int)     : Pack[A]   = this.stream.dropRange(f <>= sz).pack
    /**/     def pack                        : this.type = this
    /**/     def toBuffer                    : Buffer[A] = new AnyRef.Buffer(this.stream)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
