package scalqa; package `val`; package stream; package flow; import language.implicitConversions

transparent trait _metadata[A]:
  self: Flow[A] =>

  /**/                 def isParallel : Boolean
  /**/                 def docTree    : Doc.Tree    = Custom.Pipeline.infoTree(self)
  @tn("size_Opt")      def size_?     : Int.Opt     = sizeLong_?.take(v => v>=0 && v<=Int.max).map(_.toInt)
  @tn("sizeLong_Opt")  def sizeLong_? : Long.Opt

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait _metadata -> ### Metadata Interface

      Metadata is a static knowledge about stream flow elements to be delivered

      Metadata methods can be called many times, they do not trigger any data movements


@def isParallel -> Parallel check

       Returns `true` if this [[Parallel]] is parallel


@def docTree -> Tree description

      Returns a tree describing all flow trasformations

     ```
       ('a' <> 'z').~
          .take(_ > 'X')
          .map(_.toUpper)
          .parallel
          .docTree.TP

       // Output
        scalqa.val.stream.z.flow.parallel.Flow_asJavaStream@ncwo{}
          scalqa.lang.char.g.stream.z.map$Chars@uru4{raw=Char,fromRaw=Char}
            scalqa.lang.char.g.Stream$TakeStream$2@56u4{raw=Char,fromRaw=Char}
              scalqa.lang.char.g.stream.Z$Stream_fromRange@cq06{raw=Char,size=26,from=a,step=1}
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
      var s = (Int.min.Long <> Int.max.toLong).~

      s.sizeLong_?.TP    // Prints Long.Opt(4294967296)

      s = s.take(_ > 10) // static sizing is lost

      s.sizeLong_?.TP    // Prints Long.Opt(\/)
     ```
 */
