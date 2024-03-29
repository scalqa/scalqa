package scalqa; package `val`; package lookup; package stable; package z; import language.implicitConversions

object Void extends Stable[Any,Any] with Gen.Void:
  type THIS_TYPE = Stable[Any,Any]
  def getOpt(key: Any)            : Opt[Any]         =VOID
  def pairStream                  : Stream[(Any,Any)]=VOID
  def size                        : Int               = 0
  def join(k: Any, v: Any)        : Stable[Any,Any]   = Stable((k,v))
  def joinAll(v:Stream[(Any,Any)]): Stable[Any,Any]   = Stable(v)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
