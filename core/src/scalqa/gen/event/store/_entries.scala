package scalqa; package gen; package event; package store; import language.implicitConversions

transparent trait _entries:
  self: Store =>

  def add(typ:AnyRef, v:Any)          : Event.Control
  def findOpt(typ: AnyRef)            : Opt[Entry]    = top.find(typ).?.drop(_.isVoid)
  def stream(typ: AnyRef)             : Stream[Entry] = new z_Stream().TAKE(_.`type` == typ)
  def isEmpty                         : Boolean       = top.isVoid
  def count                           : Int           = new z_Stream().count
  def toText(label: Opt[String] =VOID): String        = new z_Stream().nonEmptyOpt.map(_.zipIndex.makeString("\n")).or("empty").indent((label or "Event.Store")+": ")

  // *******************************************************************
  private class z_Stream extends Stream[Entry]:
    private var e: z.Entry = top
    def readOpt  = !e.isVoid ? { val v=e; e=e.child; v }

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait _entries -> ###


*/