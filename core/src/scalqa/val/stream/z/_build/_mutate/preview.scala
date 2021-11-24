package scalqa; package `val`; package stream; package z; package _build; package _mutate; import language.implicitConversions

import java.util.ArrayDeque

class preview[A](src: Stream[A]) extends z.x.Pipe[A](src) with Stream.Preview[A] with Able.Size.Opt:
  self =>
  private var stack : ArrayDeque[A] = ArrayDeque(J.initSize)
  private var allIn : Boolean       = false
  // ---------------------------------------------------------------------------------------------------------------------------
  private  def preload(cnt: Int)            : Int                   = src.sizeOpt.map(_ + stack.size) or (if (stack.size >= cnt) stack.size else load(cnt))
  private  def load(cnt: Int)               : Int                   = { while (!allIn && stack.size < cnt) { src.readOpt.forval(stack.add(_)).fornil({ allIn = true }) }; stack.size }
  override def doc                          : Doc                   = super.doc += ("buffered", stack.size)
  // ---------------------------------------------------------------------------------------------------------------------------
  /**/     def readOpt                      : Opt[A]                = if (!stack.isEmpty) stack.pop else src.readOpt
  /**/     def sizeOpt                      : Int.Opt               = src.sizeOpt.map(_ + stack.size)
  /**/     def previewStream(cnt: Int)      : Stream[A] & Able.Size = if (load(cnt) == 0) EMPTY else stack.valStream.readStream(cnt)
  /**/     def previewOpt                   : Opt[A]                = (load(1) > 0) ? stack.peek
  /**/     def preview                      : A                     = previewOpt.get
  /**/     def readWhileStream(f:A=>Boolean): Stream[A] & Able.Size = stack.valStream.findPositionOpt(!f(_)).map(i => (0 <>> i).stream.map(_ => stack.pop).load) or new readWhile_Stream(f)

  // **********************************************************************************************************
  private class readWhile_Stream(f: A => Boolean) extends z.x.Pipe[A](src) with Able.Size:
    private val s = self.stack.self(s => {
        self.stack = new ArrayDeque[A](J.initSize)
        var o = src.readOpt; while (o) { val v=o.cast[A]; if (f(v)) { s.add(v); o=src.readOpt.fornil{allIn=true} } else { stack.add(v); o = \/ }}
    })
    def readOpt = if(s.size>0) s.pop else \/
    /**/            def size   = s.size

  // **********************************************************************************************************
  object previewSize extends Preview.LazySize with Able.Doc:
    def preload(i: Int): Int      = self.preload(i)
    def doc            : Doc      = Doc(this) ++= sizeOpt.map(v=>("size",v.tag)) += ("buffered",stack.size)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
