package scalqa; package gen; package calendar; import language.implicitConversions

import Calendar.Week

object Week extends Int.Opaque.Data.Sequential[Week]("Calendar.Week"):
  /**/     inline def fromIndex(epochWeek: Int) : Week         = epochWeek.toOpaque
  /**/            def current                   : Week         = Calendar.Day.current.week
  override        def value_tag(v: Week)        : String       = "Week-" + v.startDay.tag

  implicit inline def implicitRequest(v:CURRENT): Week         = current

  extension (x: Week)
    def startDay   : Gen.Day     = Calendar.Day.fromIndex(x.real * 7 - 4)
    def start      : Time        = x.startDay.start
    def index      : Int         = x.real
    def isCurrent  : Boolean     = x == Calendar.Week.current
    def period     : Period      = Period(x.start, x.next.start)
    def days       : Gen.Day.Idx = new Gen.Day.Idx{ private val sd=x.startDay; val size=7; def apply(i:Int)=sd+i }

  object TYPE:
    opaque type DEF <: Int.Opaque = Int.Opaque

  // *******************************************************************************************************************
  enum Day:
    case Mon, Tue, Wed, Thu, Fri, Sat, Sun

  object Day extends EnumCompanion[Day]:
    extension (inline x: Day)
      inline def isWeekend = {val v=x; v.isSun || v.isSat}
      inline def isWorkday = !x.isWeekend
      inline def isSun = x eq Day.Sun
      inline def isMon = x eq Day.Mon
      inline def isTue = x eq Day.Tue
      inline def isWed = x eq Day.Wed
      inline def isThu = x eq Day.Thu
      inline def isFri = x eq Day.Fri
      inline def isSat = x eq Day.Sat

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@type DEF  -> ### Calendar Week

    [[Week]] is an opaque Int value, holding week index since start of 1970

*/
