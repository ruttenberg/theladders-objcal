package application.day

import theLadders.{Printer, Printable}

trait Day extends Printable
{
  val theYear: Year
  val theMonth: Month
  val theDayOfMonth: DayOfMonth

  override def equals(other: Any) =
  {
    val that = other.asInstanceOf[Day]
    if (that == null) false
    else
      that.theYear.theYear == theYear.theYear && that.theMonth.theMonth == theMonth.theMonth  &&
        that.theDayOfMonth.theDayOfMonth == theDayOfMonth.theDayOfMonth
  }

  override def print(aPrinter: Printer) =
  {
    aPrinter.printList(List(theYear, theMonth, theDayOfMonth), "/")
  }
}
