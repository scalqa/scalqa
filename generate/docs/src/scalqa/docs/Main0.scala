package scalqa; package docs; import language.implicitConversions

object Main0:

  def main(sa: Array[String]): Unit =
    println("-------------------------------------------------------")

    J.Path("C:","#DM","_sbt","docs").make

    val a : Array[String] = Array(
       "-d",               "C:\\#DM\\_sbt\\docs",
       "-project",         "Scalqa",
                           "-source-links:github://scalqa/scalqa",
       "-revision",        "33b710a",
       "-project-version", "0.98",
       "-siteroot",        "C:\\#DM\\_sbt\\dev\\scalqa\\generate\\docs\\static",
//       "-project-logo",    "scala3doc/documentation/logo.svg",
//                           "-external-mappings:.*scala.*::scala3doc::http://dotty.epfl.ch/api/,.*java.*::javadoc::https://docs.oracle.com/javase/8/docs/api/",
       "C:\\#DM\\_sbt\\dev\\scalqa\\core\\target\\scala-3.0.0-RC3\\classes")

    dotty.tools.dottydoc.Main.process(a)

    println("-------------------------------------------------------")
