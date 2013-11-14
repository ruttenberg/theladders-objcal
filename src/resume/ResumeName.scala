package resume

import theLadders.{Printable, Printer}

class ResumeName (val theResumeName: String) extends Printable
{
  override def print(aPrinter: Printer) =
  {
    aPrinter.printItem(this)
  }

  override def toString() =
  {
    theResumeName.toString()
  }
}
