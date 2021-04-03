package scalqa; package gen; package time; import language.implicitConversions

object Z:
  def pad(v: Long, sz: Int): String = { var s = v.toString; while (s.length < sz) s = "0" + s; s }

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
