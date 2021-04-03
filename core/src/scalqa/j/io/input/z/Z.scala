package scalqa; package j; package io; package input; import language.implicitConversions

object Z:

  class CharStream(r: java.io.Reader) extends Char.~ :

    @tn("readRaw_Opt") def readRaw_? =
      var o: Char.Opt = \/
      val v = r.read
      if(v >= 0) o = v.Char
      o

  object Void extends java.io.InputStream with Void:
    def read = -1

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
