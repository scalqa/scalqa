package scalqa; package gen; package able

import lang.any.self.{ Doc as DOC }

trait Doc extends Tag:
  def tag : String  = doc.tag
  def doc : DOC

object Doc:
  @tn("doc_Opt") def doc_?(v: Any): Opt[DOC] = v match{ case v: Doc => v.doc; case _ => \/ }

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait Doc -> ###

Allows any object to provide self description


@def doc -> Doc

   Returns [[scalqa.gen.Doc Doc]] object, loaded with property names and values describing this instance

@def tag -> To String

   [[tag]] returns this instance String representation, which should be used insted of [[toString]]

*/
