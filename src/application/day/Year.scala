package application.day

import theLadders.Printable

class Year (val theYear: Int) extends Printable
{
  override def toString() =
  {
    theYear.toString()
  }
}

