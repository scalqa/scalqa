package scalqa; package J; package Path; package Z

private[Path] object indexOf {

  def opt(main: Path, p: Path): Opt[Int] = if (main.isEmpty) \/ else if (p.isEmpty) 0 else {
    var i, j = 0
    while (i < main.size) {
      if (main(i) != p(j))
        j == 0
      else {
        j += 1
        if (j == p.size) return i - j + 1
      }
      i += 1
    }
    \/
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/