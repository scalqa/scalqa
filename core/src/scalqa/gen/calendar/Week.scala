package scalqa; package gen; package calendar; import language.implicitConversions

import Calendar.Week

object Week extends Int.Custom.Data.Sequential[Week]("Calendar.Week"):
  inline   def byIndex(epochWeek: Int): Week   = epochWeek.asOpaque[Week]
  /**/     def apply()                : Week   = Gen.Day().week
  override def tag(v: Week)           : String = "Week-" + v.startDay.tag

  extension (x: Week)
    def index     : Int          = x.real
    def start     : Time         = x.startDay.start
    def startDay  : Calendar.Day = Calendar.Day.byIndex(x.real * 7)
    def year      : Year         = x.startDay.year
    def month     : Month        = x.startDay.month
    def isCurrent : Boolean      = Calendar.Week() == x
    def period    : Period       = Period(x.start, x.next.start)

  object opaque:
    opaque type `type` <: Opaque.Int = Opaque.Int

  // *******************************************************************************************************************

  enum Day:
    case Mon, Tue, Wed, Thu, Fri, Sat, Sun

    def isWeekend = isSun || isSat
    def isWorkday = !isWeekend
    def isSun = this eq Day.Sun
    def isMon = this eq Day.Mon
    def isTue = this eq Day.Tue
    def isWed = this eq Day.Wed
    def isThu = this eq Day.Thu
    def isFri = this eq Day.Fri
    def isSat = this eq Day.Sat

  object Day extends Any.Enum.Companion[Day]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object opaque -> ### Calendar Week

    [[Week]] is an opaque Int value, holding week index since start of 1970

*/
