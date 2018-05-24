package scalqa; package Pro; package The

class Opt[A](srcOpt: => scalqa.Opt[A], dfltValue: A) extends Pro[A] {

  def apply = srcOpt or dfltValue

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
