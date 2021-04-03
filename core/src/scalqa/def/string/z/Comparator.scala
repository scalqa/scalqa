package scalqa; package `def`; package string; package z; import language.implicitConversions

object Ordering extends Ordering[String]:
  def compare(x: String, y: String) = x.compareTo(y)

  object IgnoreCase extends Ordering[String]:
    def compare(x: String, y: String) = x.compareToIgnoreCase(y)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
