package scalqa; package String; package Z; package Text

private[String] object allTokenized {

  def apply(text: String, allTags: ~[String]): ~[(String, Int.Range, String)] =
    allTags.
      flatMap(tag => text.allIndexesOf(tag).zipMap(_ => tag))
      .sortBy(_._1)
      .zipNext
      .map(_.to((c, no) => (c._2, c._1 + c._2.length <>> no.map(_._1).or(text.length))))
      .map(t => (t._1, t._2, text.copy(t._2)))
      .iterator.I.to(i => i.previewOpt.map(t => t._2.start - t._1.length).let(_ > 0).map(0 <>> _).map(r => ("", r, text.copy(r)) ~~ i).or(i.all))
      .default(("", text.length.Range, text))

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
