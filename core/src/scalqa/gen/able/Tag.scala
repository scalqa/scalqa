package scalqa; package gen; package able

trait Tag:
  /**/     def tag      : String
  override def toString : String = tag

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait Tag -> Explicit tag

   This type will be recognized by Any.Def.Tag, as the main way for toString conversion

@def tag -> String tag

   [[tag]] substitutes [[toString]]

*/
