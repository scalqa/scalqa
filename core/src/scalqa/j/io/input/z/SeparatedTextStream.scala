package scalqa; package j; package io; package input; package z; import language.implicitConversions

class SeparatedTextStream(real: Input.Text, separator: Char => Boolean) extends ~[Char.Idx & CharSequence]:
  var open = true
  var from, to, end = 0
  val char = new Chars()

  @tn("read_Opt") def read_? = has ? { char.start = from; char.end = to; from = to; char }

  private def has : Boolean = from < to || open && {
    def locate: Boolean =
      while (to < end)
        if (separator(char.array(to)))
          if (to == from) from += 1 else return true
        to += 1
      false
    // -----------------------------------------------------------------------------------
    if (locate) return true
    if (from > 0)
      char.array.copyTo(char.array, 0, from, end - from)
      end -= from
      to -= from
      from = 0
    var i = real.read(char.array, end <>> char.array.length)
    while (i >= 0)
      end += i
      if (locate) return true
      if (end == char.array.length) char.grow
      i = real.read(char.array, end <>> char.array.length)
    open = false
    return from < to
  }

private class Chars() extends Chars.Abstract with Char.Idx with CharSequence:
  var array = new Array[Char](256)
  var start = 0;
  var end = array.length
  def grow = array = array.copySize(array.length * 2)

private object Chars:

  abstract class Abstract extends Val.Idx[Char] with CharSequence {
    protected def array: Array[Char]
    protected def start: Int
    protected def end: Int

    def apply(i: Int) = array(i + start)
    def charAt(i: Int) = array(i + start)

    def size = end - start
    def length = end - start

    def range: Int.<> = start <>> end

    def subSequence(from: Int, until: Int): CharSequence = new Abstract {
      def array = Abstract.this.array
      def start = Abstract.this.start + from
      def end   = Abstract.this.start + until
    }

    def toString(r: Int.<>) = new String(array, start + r.start, r.size)

    override def toString = new String(array, start, size)
  }

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
