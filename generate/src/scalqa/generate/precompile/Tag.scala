package scalqa; package generate; package precompile; import language.implicitConversions

class Tag(val id: String, val index: Int, t: String) extends Able.Doc:
  val text   : String    = { val v = convertTags(t.trim); if (v.endsWith("*/")) v.dropLast(2) else v }
  def doc   : Doc      = Doc(this) += ("id", id) += ("index", index) += ("text", text.takeBefore("\n"))

  def insertInto(program: String): String =
    var txt = program
    def findPos(start:Int): Int = {var i=txt.indexOf(id,start); while(i>0 && txt.charAt_?(i+id.length).drop(c => Tag.endChars.contains(c))) i=findPos(i+id.length); i}
    var pos = findPos(0)
    for(j <- 0 <>> index) pos = findPos(pos+id.length)
    if (pos < 0) { System.out.println("\tCould not find tag: '" + id + {if(index==0) "" else "' occurrence " + (index+1)}); return txt }
    // -------------------------------------------------------------------------------
    var lineStart : Int    = txt.lastIndexOf('\n', pos) + 1
    val codeStart : Int    = txt.charIndex_?(!_.isSpaceChar, lineStart).get
    val startSpace: String = txt.take_<>(lineStart <>> codeStart)
    if(txt.take_<>(lineStart <>> pos).contains(";"))
      lineStart = txt.lastIndexOf(";",pos)+2
      txt = txt.takeFirst(lineStart-1)+"\n"+startSpace+txt.dropFirst(lineStart-1).trimStart
    else if(txt.take_<>(codeStart <>= 4 ) == "/**/")
      txt = txt.drop_<>(codeStart <>> txt.charIndex_?(!_.isSpaceChar, codeStart+4).get)
    txt = txt.insertAt(lineStart, startSpace + "/**" + lineStream.map(v => "\n" + startSpace + "* " + v).makeString(" ") + "\n" + startSpace + "*/\n")
    txt

  def lineStream: ~[String] =
    val off = text.line_~.dropFirst(1).drop(_.trim.length==0).map(v => v.length - v.trimStart.length).min_? or 0
    var b = true
    text.line_~.map(v => if(b){b=false; v.trim} else if(v.length > off) v.dropFirst(off) else v)

  // Certain methods are not desired in comments, so they are entered as special tags
  private def convertTags(v: String) : String =
    var s = v.replace("?_?_?","?"+'?'+'?')
    var i = s.indexOf("TP",0)
    while(i>=0)
      if(i>0 && !Character.isAlphabetic(v.charAt(i-1)) && i+2<v.length && !Character.isAlphabetic(v.charAt(i+2))) s = s.takeFirst(i)+'t'+'p'+s.dropFirst(i+2)
      i = s.indexOf("TP",i+2)
    s

object Tag:
  val Ids = ><("object", "trait", "class", "def", "val", "var", "type")

  private val endChars : Char.>< = Char.><(' ', '(', '[', ':', '=', '\t')

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/