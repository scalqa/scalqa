package scalqa; package lang; package any; package _methods; import language.implicitConversions

import _Methods.Self

object Z:

  class TagDef[A](using t:Any.Def.Tag[A]) extends Any.Def.Tag[Self[A]]:
    def value_tag(v: Self[A]) = t.value_tag(v.cast[A])

  class DocDef[A](using d:Any.Def.Doc[A]) extends Any.Def.Doc[Self[A]]:
    def value_tag(v: Self[A]) = value_doc(v).tag
    def value_doc(v: Self[A]) = d.value_doc(v.cast[A])

  def refName(v: Any): String = if(v == null) "null" else
    val s = v.getClass.getName.replace(".__", "").replace("$__", "")
    val sa = s.split('.')
    if (sa.length >= 2 && sa.last == sa(sa.length - 2)) sa.array.dropRight(1).mkString(".")
    else s.takeAfter("java.lang.")

  // ********************************************************************************************
  object Hash:
    private val Alphabet  = "0123456789abcdefghijkmnopqrstuvwxyz"
    private val One       = Alphabet.length
    private val Two       = One   * One
    private val Three     = Two   * One
    private val Four      = Three * One

    def apply(i: Int) : String =
      val j  = i.abs
      val c1 = Alphabet.charAt(j % Four  / Three)
      val c2 = Alphabet.charAt(j % Three / Two)
      val c3 = Alphabet.charAt(j % Two   / One)
      val c4 = Alphabet.charAt(j % One)
      if(i >= 0) "" + c1 + c2 + c3 + c4
      else       "" + c4 + c3 + c2 + c1

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
