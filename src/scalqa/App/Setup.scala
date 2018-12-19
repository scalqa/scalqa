package scalqa; package App

object Setup {

  val SchedularPro = new Pro.A.Setup[java.util.concurrent.ScheduledExecutorService](java.util.concurrent.Executors.newScheduledThreadPool(Host.availableProcessors - 1 max 2))

  val ParallelFlowPro: Pro.A.Setup[Stream[Any] => Stream.Flow[Any]] = new Pro.A.Setup(Stream.Z.A.ParallelJavaStream)

  val InitBufferSizePro = new Pro.A.Setup(16)

  val RandomSourcePro = new Pro.A.Setup[Util.Random.Source](Util.Random.Source.Z.JavaRandom)

  val CustomNumberScalePro = new Pro.A.Setup(64)

  val ExecutionContextPro = new Pro.A.Setup[concurrent.ExecutionContext](concurrent.ExecutionContext.Implicits.global)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 *  @val ParallelFlowPro -> Stream parallel engine setup
 *
 *     Factory to create parallel [[Stream.Flow]]
 *
 *     Default creates parallel java.stream.Stream based implementation
 *
 */
