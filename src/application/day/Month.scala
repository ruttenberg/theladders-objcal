package application.day

import theLadders.{Printer, Printable}

class Month (val theMonth: Int) extends Printable
{
  override def toString() =
  {
    theMonth.toString()
  }
}

