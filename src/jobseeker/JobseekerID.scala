package jobseeker

import theLadders.{Identity, Printer, Printable}

class JobseekerID (val theIdentity: Identity) extends Printable
{
  override def print(aPrinter: Printer) =
  {
    theIdentity.print(aPrinter)
  }

  override def toString() =
  {
    theIdentity.toString()
  }

  override def equals(other: Any) =
  {
    val that = other.asInstanceOf[JobseekerID]
    if (that == null) false
    else
      that.theIdentity == theIdentity
  }
}
