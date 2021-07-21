package scalqa; package j; package util; package test; package z; import language.implicitConversions

class Problem(val message: String) extends Exception(message) with Result.Problem:
  def this(context:String, count: Int, message: String) = this(context ++ (count > 1) ? ("(" + count + ")") + ": " + message)

  @tn("exception_Opt") def exception_? = this

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/