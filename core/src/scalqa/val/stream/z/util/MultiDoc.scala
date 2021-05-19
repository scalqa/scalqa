package scalqa; package `val`; package stream; package z; package util; import language.implicitConversions

import Custom.Pipeline

class MultiDoc private(target: Ref/* expected Pipeline | ~[_] | Flow[_]*/, v: \/) extends Self.Doc(target.^.id):
  def this(v: Ref) = {
    this(v,\/)

    v.?.takeType[custom.pipeline.ParallelFlow[_]].map(_.name).dropVoid.forval(v => this.id = this.id.replaceLast("@", "." + v + "@"))

    if(id.lower.contains("stream").not) this += "Stream"

    Raw.Specialized.get_?(v).forval(name => {
      this += ("raw",name)
      this += v.?.takeType[Pipeline].map_?(Pipeline.baseDoc_?).map_?(_.~.find_?(_._1 == "raw").map(_._2)).drop(_ == name).map(n => ("fromRaw",n))
    })

    this += v.?.map_?(Able.Size.sizeLong_?).map(s => ("size", s.toString))
  }

  override def text = target.?.takeType[Custom.Pipeline.Tree].map(Pipeline.infoTree(_).text) or super.text

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
