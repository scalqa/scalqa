package scalqa; package lang; package string; import language.implicitConversions

object Z:

  // copy
  def takeBefore(    x:String, v:String, d:Opt[String], s:Int.Opt): String         = x.indexOf_?    (v, s).map(i => x.substring(0, i))                   or_? d or x
  def takeBeforeLast(x:String, v:String, d:Opt[String], s:Int.Opt): String         = x.lastIndexOf_?(v, s).map(i => x.substring(0, i))                   or_? d or x
  def takeFrom      (x:String, v:String, d:Opt[String], s:Int.Opt): String         = x.indexOf_?    (v, s).map(i => x.substring(i))                      or_? d or x
  def takeFromLast  (x:String, v:String, d:Opt[String], s:Int.Opt): String         = x.lastIndexOf_?(v, s).map(i => x.substring(i))                      or_? d or x
  def takeAfter     (x:String, v:String, d:Opt[String], s:Int.Opt): String         = x.indexOf_?    (v, s).map(i => x.substring(i + v.length, x.length)) or_? d or x
  def takeAfterLast (x:String, v:String, d:Opt[String], s:Int.Opt): String         = x.lastIndexOf_?(v, s).map(i => x.substring(i + v.length, x.length)) or_? d or x

  // evaluate
  def joinAll[A](x: String, v: ~[A])(using d: Any.Def.Doc[A])     : String         = v.map(d.value_tag).foldAs(x)(_ + _)
  def charAt_Opt       (x:String, i: Int)                         : Char.Opt       = if (i < 0 || i >= x.length) \/ else x.charAt(i)
  def indexOf_Opt      (x:String, v: String, s: Int.Opt)          : Int.Opt        = x.indexOf(v, s or 0).?.take(_ >= 0)
  def indexOf_Stream   (x:String, v: String, s: Int.Opt)          : ~[Int]         = x.indexOf_?(v, s).map(i => ~~(i) ++ x.indexOf_~(v, i + v.length)) or \/
  def lastIndexOf_Opt  (x:String, v: String, s: Int.Opt)          : Int.Opt        = x.lastIndexOf(v, s or x.length).?.take(_ >= 0)
  def charIndex_Opt    (x:String, f: Char => Boolean, s: Int.Opt) : Int.Opt        = { var i = s or 0; while (i < x.length) { if (f(x.charAt(i))) return i; i += 1 }; \/ }
  def lastCharIndex_Opt(x:String, f: Char => Boolean, s: Int.Opt) : Int.Opt        = { var i = s or x.length - 1; while (i >= 0) { if (f(x.charAt(i))) return i; i -= 1 }; \/ }

  // modify
  def padStartTo(x:String, sz: Int, pad: String)                  : String         = { var v = x; while (v.length < sz) v = pad + v; v }
  def padEndTo  (x:String, sz: Int, pad: String)                  : String         = { var v = x; while (v.length < sz) v += pad; v }
  def label     (x:String)                                        : String         = x.char_~.zipPrior.map(t => if (t._2.isLetter && !t._1.drop(_.isWhitespace)) t._2.toUpper else t._2).makeString()
  def replace   (x:String, r: Int.<>, v: String)                  : String         = (x.takeFirst(r.start) + v + x.dropFirst(r.endX))
  def insertAt  (x:String, i: Int, v: String)                     : String         = (x.takeFirst(i) + v + x.dropFirst(i))
  def trimStart (x:String, f: Char => Boolean)                    : String         = x.charIndex_?(!f(_)).map(x.dropFirst(_)) or ""
  def trimEnd   (x:String, f: Char => Boolean)                    : String         = x.lastCharIndex_?(!f(_)).map(_ + 1).map(x.takeFirst(_)) or ""
  def trimBoth  (x:String, f: Char => Boolean)                    : String         = x.trimStart(f).trimEnd(f)

  // transform
  def char_Stream     (x:String)                                  : Char.~         = z.CharStream(x)
  def split_Stream    (x:String, sep: Char, more: Seq[Char])      : ~[String]      = if(more.size==0) x.split(sep).~ else x.split(more.prepended(sep).toArray).~
  def line_Stream     (x:String)                                  : ~[String]      = z.LineStream(x)
  def toDouble_Opt    (x:String)                                  : Double.Opt     = try{x.toDouble } catch{ case _ => \/}
  def toDouble_Result (x:String)                                  : Result[Double] = try{x.toDouble } catch{ case v:Throwable => Result.Problem(v) }
  def toInt_Opt       (x:String)                                  : Int.Opt        = try{x.toInt    } catch{ case _ => \/}
  def toInt_Result    (x:String)                                  : Result[Int]    = try{x.toInt    } catch{ case v:Throwable => Result.Problem(v) }
  def toLong_Opt      (x:String)                                  : Long.Opt       = try{x.toLong   } catch{ case _ => \/}
  def toLong_Result   (x:String)                                  : Result[Long]   = try{x.toLong   } catch{ case v:Throwable => Result.Problem(v) }
  def toBoolean_Opt   (x:String)                                  : Boolean.Opt    = try{x.toBoolean} catch{ case _ => \/}
  def toBoolean_Result(x:String)                                  : Result[Boolean]= try{x.toBoolean} catch{ case v:Throwable => Result.Problem(v) }
  def nonEmpty_Opt    (x:String)                                  : Opt[String]    = if (x != null && x.trim.length > 0) x else \/
  def indent          (x:String, tag: String)                     : String         = if (tag == null || tag.length == 0) x else { val sep = "\n" + " " * tag.length; tag + x.line_~.makeString(sep)}

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
