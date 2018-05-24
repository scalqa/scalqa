package scalqa; package J

package object Url {

  def get(v: java.net.URL) = new Url(v)

  def get(v: String): Url = try { new java.net.URL(v) } catch { case e: java.net.MalformedURLException => Fail(e.getMessage) }

  //
  //    public static J.Url byHostPort(String host, int port) {
  //      try {
  //        return new J.Url(new URL("http://" + host + ":" + port));
  //      } catch (MalformedURLException e) {
  //        throw new J.E(e);
  //      }
  //    }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
