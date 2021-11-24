package scalqa; package lang; package anyref; import language.implicitConversions

object Z:

  class Stream_ofArray[A](a: Array[AnyRef], sz: Int) extends Stream[A] with Able.Size with Val.Stream.Custom.Discharge[A] with Able.Doc :
    def this(a: Array[AnyRef]) = this(a,a.length)
    private            var i                             = 0
    def readOpt                        = { var o:Opt[A] = \/; if(i<sz){ o=a(i).cast[Opt[A]]; i+=1}; o}
    /**/               def size                          = sz - i
    /**/               def dischargeTo(b: Val.Buffer[A]) = b.addArray_trusted(a.cast[Array[A]], i, sz-i)
    /**/               def doc                           = this.defaultDoc += ("array",a)


/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
