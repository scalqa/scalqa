package scalqa; package children; package z; import language.implicitConversions

class RootData(m: Member) extends Data(m):

  members = all.stream.takeValuesBy(_.name,("Lang","Gen","J","Fx","Val")).pack
  aliases = { members.stream.dropValuesBy(_.name,("J","Fx")).flatMap(_.members) ++ Registry.memberOpt(Id("scalqa.gen.Request$")).get.members}.sort.pack
