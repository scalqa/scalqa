package scalqa; package docs; import language.implicitConversions

object Main:

  def main(sa: Array[String]): Unit =
    println("-------------------------------------------------------")

    J.Path("C:","#DM","_sbt","doc").make

    val a : Array[String] = Array(
       "-d",               "C:\\#DM\\_sbt\\doc",
       "-project",         "Scalqa",
                           "-source-links:github://scalqa/scalqa",
       "-revision",        "master",
       "-project-version", "0.995",
       "-siteroot",        "C:\\#DM\\_sbt\\dev\\scalqa_org\\project\\release\\docs\\static",
       "C:\\#DM\\_sbt\\dev\\scalqa_org\\project\\release\\scalqa\\target\\scala-3\\classes"
        )

    dotty.tools.dottydoc.Main.process(a)

    println("-------------------------------------------------------")
