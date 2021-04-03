package scalqa; package `val`; package result; package problem; package z; import language.implicitConversions

class ExceptionProblem(v: Throwable) extends RuntimeException(v) with Problem:
  @tn("exception_Opt") def exception_? = this
  /**/                    def message = v.getMessage
  override                def getCause = v

object ExceptionProblem:

  class Wrap(val deficiency: Problem) extends RuntimeException(deficiency.message)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
