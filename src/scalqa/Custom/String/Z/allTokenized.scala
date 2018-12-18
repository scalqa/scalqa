package scalqa; package Custom; package String; package Z

private[String] object allTokenized {

  def apply(text: String, allTags: ~[String]): ~[(String, Idx.Range, String)] = {

    val b = allTags.
      flatMap(tag => text.allIndexesOf(tag).zipMap(_ => tag))
      .sortBy(_._1)
      .zipNext
      .map(_.to((c, no) => (c._2, c._1 + c._2.length <>> no.map(_._1).or(text.length))))
      .map(t => (t._1, t._2, text.copy(t._2)))
      .preview

    b.previewNextOpt.map(t => t._2.start - t._1.length).let(_ > 0).map(0 <>> _).map(r => ("", r, text.copy(r)).I.~ +~ b).or(b).default(("", text.length.Range, text))
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
