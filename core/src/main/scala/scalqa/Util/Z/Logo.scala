package scalqa; package Util; package Z

private[scalqa] object Logo extends App {

  val logo =
    "/*___________________________________________________________________________\n" +
      "     __________ ____   __   ______  ____\n" +
      "    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API\n" +
      "  __\\  \\/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation\n" +
      " /_____/\\____/_/  |_/____/\\______/_/  |_|             github.com/scalqa\n" +
      "___________________________________________________________________________*/"

  logo.lp

  //  def replaceLogo(f: J.File): Unit = /*f.readString.I(s =>
  //    s.indexOfOpt("\\  \\/ /___/ __  |/ /__/ /_/ /_/ __  |").
  //      letMap(i => s.lastIndexOfOpt("/*", i)).
  //      letMap(i => s.indexOfOpt("*/", i).map( i <>> _ + 2 )).
  //      map(r => s.update(r, logo)).or(s.trim + '\n' + logo).
  //      I(f.writeString))*/
  //
  //  def allPaths = ~[J.Path] ~
  //    ("C:" ~+ "#DM" + "#wrk" + "sbt" + "scalqa" + "src" + "main" + "scala") ~
  //    ("C:" ~+ "#DM" + "#wrk" + "sbt" + "scalqaFx" + "src" + "main" + "scala")
  /*
    allPaths.
      letMap(_.directoryOpt).
      flatMap(_.allFilesRecursive).
      let(_.extension == "scala").
//      let(_.name == "Logo.scala").
      peek(_ lp).
      peek(replaceLogo).
      count.lp
*/
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
