package scalqa; package `val`; package range

object Z:

  class EndInclsive[A] (val start:A, val end:A)(using val ordering:Ordering[A]) extends AnyRef.G.Range.X.Abstract[A]{ def endIsIn = true }
  class EndExclusive[A](val start:A, val end:A)(using val ordering:Ordering[A]) extends AnyRef.G.Range.X.Abstract[A]{ def endIsIn = false}
  class SingleValueInclusive[A](val start:A)   (using val ordering:Ordering[A]) extends AnyRef.G.Range.X.Abstract[A]{ def endIsIn = true;  def end = start; override def contains(v:A) = start.equals(v)}
  class SingleValueExclusive[A](val start:A)   (using val ordering:Ordering[A]) extends AnyRef.G.Range.X.Abstract[A]{ def endIsIn = false; def end = start; override def contains(v:A) = false          }

  // **********************************************************************************************************************
  class Void[A](using val ordering: Ordering[A]) extends AnyRef.G.Range.X.Abstract[A] with Gen.Void:
    override def start                   : A       = J.unsupportedOperation("Void range does not have a start")
    override def end                     : A       = J.unsupportedOperation("Void range does not have an end")
    override def endIsIn                 : Boolean = false
    override def contains(a: A)          : Boolean = false
    override def contains(that: Range[A]): Boolean = false

  // **********************************************************************************************************************
  class DocDef[A: Any.Def.Tag] extends Any.Def.Doc[Range[A]] with Any.Def.Tag[Range[A]] :
    def value_tag(v: Range[A]) : String   = String.Builder(20).self(b => { b += v.start += " <>"; if(!v.endIsIn) b += ">"; b += " " += v.end }).tag
    def value_doc(v: Range[A]) : Doc      = Doc(v) += ("start", v.start) += (if(v.endIsIn) "endIn" else "endX", v.end)
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
