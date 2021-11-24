package scalqa; package `val`; package stream

trait Preview[A] extends Stream[A] with Able.Empty:
  /**/   def preview                      : A
  /**/   def previewOpt                   : Opt[A]
  /**/   def previewStream(cnt: Int)      : Stream[A] & Able.Size
  /**/   def previewSize                  : Preview.LazySize
  /**/   def readWhileStream(f:A=>Boolean): Stream[A] & Able.Size
  inline def isEmpty                      : Boolean                 = previewOpt.isEmpty


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

    [[Preview]] is an extension of stream with preview capabilities

    It allows to pre-load and inspect elements before they are read from the stream

    ```
    val s  : Stream[Int]         = 1 <> 10
    val ps : Stream.Preview[Int] = s.enablePreview

    ps.preview.TP            // Prints  1

    ps.previewStream(5).TP       // Prints  Stream(1, 2, 3, 4, 5)

    ps.previewStream(3).TP       // Prints  Stream(1, 2, 3)

    (ps.previewSize > 12).TP // Prints false

    ps.TP                    // Prints Stream(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    ps.TP                    // Prints Stream()
    ```

@def preview -> Preview next element

      Returns element, waiting in the pipeline to be next

      Operation will fail if stream is empty

@def previewOpt -> Preview next optional element

      Optionally returns element, waiting in the pipeline to be next or empty option if there is none

@def previewStream ->  Preview multiple elements

       Returns a [[Stream]] of elements waiting in the pipeline to be fetched next

       A given count of elements is requested, but returned count can be less (even zero) if not enough is available

@def previewSize -> Lazy size interface

       Returns a lazily evaluated size object, which preloads just enough elements to answer sizing requests

       ```
       def s: Stream[String] = ?_?_?

       def p: Stream.Preview[String] = s.preview

       p.previewSize >= 10 // This will pre-load no more than 10 elements

       p.previewSize < 100 // This will pre-load no more than 100 elements
      ```

@def readWhileStream -> Read many elements with condition

      Immediatelly removes all consequtive stream elements which satisfy the given predicate.

      The removed elements are returned as a new stream

      Non consequtive, but complient elements found later will not be affected.

      Note. This operation is only available in Preview interface, because it requires to examine elements before they are read
*/
