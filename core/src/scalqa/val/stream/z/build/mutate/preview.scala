package scalqa; package `val`; package stream; package z; package build; package mutate; import language.implicitConversions

import java.util.ArrayDeque

class preview[A](src: ~[A]) extends a.Pipe[A](src) with ~~.Preview[A] with Able.Size.Opt:
  self =>
  private var stack : ArrayDeque[A] = ArrayDeque(J.initSize)
  private var allIn : Boolean       = false
  // ---------------------------------------------------------------------------------------------------------------------------
  private                   def preload(cnt: Int)         : Int              = src.size_?.map(_ + stack.size) or (if (stack.size >= cnt) stack.size else load(cnt))
  private                   def load(cnt: Int)            : Int              = { while (!allIn && stack.size < cnt) { src.read_?.forval(stack.add(_)).fornil({ allIn = true }) }; stack.size }
  override                  def doc                      : Doc             = super.doc += ("buffered", stack.size)
  // ---------------------------------------------------------------------------------------------------------------------------
  @tn("read_Opt")           def read_?                    : Opt[A]           = if (!stack.isEmpty) stack.pop else src.read_?
  @tn("size_Opt")           def size_?                    : Int.Opt          = src.size_?.map(_ + stack.size)
  @tn("preview_Stream")     def preview_~(cnt: Int)       : ~[A] & Able.Size = if (load(cnt) == 0) \/ else stack.~.read_~(cnt)
  @tn("preview_Opt")        def preview_?                 : Opt[A]           = (load(1) > 0) ? stack.peek
  /**/                      def preview                   : A                = preview_?.get
  @tn("readWhile_Stream")   def readWhile_~(f:A=>Boolean) : ~[A] & Able.Size = stack.~.findPosition_?(!f(_)).map(i => (0 <>> i).~.map(_ => stack.pop).load) or new readWhile_Stream(f)

  // **********************************************************************************************************
  private class readWhile_Stream(f: A => Boolean) extends a.Pipe[A](src) with Able.Size:
    private val s = self.stack.^(s => {
        self.stack = new ArrayDeque[A](J.initSize)
        var o = src.read_?; while (o.nonEmpty) { val v=o.cast[A]; if (f(v)) { s.add(v); o=src.read_?.fornil{allIn=true} } else { stack.add(v); o = \/ }}
    })
    @tn("read_Opt") def read_? = if(s.size>0) s.pop else \/
    /**/            def size   = s.size

  // **********************************************************************************************************
  object previewSize extends Preview.LazySize with Able.Doc:
    def preload(i: Int): Int = self.preload(i)
    def doc           : Doc = Doc(this) += size_?.map(v=>("size",v.tag)) += ("buffered",stack.size)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
