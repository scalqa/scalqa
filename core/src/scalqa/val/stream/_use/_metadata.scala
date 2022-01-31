package scalqa; package `val`; package stream; package _use; import language.implicitConversions

transparent trait _metadata :

  extension[A](inline x: Stream[A])
    /**/            inline def docTree     : Doc.Tree      = Custom.Pipeline.docTree(x)
    /**/            inline def sizeOpt     : Int.Opt       = Able.Size.sizeOpt(x)
    /**/            inline def sizeLongOpt : Long.Opt      = Able.Size.sizeLongOpt(x)
    private[scalqa] inline def defaultDoc  : Doc           = z.util.MultiDoc(x)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait _metadata -> ### Stream Metadata Interface

      Metadata is a static knowledge about stream elements to be delivered

      Metadata methods can be called many times, they do not trigger any data movements


@def docTree -> Doc Tree description

      Returns a tree describing all stream trasformations

     ```
     ('a' <> 'z').stream
       .map(_.toInt)
       .take(_ % 2 == 0)
       .docTree.TP

     // Output
     scalqa.lang.int.g.Stream$TakeStream$2@4ds1{raw=Int}
       scalqa.lang.char.z.stream.map$Ints@j38c{raw=Int,fromRaw=Char,size=26}
         scalqa.lang.char.Z$Stream_fromRange@gw1k{raw=Char,size=26,from=a,step=1}
     ```

@def sizeOpt -> Optional size

     Many streams can return their current element count.  If the information is not available, void option is returned

     Note: If size is known, but exceeds integer range, void option is returned. For theses cases use [[sizeLongOpt]]

     ```
       var s = ('a' <> 'z').stream

       s.sizeOpt.TP         // Prints Int.Opt(26)

       s = s.take(_ > 10)   // static sizing is lost

       s.sizeOpt.TP         // Prints Int.Opt(VOID)
     ```

@def sizeLongOpt -> Optional long size

     Many streams can return their current element count.  If the information is not available, void option is returned

     ```
      var s = (Int.min.Long <> Int.max.toLong).stream

      s.sizeLongOpt.TP    // Prints Long.Opt(4294967296)

      s = s.take(_ > 10)  // static sizing is lost

      s.sizeLongOpt.TP    // Prints Long.Opt(VOID)
     ```
*/
