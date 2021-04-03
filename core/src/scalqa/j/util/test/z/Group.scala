package scalqa; package j; package util; package test; package z; import language.implicitConversions

private[j] class Group(test: Test):
  private var children : ><[Group | Method]  = \/

  val name =
    def get(s: String): String = s.takeAfterLast(".").replace("$", "").?.dropOnly("Main") or get(s.takeBeforeLast("."))
    test.name.^.? or get(test.getClass.getName)

  def add(v : Group | Method) = children += v

  @tn("run_Result") def run_??(lvl: Int): Result[true] =
    var first          = true
    def prn(v: String) = { System.out.print(v); System.out.flush }
    def prnFirst       = if(first) { first = false; prn("  " * lvl + " " + name + "\n") }

    children.~.map[Result[true]]{
      case v: Group =>
        prnFirst
        v.run_?? (lvl + 1)
      case m: Method =>
        if(first && m.name.isEmpty)
          first = false
          prn(("  " * lvl + " ." + name + " ").padEndTo(60))
        else
          prnFirst
          prn(("  " * lvl + "   ." + m.name + " ").padEndTo(60))
        test.resetCounters
        m.run_??.^(r => prn(r.problem_?.map("FAILED: " + _.message).or("Ok") + "\n"))
    }
    .take(_.isProblem).read_? or Result(true)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
