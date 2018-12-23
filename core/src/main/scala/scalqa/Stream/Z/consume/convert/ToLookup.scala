package scalqa; package Stream; package Z; package consume; package convert

private[Stream] object ToLookup {

  @inline final def apply[A, KEY, VAL](src: Flow[A])(implicit ev: A <:< (KEY, VAL)): Lookup[KEY, VAL] = {

    val v = Lookup.M.make[KEY, VAL]

    src.asInstanceOf[Flow[(KEY, VAL)]].foreachSynchronized(t => v.put(t._1, t._2))

    v
  }

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
