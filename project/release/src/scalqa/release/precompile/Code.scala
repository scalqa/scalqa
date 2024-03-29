package scalqa; package release; package precompile; import language.implicitConversions

object Code:

  def apply(code: String): String =

    val l: Pack[(String,Int.Range,String)] = code.tokenizedStream(Tag.Ids.stream.map("@" + _ + " ")).pack


    if(l.size == 0)
      code.tp

    var txt = l.head._3.trim
    if(txt.endsWith("/**")) txt = txt.dropLast(3)

    val tags: Pack[Tag] =
      val iMap : Lookup.M[String,Int] =  Lookup.M()

      l.stream.dropFirst(1).map(v => {
          val (t, r, str) = v
          val j = str.indexOf(" ->");
          if (j > 0) print(".") else J.illegalState("Tag end ' ->' not found : '" + t + "' in: \n" + "=" * 75 + "\n" + str + "\n" + "=" * 75 + "\n")
          val id = t.dropFirst(1) + str.takeFirst(j).trimEnd
          val i = iMap.getOpt(id).forval(i => iMap.put(id,i+1)) or {iMap.put(id,1); 0}
          new Tag(id.replace("\t"," ").replace("  "," "), i, str.dropFirst(j +  3).replace("\\n","\n"))
       }).pack

    txt = tags.stream.foldAs(txt)((s, tg) => tg.insertInto(s))

    txt

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/