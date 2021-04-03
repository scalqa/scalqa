package scalqa; package j; package vm; import language.implicitConversions

import java.util.concurrent.{ ScheduledExecutorService, Executors}
import scala.concurrent.ExecutionContext
import ~~.Flow
import z.{SetupProperty as PRO}

object Setup:
  private var _sealed  = false
  /**/    def isSealed = _sealed;
  /**/    def seal     = _sealed = true

  @tn("schedular_Pro")               val schedular_*               : Pro.M[ScheduledExecutorService]                    = new PRO(Executors.newScheduledThreadPool(J.Vm.availableProcessors - 1 max 2))
  @tn("parallelFlowSetup_Pro")       val parallelFlowSetup_*       : Pro.M[(~[Any],Opt[(J.Vm.Priority,Int)])=>Flow[Any]]= new PRO(`val`.stream.z.flow.parallel.Setup)
  @tn("defaultExecutionContext_Pro") val defaultExecutionContext_* : Pro.M[ExecutionContext]                            = new PRO(ExecutionContext.Implicits.global);
  @tn("arrayInitSize_Pro")           val arrayInitSize_*           : Pro.M[Int]                                         = new PRO(16)
  @tn("jsonFormat_Pro")              val jsonFormat_*              : Pro.M[Json.Format]                                 = new PRO(json.z.DefaultFormat)
  @tn("bigDecimalDefaultScale_Pro")  val bigDecimalDefaultScale_*  : Pro.M[Int]                                         = new PRO(64)
  @tn("randomSource_Pro")            val randomSource_*            : Pro.M[J.Random.Source]                             = new PRO(util.Random.Z.JavaUtilSource)
  @tn("allowListUnpacked_Pro")       val allowUncompactedPack_*    : Pro.M[Boolean]                                     = new PRO(true)
  @tn("tempPath_Pro")                val tempPath_*                : Pro.M[Opt[File.Path]]                              = new PRO(\/)
                                                                                                                              // Lazy value faster implementations
  @tn("tempPath_Opt")     @fast lazy val tempPath_?                : Opt[File.Path]                                     = tempPath_*()
  /**/                    @fast lazy val bigDecimalDefaultScale    : Int                                                = bigDecimalDefaultScale_*()
  /**/                    @fast lazy val arrayInitSize             : Int                                                = arrayInitSize_*()
  /**/                    @fast lazy val defaultExecutionContext   : concurrent.ExecutionContext                        = defaultExecutionContext_*()
  /**/                    @fast lazy val allowUncompactedPack      : Boolean                                            = allowUncompactedPack_*()

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

@val parallelFlowSetup_* -> [[scalqa.val.Stream Stream]] parallel engine setup

      Defines factory to create parallel [[scalqa.val.stream.Flow Stream.Flow]].

      Default factory creates [[scalqa.val.stream.Flow Stream.Flow]] based on parallel java.stream.Stream implementation.

*/
