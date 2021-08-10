package scalqa; package gen; package calendar; package z; import language.implicitConversions

import Day.Setup

object Day extends java.util.concurrent.atomic.AtomicReference[Setup.Lookup](Setup.Lookup()):
  private var currentDay   : Day  = Time.current.day
  private var nextDayStart : Time = new Setup(currentDay.next).start

  def current: Day =
    val t = Time.current
    if (t >= nextDayStart){ currentDay = t.day;  nextDayStart = currentDay.next.start }
    currentDay

  def setup(d: Day): Setup = if (d.isVoid) Setup.Void else
      var l = this.get
      l.get_Opt(d) or {
        while(!compareAndSet(l,l.cloneExtend(d))) l = this.get
        setup(d)
      }

  // ***********************************************************************************
  class Setup(val year: Year, val month: Month, val number: Int, val start: Time):
    def this(d: java.time.LocalDate) = this(Year(d.getYear), Month(d.getYear, d.getMonthValue), d.getDayOfMonth, Time.fromIndex(d.atStartOfDay(Time.Zone.id).toInstant.toEpochMilli))
    def this(d: Day)                 = this(java.time.LocalDate.ofEpochDay(d.real))

  // ***********************************************************************************
  private[z] object Setup:
    object Void extends Setup(\/, \/, 0, \/) with Gen.Void

    // *******************************************************************************************************************
    class Lookup private (array : Array[Array[Setup]], start: Int):
      def this() = this(new Array[Array[Setup]](100), 0)
      private inline val SZ = 1000
      private        val end = start + array.length * SZ

      def get_Opt(d: Day): Opt[Setup] =
        if(d.real < start || d.real >= end) return \/
        var i = d.real - start
        val a = array(i / SZ).^.reviseIf(_ == null, _ => new Array[Setup](SZ).^(array(i / SZ) = _))
        a(i % SZ).^.reviseIf(_ == null, _ => new Setup(d).^(a(i % SZ) = _))

      def cloneExtend(d: Day): Lookup =
        d.real match
                case i if (i < start) => val d = (start - i) / SZ + 1
                                         new Lookup(array.newArray(array.length + d).^(a => array.copyTo(a, d)), start - d * SZ)
                case i if (i >= end)  => val d = (i - end) / SZ + 1
                                         new Lookup(array.newArray(array.length + d).^(a => array.copyTo(a)), start)
                case _                => this // can happen with concurrent access

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
