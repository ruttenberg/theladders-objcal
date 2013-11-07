package jobseeker

import theLadders.{Identity, Printer, Printable}

class JobseekerID (theIdentity: Identity) extends Printable
{
  override def print(aPrinter: Printer) =
  {
    theIdentity.print(aPrinter)
  }

  override def toString() =
  {
    theIdentity.toString()
  }
}
