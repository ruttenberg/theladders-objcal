package application.day

import java.util.{Date, GregorianCalendar, Calendar}

class Today extends Day
{
  val calendar: Calendar = new GregorianCalendar()
  calendar.setTime(new Date())
  val theYear: Year = new Year(calendar.get(Calendar.YEAR))
  val theMonth: Month = new Month(calendar.get(Calendar.MONTH) + 1)
  val theDayOfMonth: DayOfMonth = new DayOfMonth(calendar.get(Calendar.DAY_OF_MONTH))

  override def toString() =
  {
    theYear.theYear.toString() + "/" + theMonth.theMonth.toString() + "/" + theDayOfMonth.theDayOfMonth.toString()
  }
}
