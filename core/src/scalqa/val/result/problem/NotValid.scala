package scalqa; package `val`; package result; package problem; import language.implicitConversions

class NotValid(val message: String = \/) extends Problem:

  @tn("exception_Opt") def exception_? : Opt[Exception] = \/

object NotValid:

  def unapply(v: NotValid): Option[String] = Some(v.message)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**

@class NotValid -> ###

       Problem indicating not valid state


*/
