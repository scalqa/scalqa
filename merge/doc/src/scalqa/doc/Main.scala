package scalqa; package doc; import language.implicitConversions

object Main:

  def main(sa: Array[String]): Unit =
    "-------------------------------------------------------".tp

    J.Path("C:","#DM","_sbt","doc").make

    val a : Array[String] = Array(
       "-d",               "C:\\#DM\\_sbt\\doc",
       "-project",         "Scalqa",
                           "-source-links:github://lampepfl/dotty",
       "-revision",        "33b710a",
       "-project-version", "0.99",
       "-siteroot",        "C:\\#DM\\_sbt\\dev\\scalqa\\doc",
//       "-project-logo",    "scala3doc/documentation/logo.svg",
//                           "-external-mappings:.*scala.*::scala3doc::http://dotty.epfl.ch/api/,.*java.*::javadoc::https://docs.oracle.com/javase/8/docs/api/",
       "C:\\#DM\\_sbt\\dev\\scalqa\\make\\release\\target\\scala-3.0.0-RC2\\classes")

    dotty.tools.dottydoc.Main.process(a)

    "-------------------------------------------------------".tp
