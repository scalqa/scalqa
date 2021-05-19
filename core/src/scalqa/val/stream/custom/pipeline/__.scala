package scalqa; package `val`; package stream; package custom; import language.implicitConversions

trait Pipeline extends Pipeline.Tree:
  protected def base     : Ref
  /**/      def infoTree : Self.Doc.Tree = Self.Doc.Tree.apply(doc, base.?.takeType[Pipeline.Tree].map(_.infoTree) or Self.Doc.Tree(Able.Doc.doc_?(base) or z.util.MultiDoc(base)))

object Pipeline:
  def infoTree[A](v: Pipeline.Tree | ~[A] | Flow[A]) : Self.Doc.Tree = v match
    case v: Tree    => v.infoTree
    case v: ~[_]    => Self.Doc.Tree(z.util.MultiDoc(v))
    case v: Flow[_] => Self.Doc.Tree(z.util.MultiDoc(v))

  private[stream] def baseDoc_?(v: Pipeline): Opt[Self.Doc] = Able.Doc.doc_?(v.base) // needed by z.util.MultiDoc only

  // ************************************************************************************************************
  trait Tree extends gen.able.Doc :
    def infoTree : Self.Doc.Tree
    def doc     : Self.Doc= z.util.MultiDoc(this)

  // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  type ParallelFlow[A] = pipeline.ParallelFlow[A]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait Pipeline -> ###

   Custom Pipeline is the base for most Scalqa internal stream extentions

   It is publicly exposed for only vary advanced usage cases and can be safely ignored by most
*/