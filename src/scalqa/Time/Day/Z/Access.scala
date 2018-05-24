package scalqa; package Time; package Day; package Z

private[Day] object Access {
  private var lookup = new Lookup(0, Array.get[Data](0))

  def day(i: Int): Data = lookup(i)

  // ****************************************************************************************************************************************
  class Data(localDate: java.time.LocalDate) {

    val year = Year.get(localDate.getYear)

    val month = Month.get(localDate.getYear, localDate.getMonthValue)

    val number = localDate.getDayOfMonth

    val start = Time.getByMillis(localDate.atStartOfDay(Zone.Id).toInstant.toEpochMilli)

  }

  // ****************************************************************************************************************************************
  private class Lookup(offset: Int, array: Array[Data]) { // no need to synchronize

    def apply(i: Int): Data = {
      if (i < offset) {
        lookup = new Lookup(i, array.createArray(array.size + offset - i).I(array.copyToArray(_, offset - i)))
        return day(i)
      }
      var j = i - offset
      if (j >= array.size) {
        lookup = if (array.size == 0) { new Lookup(i - 50, Array.get[Data](App.Pro.DefaultBufferSize())) } else { new Lookup(offset, array.ensureCapacity(j + 10)) }
        return day(i)
      }
      array(j) ? (_ == null, _ => new Data(java.time.LocalDate.ofEpochDay(i)).I(array(j) = _))
    }
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/