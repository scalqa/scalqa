package scalqa; package Stream; package Z; package consume; package convert

private[Stream] object ToLookup {

  @inline def apply[KEY, A](src: Flow[A], f: Mapping[A, KEY]): scalqa.Lookup[KEY, A] = Lookup.M.make[KEY, A].I(l => src.foreachSynchronized(v => l.put(f(v), v)))

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
