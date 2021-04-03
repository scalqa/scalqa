package scalqa; package j; package json; package z; import language.implicitConversions

private[scalqa] object DefaultFormat extends Format /*This should be thrown away and redone from ground up*/:

  @tn("parse_Result") def parse_??(s: String): Result[Json.Object | Json.Array] = {
    val stream = s.trim.char_~.enablePreview
    var cur: Char = 0

    def fetchNonSpace_? = stream.find_?(!_.isWhitespace).forval(cur = _)

    def parseStr(next: Int.Opt = \/): String =
      var s = stream.readWhile_~({ case ':' | ',' | '}' | ']' => false; case _ => true }).makeString().trim;
      fetchNonSpace_?
      if (next.nonEmpty) s = (next.get.toChar.toString + s).trim
      if ({ val l = s.length; l > 1 && s.charAt(0) == '"' && s.charAt(l - 1) == '"' }) s = s.substring(0, s.length - 1).substring(1)
      s

    def parseAny: Any = fetchNonSpace_?.or(throw new Exception("Empty position")) match
      case '{' => { val o = J.Object.Mutable(); while (cur != '}') o.put(parseStr(), parseAny); fetchNonSpace_?; o }
      case '[' => { val a = J.Array.Mutable();  while (cur != ']') a += parseAny; fetchNonSpace_?; a }
      case c   => parseStr(c.toInt)

    parseAny match
      case v: J.Object => Result(v)
      case v: J.Array  => Result(v)
      case _           => "Must start with [ or {".Problem
  }

  def format(oe: Json.Object | Array): String =
    def fAny(v: Any): String = v match
      case s: String =>
        "\"" + s.char_~.map({
          case '"' => "\\\""
          case '\\' => "\\\\"
          case '/' => "\\/"
          case '\b' => "\\b"
          case '\f' => "\\f"
          case '\n' => "\\n"
          case '\r' => "\\r"
          case '\t' => "\\t"
          case c if ((c >= '\u0000' && c <= '\u001f') || (c >= '\u007f' && c <= '\u009f')) => "\\u%04x".format(c.toInt)
          case c => c
        }).makeString() + "\""
      case o: J.Object => "{" + o.pair_~.map((k,v) => fAny(k) + " : " + fAny(v)).makeString(", ") + "}"
      case a: J.Array  => "[" + a.~.map(fAny).makeString(", ") + "]"
      case v           => v.toString
    fAny(oe)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
