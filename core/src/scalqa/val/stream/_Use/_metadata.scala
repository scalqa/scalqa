package scalqa; package `val`; package stream; package _Use; import language.implicitConversions

transparent trait _metadata :

  extension[A](inline x: ~[A])
    /**/                inline def describe   : String    = Custom.Pipeline.infoTree(x).text
    @tn("size_Opt")     inline def size_?     : Int.Opt   = Able.Size.size_?(x)
    @tn("sizeLong_Opt") inline def sizeLong_? : Long.Opt  = Able.Size.sizeLong_?(x)
    private[scalqa]     inline def defaultDoc : Self.Doc  = z.util.MultiDoc(x)

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


@def describe -> Text description

      Returns a tree formatted text describing all stream trasformations

     ```
     ('a' <> 'z').~
       .map(_.Int)
       .take(_ % 2 == 0)
       .describe.TP

     // Output
     scalqa.lang.int.g.Stream$TakeStream$2@4ds1{raw=Int}
       scalqa.lang.char.z.stream.map$Ints@j38c{raw=Int,fromRaw=Char,size=26}
         scalqa.lang.char.Z$Stream_fromRange@gw1k{raw=Char,size=26,from=a,step=1}
     ```

@def size_? -> Optional size

     Many streams can return their current element count.  If the information is not available, void option is returned

     Note: If size is known, but exceeds integer range, void option is returned. For theses cases use [[sizeLong_?]]

     ```
       var s = ('a' <> 'z').~

       s.size_?.TP         // Prints Int.Opt(26)

       s = s.take(_ > 10)  // static sizing is lost

       s.size_?.TP         // Prints Int.Opt(\/)
     ```

@def sizeLong_? -> Optional long size

     Many streams can return their current element count.  If the information is not available, void option is returned

     ```
      var s = (Int.min.Long <> Int.max.Long).~

      s.sizeLong_?.TP    // Prints Long.Opt(4294967296)

      s = s.take(_ > 10) // static sizing is lost

      s.sizeLong_?.TP    // Prints Long.Opt(\/)
     ```
*/
