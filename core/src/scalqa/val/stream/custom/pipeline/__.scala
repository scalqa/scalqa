package scalqa; package `val`; package stream; package custom; import language.implicitConversions

trait Pipeline extends Pipeline.Tree:
  protected def base     : Ref
  /**/      def infoTree : Info.Tree = Info.Tree.apply(info, base.?.takeType[Pipeline.Tree].map(_.infoTree) or Info.Tree(Able.Info.doc_?(base) or z.util.MultiDoc(base)))

object Pipeline:
  def infoTree[A](v: Pipeline.Tree | ~[A] | Flow[A]) : Info.Tree = v match
    case v: Tree    => v.infoTree
    case v: ~[_]    => Info.Tree(z.util.MultiDoc(v))
    case v: Flow[_] => Info.Tree(z.util.MultiDoc(v))

  private[stream] def baseDoc_?(v: Pipeline): Opt[Info] = Able.Info.doc_?(v.base) // needed by z.util.MultiDoc only

  // ************************************************************************************************************
  trait Tree extends gen.able.Info :
    def infoTree : Info.Tree
    def info     : Info     = z.util.MultiDoc(this)

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