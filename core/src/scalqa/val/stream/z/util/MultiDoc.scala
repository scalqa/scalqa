package scalqa; package `val`; package stream; package z; package util; import language.implicitConversions

class MultiDoc private(target: AnyRef/* expected Custom.Pipeline | ~[_] | Flow[_]*/, v: \/) extends Doc(target.^.id):
  def this(v: AnyRef) =
    this(v,\/)
    v.?.takeType[custom.pipeline.ParallelFlow[_]].map(_.name).dropVoid.forval(v => this.id = this.id.replaceLast("@", "." + v + "@"))

    if(id.lower.contains("stream").not) this += "Stream"

    lang.any.z.PrimitiveTag.?(v).forval(name => {
      this +=  ("raw",name)
      this ++= v.?.takeType[Custom.Pipeline].map_?(Custom.Pipeline.baseDoc_?).map_?(_.~.find_?(_._1 == "raw").map(_._2)).drop(_ == name).map(n => ("fromRaw",n))
    })

    this ++= v.?.map_?(Able.Size.sizeLong_?).map(s => ("size", s.toString))


/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
