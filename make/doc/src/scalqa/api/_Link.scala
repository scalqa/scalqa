package scalqa; package api

trait _Link:

  extension (x: Link)
    def tag           : String      = "Link(name:"+x.name+", id=" + x.dri.memberId +")"

