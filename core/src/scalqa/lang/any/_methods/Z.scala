package scalqa; package lang; package any; package _methods; import language.implicitConversions

object Z:

  def kind(v: Any): String = if(v == null) "null" else
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
      var s = if(i >= 0) "" + c1 + c2 + c3 + c4 else "" + c4 + c3 + c2 + c1
      while(s.charAt(0) == '0' && s.length > 1) s = s.substring(1)
      s

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
