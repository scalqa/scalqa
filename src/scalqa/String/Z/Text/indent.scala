package scalqa; package String; package Z; package Text

private[String] object indent {

  def apply(text: Text, tag: String): Text = if (tag.isVoid) text else {
    def off(s: String): String = if (s == null || s.length == 0) Empty else Builder.get(s.length).I(b => {
      var i = s.indexOf('\t')
      while (i >= 0) {
        while (b.length < i) b =+ Space
        b =+ '\t'
        i = s.indexOf('\t', i + 1)
      }
      while (b.length < s.length) b =+ Space
    })
    tag + text.allLines.format(Eol + off(tag))
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/