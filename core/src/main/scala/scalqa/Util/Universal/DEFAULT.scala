package scalqa; package Util; package Universal

object DEFAULT {

  implicit def zzApplicationExecutionContext(n: DEFAULT.type): concurrent.ExecutionContext = App.executionContext

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @object DEFAULT -> `Universal Value DEFAULT`
 *
 *    See [[Universal]] for usage
 *
 */
