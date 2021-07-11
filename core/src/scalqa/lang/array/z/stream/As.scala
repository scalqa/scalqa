package scalqa; package lang; package array; package z; package stream; import language.implicitConversions

object As:

  class Refs[A](a: Array[Ref], sz: Int) extends ~[A] with Able.Size with ~~.Custom.Discharge[A] with Able.Doc :
    def this(a: Array[Ref]) = this(a,a.length); def doc = this.defaultDoc += ("array",a)
    private            var i                         = 0
    @tn("read_Opt")    def read_?                    = { var o:Opt[A] = \/; if(i<sz){ o=a(i).cast[Opt[A]]; i+=1}; o}
    /**/               def size                      = sz - i
    /**/               def dischargeTo(b: Buffer[A]) = b.addArray_trusted(a.cast[Array[A]], i, sz-i)

  class Booleans[A<:Raw.Boolean](a: Array[Boolean], sz: Int) extends Boolean.G.~[A] with Able.Size:
    def this(a: Array[Boolean]) = this(a,a.length); def doc = this.defaultDoc += ("array",a)
    private            var i                         = 0
    @tn("readRaw_Opt") def readRaw_?                 = { var o:Boolean.G.Opt[A]= \/; if(i<sz) { o=Boolean.G.Opt(a(i).cast[A]); i+=1 }; o}
    /**/               def size                      = sz - i
    override           def dischargeTo(b: Buffer[A]) = if(i<sz) b.addArray_trusted(a.cast[Array[A]], i, sz-i)

  class Bytes[A<:Raw.Byte](a: Array[Byte], sz: Int) extends Byte.G.~[A] with Able.Size:
    def this(a: Array[Byte]) = this(a,a.length); def doc = this.defaultDoc += ("array",a)
    private            var i                         = 0
    @tn("readRaw_Opt") def readRaw_?                 = { var o:Byte.G.Opt[A]= \/; if(i<sz) { o=a(i).cast[Byte.G.Opt[A]]; i+=1 }; o}
    /**/               def size                      = sz - i
    override           def dischargeTo(b: Buffer[A]) = if(i<sz) b.addArray_trusted(a.cast[Array[A]], i, sz-i)

  class Chars[A<:Raw.Char](a: Array[Char], sz: Int) extends Char.G.~[A] with Able.Size:
    def this(a: Array[Char]) = this(a,a.length); def doc = this.defaultDoc += ("array",a)
    private            var i                         = 0
    @tn("readRaw_Opt") def readRaw_?                 = { var o:Char.G.Opt[A]= \/; if(i<sz) { o=a(i).cast[Char.G.Opt[A]]; i+=1 }; o}
    /**/               def size                      = sz - i
    override           def dischargeTo(b: Buffer[A]) = if(i<sz) b.addArray_trusted(a.cast[Array[A]], i, sz-i)

  class Shorts[A<:Raw.Short](a: Array[Short], sz: Int) extends Short.G.~[A] with Able.Size:
    def this(a: Array[Short]) = this(a,a.length); def doc = this.defaultDoc += ("array",a)
    private            var i                         = 0
    @tn("readRaw_Opt") def readRaw_?                 = { var o:Short.G.Opt[A]= \/; if(i<sz) { o=a(i).cast[Short.G.Opt[A]]; i+=1 }; o}
    /**/               def size                      = sz - i
    override           def dischargeTo(b: Buffer[A]) = if(i<sz) b.addArray_trusted(a.cast[Array[A]], i, sz-i)

  class Ints[A<:Raw.Int](a: Array[Int], sz: Int) extends int.G.~[A] with Able.Size:
    def this(a: Array[Int]) = this(a,a.length); def doc = this.defaultDoc += ("array",a)
    private            var i                         = 0
    @tn("readRaw_Opt") def readRaw_?                 = { var o:Int.G.Opt[A]= \/; if(i<sz) { o=a(i).cast[Int.G.Opt[A]]; i+=1 }; o}
    /**/               def size                      = sz - i
    override           def dischargeTo(b: Buffer[A]) = if(i<sz) b.addArray_trusted(a.cast[Array[A]], i, sz-i)

  class Longs[A<:Raw.Long](a: Array[Long], sz: Int) extends Long.G.~[A] with Able.Size:
    def this(a: Array[Long]) = this(a,a.length); def doc = this.defaultDoc += ("array",a)
    private            var i                         = 0
    @tn("readRaw_Opt") def readRaw_?                 = { var o:Long.G.Opt[A]= \/; if(i<sz) { o=a(i).cast[Long.G.Opt[A]]; i+=1 }; o}
    /**/               def size                      = sz - i
    override           def dischargeTo(b: Buffer[A]) = if(i<sz) b.addArray_trusted(a.cast[Array[A]], i, sz-i)

  class Floats[A<:Raw.Float](a: Array[Float], sz: Int) extends Float.G.~[A] with Able.Size:
    def this(a: Array[Float]) = this(a,a.length); def doc = this.defaultDoc += ("array",a)
    private            var i                         = 0
    @tn("readRaw_Opt") def readRaw_?                 = { var o:Float.G.Opt[A]= \/; if(i<sz) { o=a(i).cast[Float.G.Opt[A]]; i+=1 }; o}
    /**/               def size                      = sz - i
    override           def dischargeTo(b: Buffer[A]) = if(i<sz) b.addArray_trusted(a.cast[Array[A]], i, sz-i)

  class Doubles[A<:Raw.Double](a: Array[Double], sz: Int) extends Double.G.~[A] with Able.Size:
    def this(a: Array[Double]) = this(a,a.length); def doc = this.defaultDoc += ("array",a)
    private            var i                         = 0
    @tn("readRaw_Opt") def readRaw_?                 = { var o:Double.G.Opt[A]= \/; if(i<sz) { o=a(i).cast[Double.G.Opt[A]]; i+=1 }; o}
    /**/               def size                      = sz - i
    override           def dischargeTo(b: Buffer[A]) = if(i<sz) b.addArray_trusted(a.cast[Array[A]], i, sz-i)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
