package scalqa; package Custom; package String; package Z

private[String] object isLike {

  // Needs redoing
  def apply(string: String, mask: String, ignoreCase: Boolean): Boolean = {
    if (string == null) return false
    if (string.length == 0 || mask == null || mask.length == 0) return true
    var maskFrom = 0; var maskTo = 0; var stringFrom = 0;
    maskTo = mask.indexOf('%');
    if (maskTo == -1) return if (ignoreCase) mask.equalsIgnoreCase(string) else mask.equals(string)
    if (maskTo > 0 && !mask.regionMatches(0, string, 0, maskTo)) return false;
    stringFrom = maskTo
    while (maskTo >= 0) {
      maskFrom = maskTo + 1;
      if (maskFrom >= mask.length) return true;
      maskTo = mask.indexOf('%', maskFrom);
      if (maskTo >= 0) {
        stringFrom = string.indexOf(mask.copy(maskFrom <>> maskTo), stringFrom)
        if (stringFrom == -1) return false;
        stringFrom += maskTo - maskFrom;
      }
    }
    mask.length - maskFrom <= string.length - stringFrom && string.endsWith(mask.copyFrom(maskFrom))
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
