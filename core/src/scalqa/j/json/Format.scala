package scalqa; package j; package json; import language.implicitConversions

trait Format:
  @tn("parse_Result") def parse_??(s: String)             : Result[J.Object | J.Array]
  /**/                def format  (o: J.Object | J.Array) : String

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
