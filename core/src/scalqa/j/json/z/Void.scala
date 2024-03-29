package scalqa; package j; package json; package z; import language.implicitConversions

private[json] object Void:

  object Object extends Json.Object with Gen.Void:
    def pairStream=VOID
    def getOpt(key: String): Opt[Any]=VOID
    def size = 0

  object Array extends Array with Gen.Void:
    def size = 0
    def apply(i: Int) = J.illegalState("Requesting element '" + i + "' on empty Array")

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
