package application.day

import theLadders.{Printer, Printable}

class DayOfMonth (val theDayOfMonth: Int) extends Printable
{
  override def toString() =
  {
    theDayOfMonth.toString()
  }
}

