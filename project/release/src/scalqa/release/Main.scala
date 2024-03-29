package scalqa; package release

object Merge:

  def main(sa: Array[String]): Unit =
    "------------------------------------------------------------------".tp
    if(sa.length == 0) J.illegalArgument("No project root passed")

    val p     = J.Path(sa(0))
    val root  = if(p.lastName == "docs") p.parent.parent.parent else p.parent.parent

    root.tp

    val to = root + "project"+ "release" + "scalqa" + "src"
    to.delete
    to.make

    root.tp
    to.tp
    to.names.stream.tp

    Stream(root + "core" + "src" + "scalqa", root + "fx" + "src" + "scalqa")
      .flatMap(_.childRecursiveStream)
      .take(acceptable)
      .mapOpt(_.fileOpt)
      .foreach(f => {
        val dest = to + f.path.takeAfter("src")
        print(dest)
        dest.parent.make
        dest.file.writeString(precompile.Code(f.readString))
        //dest.file.writeString(f.readString)
        println()
     })

  private def acceptable(v: J.Path) =  v.contains("scalqa","package.scala") || v.contains("ZZ.java") || v.contains("scalqa","lang") || v.contains("scalqa","gen")
                              || v.contains("scalqa","val") || v.contains("scalqa","j") || v.contains("scalqa","fx")

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
