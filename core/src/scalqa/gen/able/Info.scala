package scalqa; package gen; package able

import `def`.any.self.{ Info as INFO }

trait Info extends Tag:
  def tag  : String  = info.tag
  def info : INFO

object Info:
  @tn("doc_Opt") def doc_?(v: Any): Opt[INFO] = v match{ case v: Info => v.info; case _ => \/ }

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait Info -> ###

Allows any object to provide self description


@def info -> Info

   Returns [[scalqa.gen.Info Info]] object, loaded with property names and values describing this instance

@def tag -> To String

   [[tag]] returns this instance String representation, which should be used insted of [[toString]]

*/
