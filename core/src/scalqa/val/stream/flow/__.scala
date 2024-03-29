package scalqa; package `val`; package stream; import language.implicitConversions

abstract class Flow[A] private[stream] extends flow._build[A] with flow._use[A] with flow._metadata[A]

object Flow:
  type _build[A]    = flow._build[A]
  type _metadata[A] = flow._metadata[A]
  type _use[A]      = flow._use[A]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@class Flow -> ### Stream Flow

   Flow is similar to [[scalqa.val.Stream stream]], but without sequence specific methods.

   Elements of Flow can be processed either in parallel or sequentially.

   Flow is usually created from stream with ".parallel" method.

   ```
      val flow: Stream.Flow[Int] = (1 <> 10).stream.parallel
   ```
*/