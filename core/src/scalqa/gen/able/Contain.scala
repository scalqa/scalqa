package scalqa; package gen; package able

trait Contain[A]:

  def contains(v: A): Boolean

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait Contain -> Able to contain elements

@def contains -> Check if contains

    Returns true if given element is contained by the implementing container

*/