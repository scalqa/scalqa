package scalqa; package gen; package event; package store; import language.implicitConversions

abstract class _events:
  self : Store =>

  def onEvent0             (typ: AnyRef, f: () => Any)            : Event.Control = setupEvent(typ,f)
  def onEvent1[P1]         (typ: AnyRef, f: (P1) => Any)          : Event.Control = setupEvent(typ,f)
  def onEvent2[P1,P2]      (typ: AnyRef, f: (P1,P2) => Any)       : Event.Control = setupEvent(typ,f)
  def onEvent3[P1,P2,P3]   (typ: AnyRef, f: (P1,P2,P3) => Any)    : Event.Control = setupEvent(typ,f)
  def onEvent4[P1,P2,P3,P4](typ: AnyRef, f: (P1,P2,P3,P4) => Any) : Event.Control = setupEvent(typ,f)

  def fireEvent0[U]          (typ:AnyRef)                         : Int = {var c=0; var e=get(typ); while(!e.isVoid){val f=e.value.cast[()=>U];             if(f!=null) try{f();           c+=1} catch{case Event.CancelRequest=>e.cancel}; e=e.next}; if(c>1000) fail(typ,c); c}
  def fireEvent1[P1]         (typ:AnyRef, p1:P1)                  : Int = {var c=0; var e=get(typ); while(!e.isVoid){val f=e.value.cast[(P1)=>Any];         if(f!=null) try{f(p1);         c+=1} catch{case Event.CancelRequest=>e.cancel}; e=e.next}; if(c>1000) fail(typ,c); c}
  def fireEvent2[P1,P2]      (typ:AnyRef, p1:P1,p2:P2)            : Int = {var c=0; var e=get(typ); while(!e.isVoid){val f=e.value.cast[(P1,P2)=>Any];      if(f!=null) try{f(p1,p2);      c+=1} catch{case Event.CancelRequest=>e.cancel}; e=e.next}; if(c>1000) fail(typ,c); c}
  def fireEvent3[P1,P2,P3]   (typ:AnyRef, p1:P1,p2:P2,p3:P3)      : Int = {var c=0; var e=get(typ); while(!e.isVoid){val f=e.value.cast[(P1,P2,P3)=>Any];   if(f!=null) try{f(p1,p2,p3);   c+=1} catch{case Event.CancelRequest=>e.cancel}; e=e.next}; if(c>1000) fail(typ,c); c}
  def fireEvent4[P1,P2,P3,P4](typ:AnyRef, p1:P1,p2:P2,p3:P3,p4:P4): Int = {var c=0; var e=get(typ); while(!e.isVoid){val f=e.value.cast[(P1,P2,P3,P4)=>Any];if(f!=null) try{f(p1,p2,p3,p4);c+=1} catch{case Event.CancelRequest=>e.cancel}; e=e.next}; if(c>1000) fail(typ,c); c}

  def setupEvent(typ:AnyRef,v:AnyRef): Event.Control =
    v match
       case v: Event.Id.Cancel =>
          val id=v.id; var e=get(typ);
          while(!e.isVoid){ e.value match { case v: Event.Id if id == v.id => e.cancel; case _ => () }; e=e.next};
          VOID
       case v => add(typ,v)

  // ---------------------------------------------------------------------
  private[event] def fail(typ: AnyRef, c: Int) : Nothing = J.illegalState("Too many " +c + " " + typ)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
