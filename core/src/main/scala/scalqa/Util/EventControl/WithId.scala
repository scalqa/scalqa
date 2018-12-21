package scalqa; package Util; package EventControl

trait WithId {

  def id: Any

  def isCancel = false

  override def toString = "EventControl.Id" + (this match {
    case f: (() => Any) => "0"
    case f: ((_) => Any) => "1"
    case f: ((_, _) => Any) => "2"
    case f: ((_, _, _) => Any) => "3"
    case f: ((_, _, _, _) => Any) => "4"
    case _ => "?"
  }) + '(' + id + (if (isCancel) ", cancel" else "") + ')'
}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait WithId -> `Event with Id`
 *
 *    Most events in Scalqa are lazily cancelled through EventControl
 *
 *    However it is also possible to use traditional listener subscription model
 *
 *    To do so we have to create [[EventControl]] with some id when subscribing, and
 *    send cancellation [[EventControl]] with the same id to remove the subscription
 *
 *    {{{
 *      val pro: Pro.O[DayTime] = DayTime.currentPro(1.Second) // observable time changes every second
 *
 *      // anonymous subscription
 *      val cc1 = pro.onValueChange( v => "Old: "+ v lp)  //
 *
 *      // id based subscription
 *      val listenerId = new AnyRef // Can be anything if equal only to itself
 *
 *      val cc2 = pro.onValueChange(EventControl.id1[DayTime](listenerId, v => "New:" + v lp))
 *
 *      App.runIn(3.Seconds, {
 *        "removing event by id".lp
 *         pro.onValueChange(EventControl.cancelId1(listenerId))
 *      })
 *
 *      cc2.onCancelRun(() => { "id based  subscription cancelled".lp; cc1.cancel})
 *      cc1.onCancelRun(() => { "anonymous subscription cancelled".lp; App.exit})
 *
 *      // Output
 *      New: 14:01:39.157
 *      Old: 14:01:39.157
 *      New: 14:01:40.027
 *      Old: 14:01:40.027
 *      New: 14:01:41.026
 *      Old: 14:01:41.026
 *      removing event by id
 *      id based  subscription cancelled
 *      anonymous subscription cancelled
 *      App.exit requested
 *    }}}
 */
