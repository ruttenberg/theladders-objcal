package resume

import theLadders.{Printable, Printer}
import jobseeker.Jobseeker

class Resume (val theResumeID: ResumeID, val theResumeContent: ResumeContent) extends Printable
{
  override def print(aPrinter: Printer) =
  {
    theResumeID.print(aPrinter)
  }

  def matches(aJobseeker: Jobseeker) : Boolean =
  {
    aJobseeker.matches(theResumeID)
  }
}
