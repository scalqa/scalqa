package scalqa; package j; import language.implicitConversions

object Json:
  type Format = json.Format
  type Array  = json.Array;   inline def Array  = json.Array
  type Object = json.Object;  inline def Object = json.Object

  def format(v: Object | Array)   : String                 = Vm.Setup.jsonFormatPro().format(v)
  def parseResult(s: String)      : Result[Object | Array] = Vm.Setup.jsonFormatPro().parseResult(s)
  def parseObjectResult(s: String): Result[Object]         = parseResult(s).mapResult{ case v: Object => v; case v: Array  => Result.Problem("Not a JSON Object")}
  def parseArrayResult(s: String) : Result[Array]          = parseResult(s).mapResult{ case v: Array  => v; case v: Object => Result.Problem("Not a JSON Array" )}

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object Json -> ### JavaScript Object Notation Framework

   Note [[scalqa.j.json.Object J.Object]] and [[scalqa.j.json.Array J.Array]] can be called without [[.Json.]] prefix

*/