package scalqa; package j; package util; package test; package z; import language.implicitConversions

private[j] class Method(val name: String, code: () => Unit):

  @tn("run_Result") def run_?? : Result[true] =
    try
      code()
    catch
      case v: Problem => return v
    true

class Method1

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
