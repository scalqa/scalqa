package scalqa; package `val`; package stream; package z; package x; import language.implicitConversions

object VarArg:

  class Stream_ofOne[A](v: A) extends Stream[A] with Able.Size:
    private         var used   : Boolean = false
    def readOpt : Opt[A]  = if(used) VOID else { used=true; v }
    /**/            def size   : Int     = if(used) 0 else 1

  class Stream_ofTwo[A](v1: A, v2: A) extends Stream[A] with Able.Size:
    private         var i      : Int     = 0
    def readOpt : Opt[A]  = { i+=1; if(i==1) v1 else if(i==2) v2 else VOID }
    /**/            def size   : Int     = 2 - i max 0

  class Stream_ofThree[A](v1: A, v2: A, v3: A) extends Stream[A] with Able.Size:
    private         var i      : Int     = 0
    def readOpt : Opt[A]  = { i+=1; if(i==1) v1 else if(i==2) v2 else if(i==3) v3 else VOID }
    /**/            def size   : Int     = 3 - i max 0

  class Stream_ofFour[A](v1: A, v2: A, v3: A, v4: A) extends Stream[A] with Able.Size:
    private         var i      : Int     = 0
    def readOpt : Opt[A]  = { i+=1;  i match{ case 1 => v1; case 2 => v2; case 3 => v3; case 4 => v4; case _ => VOID }}
    /**/            def size   : Int     = 4 - i max 0

  class Stream_ofFive[A](v1: A, v2: A, v3: A, v4: A, v5: A) extends Stream[A] with Able.Size:
    private         var i      : Int     = 0
    def readOpt : Opt[A]  = { i+=1;  i match{ case 1 => v1; case 2 => v2; case 3 => v3; case 4 => v4; case 5 => v5; case _ => VOID }}
    /**/            def size   : Int     = 5 - i max 0

  class Stream_ofMany[A](v1: A, v2: A, v3: A, vs: Seq[A]) extends Stream[A] with Able.Size:
    private         var i      : Int     = 0
    private         val sz     : Int     = vs.size + 3
    def readOpt : Opt[A]  = { i+=1; if(i>3){ if(i>sz) VOID else vs(i-4)} else if(i==1) v1 else if(i==2) v2 else if(i==3) v3 else VOID }
    /**/            def size   : Int     = 3 + vs.size - i max 0

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
