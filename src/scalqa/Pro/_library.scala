package scalqa; package Pro

class _library[A] private[Pro] (protected val This: Pro[A]) extends AnyVal with Z.LibraryBase[A] {

  def asO(p: ~[Any.O]): O[A] = p.nonEmptyOpt.map(all => new O.Z.The.Multi.Dependent(This, p)) orElse asO

  def asO: O[A] = new O.Z.The.NoEventsWrap[A](This())

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
