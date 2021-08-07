package scalqa; package gen; package able

trait Doc extends Tag:
  def tag : String   = doc.tag
  def doc : Gen.Doc

object Doc:
  @tn("doc_Opt") def doc_?(v: Any): Opt[Gen.Doc] = v match{ case v: Able.Doc => v.doc; case _ => \/ }

  // ***************************************************************************************************************************************
  trait Product extends Doc:
    self: scala.Product =>

    /**/     def doc     : Gen.Doc = Gen.Doc(self).^(d => for(i <- 0 <>> productArity) d += (productElementName(i), productElement(i).toString))

    override def toString: String  = String.Builder().^(_ += productPrefix += "(" += doc.value_~.makeString(",") += ")").tag

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

@def tag -> Make String

   [[tag]] returns this instance String representation, which should be used insted of [[toString]]

*/
