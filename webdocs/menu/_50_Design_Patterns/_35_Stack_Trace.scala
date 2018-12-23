package Design_Patterns

/**
 *   Normal Scalqa code produces huge stack traces, more than half of which is [[scalqa.Stream Stream]] processing
 *
 *   There is nothing wrong with this, as long as performance does not suffer
 *
 *   However, extra effort should always be expanded to make the stack traces as readable as possible
 *
 *   The naming choices below allow to see relations between code and stack trace
 *   {{{
 *
 *     package MyPackage; import scalqa._
 *
 *     object MyApp extends App {
 *
 *       (0 <> 10).all
 *         .peek(_ => ())
 *         .map(v => v)
 *         .let(_ => true)
 *         .flatMap(v => 0 <> v)
 *         .foreach(_ => App.Fail())
 *     }
 *
 *     // Output
 *     Exception in thread "main" Fail\$NoMessage
 *         at MyPackage.ObjectTest\$.MyPackage\$ObjectTest\$\$\$anonfun\$new\$5(ObjectTest.scala:10)
 *         at MyPackage.ObjectTest\$\$anonfun\$5.accept\$mcI\$sp(ObjectTest.scala:10)
 *         at scalqa.Idx.Range.Z.stream\$\$anon\$1.foreach(stream.scala:9)
 *         at scalqa.Stream.Z.extend.map.flatMap\$primPrim\$33\$\$anon\$33.accept\$mcI\$sp(flatMap.scala:10)
 *         at scalqa.Stream.Z.extend.filter.let\$\$anon\$5\$\$anon\$13.accept\$mcI\$sp(let.scala:16)
 *         at scalqa.Stream.Z.extend.map.map\$primPrim\$33\$\$anon\$33.accept\$mcI\$sp(map.scala:9)
 *         at scalqa.Stream.Z.extend.peek.peek\$\$anon\$5\$\$anon\$13.accept\$mcI\$sp(peek.scala:13)
 *         at scalqa.Idx.Range.Z.stream\$\$anon\$1.foreach(stream.scala:9)
 *         at scalqa.Stream.Z.extend.peek.peek\$\$anon\$5.foreach(peek.scala:13)
 *         at scalqa.Stream.Z.extend.map.map\$primPrim\$33.foreach(map.scala:9)
 *         at scalqa.Stream.Z.extend.filter.let\$\$anon\$5.foreach(let.scala:16)
 *         at scalqa.Stream.Z.extend.map.flatMap\$primPrim\$33.foreach(flatMap.scala:10)
 *         at MyPackage.ObjectTest\$.delayedEndpoint\$MyPackage\$ObjectTest\$1(ObjectTest.scala:10)
 *         at MyPackage.ObjectTest\$delayedInit\$body.apply(ObjectTest.scala:3)
 *         at scalqa.App._Class.main(_Class.scala:17)
 *         at MyPackage.ObjectTest.main(ObjectTest.scala)
 *   }}}
 */
class Stack_Trace { val sort_35 = () }
