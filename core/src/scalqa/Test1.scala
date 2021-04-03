package scalqa; import language.implicitConversions

object Test1:

  def main(sa: Array[String]): Unit =
    "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAsAAAAAAA".tp
//
//    run(Pack(J.Path("C:", "#DM", "_sbt", "scalqa", "src", "main", "scala", "scalqa")))
//
//  def run(src: ~[J.Path]): Unit =
//     val l =  src
//      .flatMap(_.childRecursive_~)
//      .map_?(_.file_?)
//      .map(f => f.path.toString.replace("C:\\#DM\\_sbt\\scalqa\\src\\main\\scala\\","").replace("\\",".").replace(".scala",""))
//      .drop(_.endsWith(".__"))
//      .peek(println)
//      .iterator.toList
//
//      new DBInspector().inspect("",l)
//
//
//class DBInspector extends TastyInspector {
//
//  protected def processCompilationUnit(reflect: tasty.Reflection)(root: reflect.Tree): Unit = {
//  //protected def processCompilationUnit(using Quotes)(root: Ref): Unit = {
////    import qctx.reflect.*
////    object Traverser extends TreeTraverser {
////
////      override def traverseTree(tree: Tree)(implicit ctx: Context): Unit = tree match {
////        case tree: Definition =>
////          println(tree.showExtractors)
////          super.traverseTree(tree)
////        case tree =>
////          super.traverseTree(tree)
////      }
////
////    }
////    Traverser.traverseTree(root)
//    println(root.toString.length)
//  }
//}
//
//class Foo {
//  val foo: Int = 2
//  def bar(i: Int): Int = 3
//}