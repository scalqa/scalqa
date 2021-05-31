package scalqa; package release

object Merge:

  def main(sa: Array[String]): Unit =
    "------------------------------------------------------------------".tp
    if(sa.length == 0) J.illegalArgument("No project root passed")

    val p     = J.Path(sa(0))
    val isDoc = p.lastName == "docs"
    val root  = if(isDoc) p.parent.parent.parent else p.parent.parent

    root.tp
    isDoc.tp

    val to = root + "project"+ "release" + "scalqa" + "src"
    to.delete
    to.make

    root.tp
    to.tp
    to.names.~.tp

    ~~(root + "core" + "src" + "scalqa", root + "fx" + "src" + "scalqa")
      .flatMap(_.childRecursive_~)
      .take(acceptable)
      .map_?(_.file_?)
      .foreach(f => {
        val dest = to + f.path.takeAfter("src")
        print(dest)

        var txt  = f.readString
        if(isDoc) txt = precompile.Code(txt)

        dest.parent.make
        dest.file.writeString(txt)
        println()
     })

  private def acceptable(v: J.Path) =  v.contains("scalqa","root.scala") || v.contains("ZZ.java") || v.contains("scalqa","lang") || v.contains("scalqa","gen")
                              || v.contains("scalqa","val") || v.contains("scalqa","j") || v.contains("scalqa","fx")

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
