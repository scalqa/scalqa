package scalqa; package j; package file; package path; import language.implicitConversions

object Z:

  def indexOfOpt(main: File.Path, p: File.Path): Int.Opt = if (main.isEmpty) \/ else if (p.isEmpty) 0 else
    var i, j = 0
    val mSz = main.size
    val pSz = p.size
    while (i < mSz)
      if (main.name(i) != p.name(j))
        j == 0
      else
        j += 1
        if (j == pSz) return i - j + 1
      i += 1
    \/

  // ---------------------------------------------------------------------------------

  def join(p: File.Path, a: File.Path | String): File.Path =
    val v = File.Path.any(a)
    if (p.isEmpty) v
    else if (v.root_?) J.illegalState("Cannot extend with root: " + v)
    else p.real.resolve(v.real)

  // **********************************************************************************
  class Names(p: File.Path) extends Val.Idx[String]:
    def apply(i: Int) = p.name(i)
    val size          = p.size

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
