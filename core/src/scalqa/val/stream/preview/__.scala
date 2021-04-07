package scalqa; package `val`; package stream

trait Preview[A] extends ~[A]:
  /**/                    def preview                     : A
  @tn("preview_Opt")      def preview_?                   : Opt[A]
  @tn("preview_Stream")   def preview_~(cnt: Int)         : ~[A] & Able.Size
  /**/                    def previewSize                 : Preview.LazySize
  @tn("readWhile_Stream") def readWhile_~(f: A => Boolean): ~[A] & Able.Size

object Preview:
  type LazySize = preview.LazySize

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait Preview -> ###

    [[Preview]] is an extension of [[Stream]] with preview capabilities

    It allows to pre-load and inspect elements before they are read from stream
    ```
    val s  : ~[Int]              =  1 <> 10
    val ps : ~~.Preview[Int] = s.enablePreview

    ps.preview.TP            // Prints  1

    ps.preview_~(5).TP       // Prints  ~(1, 2, 3, 4, 5)

    ps.preview_~(3).TP       // Prints  ~(1, 2, 3)

    (ps.previewSize > 12).TP // Prints false

    ps.TP                    // Prints ~(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    ps.TP                    // Prints ~()
    ```

@def preview -> Preview next element

      Returns element, waiting in the pipeline to be next

      Operation will fail if stream is empty

@def preview_? -> Preview next optional element

      Optionally returns element, waiting in the pipeline to be next or empty option if there is none

@def preview_~ ->  Preview multiple elements

       Returns a [[Stream]] of elements waiting in the pipeline to be fetched next

       A given count of elements is requested, but returned count can be less (even zero) if not enough is available

@def previewSize -> Lazy size interface

       Returns a lazily evaluated size object, which preloads just enough elements to answer sizing requests

       ```
       def s : ~[String] = ?_?_?

       def p : ~~.Preview[String] = s.preview

       p.previewSize >= 10 // This will pre-load no more than 10 elements

       p.previewSize < 100 // This will pre-load no more than 100 elements
      ```

@def readWhile_~ -> Remove many elements by condition

      Immediatelly removes all consequtive stream elements which satisfy the given predicate.

      The removed elements are returned as a new stream

      Non consequtive, but complient elements found later will not be affected.

      Note. This operation is only available in Preview interface, because it requires to examine elements before they are streamed
*/
