package scalqa; package `val`; package stream; package z; package a; import language.implicitConversions

object VarArg:

  class Stream_ofOne[A](v: A) extends ~[A] with Able.Size:
    private         var used   : Boolean = false
    @tn("read_Opt") def read_? : Opt[A]  = if(used) \/ else { used=true; v }
    /**/            def size   : Int     = if(used) 0 else 1

  class Stream_ofTwo[A](v1: A, v2: A) extends ~[A] with Able.Size:
    private         var i      : Int     = 0
    @tn("read_Opt") def read_? : Opt[A]  = { i+=1; if(i==1) v1 else if(i==2) v2 else \/ }
    /**/            def size   : Int     = 2 - i max 0

  class Stream_ofThree[A](v1: A, v2: A, v3: A) extends ~[A] with Able.Size:
    private         var i      : Int     = 0
    @tn("read_Opt") def read_? : Opt[A]  = { i+=1; if(i==1) v1 else if(i==2) v2 else if(i==3) v3 else \/ }
    /**/            def size   : Int     = 3 - i max 0

  class Stream_ofMany[A](v1: A, v2: A, v3: A, vs: Seq[A]) extends ~[A] with Able.Size:
    private         var i      : Int     = 0
    private         val sz     : Int     = vs.size + 3
    @tn("read_Opt") def read_? : Opt[A]  = { i+=1; if(i>3){ if(i>sz) \/ else vs(i-4)} else if(i==1) v1 else if(i==2) v2 else if(i==3) v3 else \/ }
    /**/            def size   : Int     = 3 + vs.size - i max 0

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
