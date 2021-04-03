package scalqa; package `val`; package stream; package preview

abstract class LazySize:

  protected             def preload(i: Int): Int
  @tn("checkEqual")     def ==(i: Int)     : Boolean  = preload(i+1)== i
  @tn("checkLess")      def < (i: Int)     : Boolean  = preload(i)   < i
  @tn("checkLeq")       def > (i: Int)     : Boolean  = preload(i+1) > i
  @tn("checkGreater")   def <=(i: Int)     : Boolean  = preload(i+1)<= i
  @tn("checkGeq")       def >=(i: Int)     : Boolean  = preload(i)  >= i
  /**/                  def size           : Int      = preload(Int.max)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@class LazySize -> ###

   When evaluated with comparison operators, [LazySize] preloads just enough stream elements to answer the questions

   ```
   def s : ~[String] = ?_?_?

   val lazySize = s.preview.previewSize

   lazySize >= 10 // This will pre-load no more than 10 elements

   lazySize < 100 // This will pre-load no more than 100 elements
  ```

@def size -> Total size

    Preloads all elements, unless sizing is available in metadata
*/
