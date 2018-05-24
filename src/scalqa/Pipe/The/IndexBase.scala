package scalqa; package Pipe; package The

abstract class IndexBase[A](originalSize: Int) extends Base[A] with Index[A] with Iterator[A] with Able.Copy.ToArray[A] {
  private var start = 0
  private var end = originalSize

  // --- Index -------------------------------------------------------------
  final def apply(i: Int) = _apply(start + i): @inline

  final override def size = end - start max 0; override def sizeOpt = size

  // --- Iterator ----------------------------------------------------------
  def nextFindOpt(f: A => Boolean) = pumpOpt(f)

  // --- Pipe --------------------------------------------------------------
  override def pumpOpt(lf: A => Boolean): Opt[A] = { while (start < end) { val v = _apply(start); start += 1; if (lf(v)) return v }; \/ }

  override def letFirst(cnt: Int): Pipe[A] = { if (cnt > 0) end = start + cnt min end else end = start; this }

  override def letAt(r: Int.Range): Pipe[A] = { dropFirst(r.start); letFirst(r.size) }

  override def letLast(cnt: Int): Pipe[A] = { if (cnt <= 0) end = start else start = start max end - cnt; this }

  override def dropFirst(cnt: Int): Pipe[A] = { if (cnt > 0) start = start + cnt min end; this }

  override def dropLast(cnt: Int): Pipe[A] = { if (cnt >= 0) end = end - cnt max start; this }

  override def previewOpt = this.opt(start)

  override def buffer: Pipe[A] = this

  override def reverse: Pipe[A] = size.I.to(sz => { object reversed extends IndexBase[A](sz) { def _apply(i: Int) = IndexBase.this.apply(sz - 1 - i) }; reversed })

  // -----------------------------------------------------------------------
  final override def copyToArray[B >: A](dest: Array[B], destPos: Int = 0, range: Opt[Int.Range] = \/): Unit = _copyToArray(dest.cast, destPos, range.map(_ >> start) or 0 <>> size)

  protected def _copyToArray(dest: Array[A], destPos: Int, range: Int.Range): Unit = {
    var i = range.start
    val to = range.end
    val off = destPos - i;
    while (i < to) { dest(i + off) = _apply(i); i += 1 }
  }

  final def copyToArray[B >: A](dest: Array[B], destPos: Int): Unit = { val off = destPos - start; while (start < end) { dest(start + off) = _apply(start); start += 1 } }

  override def info = super.info ~~ _isProjected.opt(("projected", _range)) ~~ _isProjected.opt(("originalSize", originalSize))

  protected def _apply(i: Int): A

  protected def _range = start <>> end

  protected def _isProjected = size != originalSize
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @class IndexBase -> '''The Index Base Pipe'''
 */
