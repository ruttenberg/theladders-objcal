package jobseeker

import theLadders.{Printer, Printable}
import resume.Resumes

class PersonalInfo (theName: String) extends Printable
{
  val theResumes: Resumes = new Resumes

  override def print(aPrinter: Printer) =
  {
    aPrinter.printItem(this)
  }

  override def toString =
  {
    theName.toString
  }
}
