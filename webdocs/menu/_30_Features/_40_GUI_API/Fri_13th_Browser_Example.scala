package Features.GUI_API
/**
 * Calendar browsing example
 *
 * There are two tables:
 *
 *   - First lists centuries from 1 to 21th
 *   - Second lists all Fri the 13th days, for the selected centuries
 *
 * This is a runnable Java class
 *
 * {{{
 *   import scalqa._
 *   import Fx._
 *
 *   object Fri13ThExplorer extends Application("Fri the 13th Explorer") {
 *
 *     val centuries = new Table[Int] {                                       // Century Table Definition
 *       new Column[String]("Centuries", 100, _.toString + " Century")
 *
 *       items +~= 1 <> 21                                                    // Setting centuries Range[Int]
 *                                                                            //    from 1st to 21st
 *       sortMode = \/                                                        // Disallow sorting
 *
 *       selection.mode = Selection.Mode.Multiple                             // Allow multi selection
 *
 *       selection.onChangeRun {                                              // On change, re-build days
 *         days.items.clear
 *         days.ordering = \/                                                 // order could be re-set by user
 *         val future = Fx.Thread.future(
 *           selection.all                                                    // Stream of selected centuries
 *             .map(_ * 100).flatMap(v => v - 100 <<> v).map(_.Year)          // Stream[Year]
 *             .flatMap(_.days).let(_.number == 13).let(_.weekDay.isFri)      // Stream[Day]
 *             .toBuffer,                                                     // Eager buffering
 *           Popup.make("Calculating Calendar...", 250.Millis, scene.window)) // Optional message with delay
 *
 *         future.apply(days.items.replaceAll)                                // replace with Stream[Day]
 *       }
 *     }
 *
 *     val days = new Table[Day] {                                            // Days Table Definition
 *       new Column[Int]("Year", 50, _.year.number)
 *       new Column[Int]("Month", 70, _.month.number)
 *       new Column[String]("Day", 70, d => d.weekDay.toString + ", " + d.number)
 *     }
 *
 *     scene = new Scene(400, 600, new Pane.Split {                           // Creating UI
 *       orientation = HORIZONTAL
 *       add(centuries, 40.Percent)
 *       add(days)
 *     })
 *   }
 * }}}
 */
class Fri_13th_Browser_Example {}
