package scalqa; package j; package vm; import language.implicitConversions

import java.util.concurrent.{ ScheduledExecutorService, Executors}
import scala.concurrent.ExecutionContext
import Stream.Flow
import z.{SetupProperty as PRO}

object Setup:
  private var _sealed  = false
  /**/    def isSealed = _sealed;
  /**/    def seal     = _sealed = true

  val schedularPro                      : Pro.M[ScheduledExecutorService]                         = new PRO(Executors.newScheduledThreadPool(J.Vm.availableProcessors - 1 max 2))
  val parallelFlowSetupPro              : Pro.M[(Stream[Any],Opt[(J.Vm.Priority,Int)])=>Flow[Any]]= new PRO(`val`.stream.z.flow.ParallelSetup)
  val defaultExecutionContextPro        : Pro.M[ExecutionContext]                                 = new PRO(ExecutionContext.Implicits.global);
  val arrayInitSizePro                  : Pro.M[Int]                                              = new PRO(16)
  val jsonFormatPro                     : Pro.M[Json.Format]                                      = new PRO(json.z.DefaultFormat)
  val bigDecimalDefaultScalePro         : Pro.M[Int]                                              = new PRO(64)
  val randomSourcePro                   : Pro.M[J.Random.Source]                                  = new PRO(util.Random.Z.JavaUtilSource)
  val tempPathPro                       : Pro.M[Opt[File.Path]]                                   = new PRO(\/)

  @fast lazy val tempPathOpt            : Opt[File.Path]                                          = tempPathPro()
  @fast lazy val bigDecimalDefaultScale : Int                                                     = bigDecimalDefaultScalePro()
  @fast lazy val arrayInitSize          : Int                                                     = arrayInitSizePro()
  @fast lazy val defaultExecutionContext: concurrent.ExecutionContext                             = defaultExecutionContextPro()

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object Setup -> ### Scalqa Configuration

   [[Setup]] contains a set of mutable configuration properties, which adhere to the following rules:

      - Once the property value was accessed, it cannot be chaged anymore
      - If method `J.Vm.Setup.seal` is executed, all properties become immutable

@val parallelFlowSetupPro -> [[scalqa.val.Stream Stream]] parallel engine setup

      Defines factory to create parallel [[scalqa.val.stream.Flow Stream.Flow]].

      Default factory creates [[scalqa.val.stream.Flow Stream.Flow]] based on parallel java.stream.Stream implementation.

*/
