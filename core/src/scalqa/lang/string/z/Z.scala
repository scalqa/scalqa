package scalqa; package lang; package string; import language.implicitConversions

object Z:

  // copy
  def takeBefore(    x:String, v:String, d:Opt[String], s:Int.Opt): String         = x.indexOfOpt    (v, s).map(i => x.substring(0, i))                   orOpt d or x
  def takeBeforeLast(x:String, v:String, d:Opt[String], s:Int.Opt): String         = x.lastIndexOfOpt(v, s).map(i => x.substring(0, i))                   orOpt d or x
  def takeFrom      (x:String, v:String, d:Opt[String], s:Int.Opt): String         = x.indexOfOpt    (v, s).map(i => x.substring(i))                      orOpt d or x
  def takeFromLast  (x:String, v:String, d:Opt[String], s:Int.Opt): String         = x.lastIndexOfOpt(v, s).map(i => x.substring(i))                      orOpt d or x
  def takeAfter     (x:String, v:String, d:Opt[String], s:Int.Opt): String         = x.indexOfOpt    (v, s).map(i => x.substring(i + v.length, x.length)) orOpt d or x
  def takeAfterLast (x:String, v:String, d:Opt[String], s:Int.Opt): String         = x.lastIndexOfOpt(v, s).map(i => x.substring(i + v.length, x.length)) orOpt d or x

  // evaluate
  def joinAll[A](x: String, v: Stream[A])(using d: Any.Def.Tag[A])     : String         = v.map(d.value_tag).foldAs(x)(_ + _)
  def charAtOpt       (x:String, i: Int)                         : Char.Opt       = if (i < 0 || i >= x.length) \/ else x.charAt(i)
  def indexOfOpt      (x:String, v: String, s: Int.Opt)          : Int.Opt        = x.indexOf(v, s or 0).?.take(_ >= 0)
  def indexOf_Stream   (x:String, v: String, s: Int.Opt)          : Int.Stream     = x.indexOfOpt(v, s).map(i => Int.Stream(i) ++ x.indexOfStream(v, i + v.length)) or \/
  def lastIndexOfOpt  (x:String, v: String, s: Int.Opt)          : Int.Opt        = x.lastIndexOf(v, s or x.length).?.take(_ >= 0)
  def charIndexOpt    (x:String, f: Char => Boolean, s: Int.Opt) : Int.Opt        = { var i = s or 0; while (i < x.length) { if (f(x.charAt(i))) return i; i += 1 }; \/ }
  def lastCharIndexOpt(x:String, f: Char => Boolean, s: Int.Opt) : Int.Opt        = { var i = s or x.length - 1; while (i >= 0) { if (f(x.charAt(i))) return i; i -= 1 }; \/ }

  // modify
  def padStartTo(x:String, sz: Int, pad: String)                  : String         = { var v = x; while (v.length < sz) v = pad + v; v }
  def padEndTo  (x:String, sz: Int, pad: String)                  : String         = { var v = x; while (v.length < sz) v += pad; v }
  def label     (x:String)                                        : String         = x.charStream.zipPrior.map(t => if (t._2.isLetter && !t._1.drop(_.isWhitespace)) t._2.toUpper else t._2).makeString("")
  def replace   (x:String, r: Int.Range, v: String)               : String         = (x.takeFirst(r.start) + v + x.dropFirst(r.endX))
  def insertAt  (x:String, i: Int, v: String)                     : String         = (x.takeFirst(i) + v + x.dropFirst(i))
  def trimStart (x:String, f: Char => Boolean)                    : String         = x.charIndexOpt(!f(_)).map(x.dropFirst(_)) or ""
  def trimEnd   (x:String, f: Char => Boolean)                    : String         = x.lastCharIndexOpt(!f(_)).map(_ + 1).map(x.takeFirst(_)) or ""
  def trimBoth  (x:String, f: Char => Boolean)                    : String         = x.trimStart(f).trimEnd(f)

  // transform
  def char_Stream     (x:String)                                  : Char.Stream    = z.CharStream(x)
  def split_Stream    (x:String, sep: Char, more: Seq[Char])      : Stream[String] = if(more.size==0) x.split(sep).stream else x.split(more.prepended(sep).toArray).stream
  def line_Stream     (x:String)                                  : Stream[String] = z.LineStream(x)
  def toDoubleOpt    (x:String)                                  : Double.Opt     = try{x.toDouble } catch{ case _ => \/}
  def toDoubleResult (x:String)                                  : Result[Double] = try{x.toDouble } catch{ case v:Throwable => Result.Problem(v) }
  def toIntOpt       (x:String)                                  : Int.Opt        = try{x.toInt    } catch{ case _ => \/}
  def toIntResult    (x:String)                                  : Result[Int]    = try{x.toInt    } catch{ case v:Throwable => Result.Problem(v) }
  def toLongOpt      (x:String)                                  : Long.Opt       = try{x.toLong   } catch{ case _ => \/}
  def toLongResult   (x:String)                                  : Result[Long]   = try{x.toLong   } catch{ case v:Throwable => Result.Problem(v) }
  def toBooleanOpt   (x:String)                                  : Boolean.Opt    = try{x.toBoolean} catch{ case _ => \/}
  def toBooleanResult(x:String)                                  : Result[Boolean]= try{x.toBoolean} catch{ case v:Throwable => Result.Problem(v) }
  def nonEmptyOpt    (x:String)                                  : Opt[String]    = if (x != null && x.trim.length > 0) x else \/
  def indent          (x:String, tag: String)                     : String         = if (tag == null || tag.length == 0) x else { val sep = "\n" + " " * tag.length; tag + x.lineStream.makeString(sep)}

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
