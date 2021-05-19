package scalqa; package `val`; package stream; package z; package build; package extend; import language.implicitConversions

class joinAll[A](p1: ~[A], p2: ~[A]) extends ~[A] with Custom.Pipeline.Tree with custom.Discharge[A] with Able.Size.Opt.Long:
  private var v = true
  @tn("read_Opt")     def read_?                    = if(v) p1.read_? or_? {v = false; p2.read_?}    else p2.read_?
  @tn("sizeLong_Opt") def sizeLong_?                = if(v) p1.sizeLong_?.mix(p2.sizeLong_?, _ + _ ) else p2.sizeLong_?
  override            def infoTree                  = Self.Doc.Tree(this.doc, Custom.Pipeline.infoTree(p1), Custom.Pipeline.infoTree(p2))
  override            def dischargeTo(b: Buffer[A]) = { if(v) b.addAll(p1); b.addAll(p2) }

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
