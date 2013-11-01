package jobseeker

import theLadders.{Printer, Printable}
import resume.Resumes

class PersonalInfo (theName: String) extends Printable
{
  val theResumes: Resumes = new Resumes

  def print(aPrinter: Printer) = {}
}
