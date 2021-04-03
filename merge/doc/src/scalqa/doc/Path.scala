package scalqa; package doc

object Path:

  def apply(x: String): String =
    var s = x
    if(!s.startsWith("..") && !s.endsWith("/index") && !s.endsWith("/scalqa")){
      var i = x.lastIndexOf("/")
      if(i>0)
        val c = s.charAt(i+1)
        if(Character.isAlphabetic(c) && Character.isLowerCase(c))  s = s + "_"
    }
    s