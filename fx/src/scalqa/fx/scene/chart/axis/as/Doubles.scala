package scalqa; package fx; package scene; package chart; package axis; package as; import language.implicitConversions

class Doubles extends as.Numbers[Double](\/):
  def this(name: String) = { this(); name.^.?.forval(label = _) }

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
