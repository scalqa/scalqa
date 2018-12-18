package scalqa; package Custom; package String; package Z

private[String] object indent {

  def apply(text: String, tag: String): String = if (tag.isVoid) text else {

    def off(s: String): String = {
      val b = new StringBuilder(s.length)
      var i = s.indexOf('\t')
      while (i >= 0) {
        while (b.length < i) b append " "
        b += '\t'
        i = s.indexOf('\t', i + 1)
      }
      while (b.length < s.length) b append " "
      b.toString
    }

    tag + text.allLines.format("\n" + off(tag))
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
