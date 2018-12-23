package scalqa; package Stream; package Z; package extend; package flow; package preview

private[Stream] object default {

  def apply[@specialized(DATA) A](s: Stream[A]): Stream[A] with Preview[A] = new Stream[A] with Base[A] with Stream.A.Specialized[A] {
    protected var array: Array[A] = null
    @inline protected def real = s
    @inline protected def bufPop = { _strt += 1; array(_strt - 1) }

    private def moveUp = { System.arraycopy(array, _strt, array, 0, bufSize); _end -= bufSize; _strt = 0 }

    def add(v: A) = {
      if (_end < 0) { _strt = 0; _end = 0; array = (s.ilkOpt or v.I.ilk).mkArray[A]() }
      else if (_end == array.length) { if (_strt > 0) moveUp else array = array.copyResize(_end * 2) }
      array(_end) = v;
      _end += 1
    }

    def prime(cnt: Int): Int = if (allIn || bufSize >= cnt) bufSize else {
      if (cnt == Int.MaxValue) { real(add); allIn = true }
      else { while (bufSize < cnt && s.prime) add(s.pump); allIn = !s.prime }
      bufSize
    }

    def preview(cnt: Int) = if (prime(cnt) == 0) \/ else array.all.letAt(_strt <>> (_end min _strt + cnt)).mapType[A]

    def previewNextOpt = (prime(1) > 0).toOpt(array(_strt))

    def takeWhile(f: Filter[A]): Stream[A] = if (prime(1) == 0) \/ else {
      if (_strt > 0) moveUp
      val b = Idx.Array.Buffer.loaded[A](Custom.Array.emptyAs(array, App.initSize), 0)
      while (bufHas && f.allow(array(_strt))) b += bufPop
      if (bufSize == 0 && !allIn) {
        while (bufSize == 0 && s.prime) {
          val v = s.pump
          if (f.allow(v)) b += v
          else add(v)
        }
      }
      b.all
    }
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
