package scalqa; package gen; package event; package store; package z; import language.implicitConversions

import java.util.concurrent.atomic.AtomicReference

private[scalqa] class Entry(chld: Entry, val `type`: Ref, protected[z] var cargo: Any) extends AtomicReference[Entry](chld) with Trigger with store.Entry with scalqa.gen.event.Control:
  def isVoid                  : Boolean          = false
  def isCancelled             : Boolean          = cargo == null
  def child                   : Entry            = { val e = get; if (e.cargo != null) e else { val c = e.child; if (compareAndSet(e, c)) c else child }}
  def next                    : Entry            = child.find(`type`)
  def next_?                  : Opt[Store.Entry] = child.find(`type`).?.drop(_.isVoid)
  def find(typ: Ref)          : Entry            = { var e = this; while (e.nonVoid && (typ != e.`type` || e.cargo == null)) e = e.child; e }
  def cancel                  : Boolean          = if (isCancelled) false else { var b = false; var v = cargo; synchronized{if(!isCancelled){ b=true; cargo=null}}; if (b) fire(v); b}
  def cancelIf(b: ()=>Boolean): this.type        = { if (!isCancelled) synchronized { cargo = Trigger.CancelIf(this, cargo, b)}; this }
  def onCancel[U](l: () => U) : this.type        = { if (!isCancelled) synchronized { cargo = Trigger.OnCancel(cargo, l);     }; this }
  def removeHardReference     : Ref              = if (isCancelled) null else synchronized { cargo.cast[Ref].^(r => cargo = Trigger.WeakRef(this,r)) }
  def doc                     : Doc              = Doc("Entry") += ("type", `type`.^.id ) += ("value", value.?.takeType[Event.Id].map(_.tag) or value.^.id ) ++= (isCancelled ? (("", "isCancelled")))

  private def fire(v: Any)    : Unit             = v match { case v: Trigger.OnCancel => v.code(); fire(v.cargo); case v: Trigger => fire(v.cargo); case _ => () }

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
