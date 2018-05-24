package scalqa

package object App {

  def exit = { Print.ln("App.exit requested"); System.exit(0) }

  def localHost = new J.Ip.Address(java.net.InetAddress.getLocalHost)

  def availableProcessors = Runtime.getRuntime().availableProcessors()

  def reload(className: String, allPaths: ~[J.File.Directory]): java.lang.Class[_] = new ClassLoader {
    val paths = allPaths.as[Index]
    override def loadClass(cn: String): java.lang.Class[_] = {
      if (!cn.startsWith(className)) return super.loadClass(cn)
      val name = cn.replace(".", "/") + ".class"
      val file = paths.all.map(_.path + name file).findOpt(_.exists) or Fail("Not found " + name + " in: \n" + paths.all.format("\n"))
      //Print.ls("Loading: " + file)
      new Array.Raw[Byte](file.size.toInt).I.to(ba => {
        new java.io.DataInputStream(new java.io.FileInputStream(file.real)).I.to(s => { s.readFully(ba); s.close })
        defineClass(cn, ba, 0, ba.length)
      })
    }
  }.loadClass(className)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
