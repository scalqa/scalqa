package scalqa; package J; package Json; package Z

private[scalqa] object DefaultFormat extends Format { // This should be thrown away and redone from ground up

  def parseOpt(s: String): Opt.orError[Data] = {

    val it = s.trim.allChars.iterator

    var cur: Char = 0

    def fetchNonSpaceOpt = it.nextFindOpt(_.isWhitespace.not).apply(cur = _)

    def parseStr(firstOpt: Opt[Int] = \/): String = {
      var s = it.nextWhile({ case ':' | ',' | '}' | ']' => false; case _ => true }).format().trim
      fetchNonSpaceOpt
      if (firstOpt) s = (firstOpt.value.toChar + s).trim
      if (s.length.I.to(l => l > 1 && s.charAt(0) == '"' && s.charAt(l - 1) == '"')) s = s copyFrom 1 copyShort 1
      s
    }

    def parseAny: Any = fetchNonSpaceOpt.or(throw new Exception("Empty position")) match {
      case '{' => Object.W.get().I(o => { while (cur != '}') o.put(parseStr(), parseAny); fetchNonSpaceOpt })
      case '[' => Array.W.get().I(a => { while (cur != ']') a =+ parseAny; fetchNonSpaceOpt })
      case c   => parseStr(c.toInt)
    }

    Opt.orError.get(parseAny.I(v => if (!v.isInstanceOf[Data]) Fail("Must start with [ or {")).cast[Data])
  }

  def format(oa: Data): String = {
    def fAny(v: Any): String = v match {
      case s: String =>
        "\"" + s.allChars.map({
          case '"' => "\\\""
          case '\\' => "\\\\"
          case '/' => "\\/"
          case '\b' => "\\b"
          case '\f' => "\\f"
          case '\n' => "\\n"
          case '\r' => "\\r"
          case '\t' => "\\t"
          case c if ((c >= '\u0000' && c <= '\u001f') || (c >= '\u007f' && c <= '\u009f')) => "\\u%04x".Ops.format(c.toInt)
          case c => c
        }).format() + "\""
      case o: Object => "{" + o.allPairs.map(_(fAny(_) + " : " + fAny(_))).format(", ") + "}"
      case a: Array  => "[" + a.all.map(fAny).format(", ") + "]"
      case v         => v.toString
    }
    fAny(oa)
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/