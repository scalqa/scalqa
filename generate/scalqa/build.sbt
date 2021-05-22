

sonatypeBundleDirectory := (ThisBuild / baseDirectory).value / "generate" / "scalqa" / "sonatype-staging"
publishTo               := sonatypePublishToBundle.value

credentials += Credentials("Sonatype Nexus Repository Manager", "oss.sonatype.org", "edolgy", "0XsX2NP%5pMf")

licenses := Seq("APL2" -> url("http://www.apache.org/licenses/LICENSE-2.0.txt"))

scmInfo := Some( ScmInfo( url("https://github.com/scalqa/scalqa"), "scm:git@github.com:scalqa/scalqa.git"))

homepage := Some(url("http://www.scalqa.org"))

developers := List(Developer(id="edolgy", name="Evgeny Dolgy", email="evgeny.dolgy@gmail.com", url=url("https://github.com/edolgy")))

