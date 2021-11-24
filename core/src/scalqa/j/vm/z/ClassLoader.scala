package scalqa; package j; package vm; package z; import language.implicitConversions

object ClassLoader:

  def reload(className: String, ps : Stream[J.Path]): Class[_] = new ClassLoader {
    val paths = ps.pack
    override def loadClass(cn: String): Class[_] = {
      if (!cn.startsWith(className)) return super.loadClass(cn)
      val name = cn.replace(".", "/") + ".class"
      val file = paths.stream.mapOpt(v => (v + name).fileOpt).findOpt(_.exists) or (J.illegalState("Not found " + name + " in: \n" + paths.stream.makeString("\n")))
      //("Loading: " + file).TP
      val ba = new Array[Byte](file.size.toInt)
      val s  = new java.io.DataInputStream(new java.io.FileInputStream(file.real))
      s.readFully(ba);
      s.close
      defineClass(cn, ba, 0, ba.length)
    }
  }.loadClass(className)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
