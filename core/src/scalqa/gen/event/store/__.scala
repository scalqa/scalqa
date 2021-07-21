package scalqa; package gen; package event; import store.*; import language.implicitConversions

class Store extends _events with _entries with _activation with _properties:
  private         val cRef               : J.Concurrent.Ref[z.Entry] = J.Concurrent.Ref(z.Void)
  private[event]  def top                : z.Entry                   = { val e=cRef.get; if(!e.isCancelled) e else cRef.reset(_.child,e) }
  private[scalqa] def get(typ: Ref)      : z.Entry                   = top.find(typ)
  /**/            def add(typ:Ref, v:Any): Event.Control             = cRef.reset(e => new z.Entry(e,typ,v))

object Store:
  type _activation  = store._activation
  type _entries     = store._entries
  type _events      = store._events
  type _properties  = store._properties
  type Entry        = store.Entry
  type Provider     = store.Provider

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@class Store -> ###

    [[Event.Store]] is a shared linked list container for keeping primarily [[scalqa.gen.event.store._events _events]] definitions.

    But it also can store/access any generic objects through [[scalqa.gen.event.store._entries _entries]] interface.

    [[Event.Store]] has an idea of 'id' space or scope.  Entries are added with specific 'id' and can only be accessible if this 'id' is provided.
    So, different types of entries defined in curent or extending types can share a single store instance.

    The removal of entries is lazy after an [[Entry]] method 'cancel' is invoked. Though events do provide direct removal as well.

*/