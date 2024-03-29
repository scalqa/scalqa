package scalqa; package lang; package string; package z; import language.implicitConversions

private[lang] class LineStream(str: String) extends Stream[String]:
  private var i = 0
  private val sz = str.length

  def readOpt : Opt[String] =
    if(i >= sz) VOID
    else
      val s = i
      while (i < sz && str.charAt(i) != '\n') i += 1
      var e = i
      i += 1
      if(s<e && str.charAt(e-1)=='\r') e -= 1
      str.substring(s,e)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
