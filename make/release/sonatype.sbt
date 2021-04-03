
sonatypeProfileName := "org.scalqa"

licenses   := Seq("APL2" -> url("http://www.apache.org/licenses/LICENSE-2.0.txt"))
homepage   := Some(url("https://github.com/scalqa/scalqa"))
scmInfo    := Some(ScmInfo(url("https://github.com/scalqa/scalqa"),"scm:git@github.com:scalqa/scalqa.git"))
developers := List( Developer(id="edolgy", name="Evgeny Dolgy", email="evgeny.dolgy@gmail.com", url=url("https://github.com/edolgy")))

credentials += Credentials("Sonatype Nexus Repository Manager", "oss.sonatype.org", "edolgy", "0XsX2NP%5pMf")