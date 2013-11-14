package resume

import jobseeker.JobseekerID
import theLadders.{Printer, Printable}

class ResumeID (val theResumeName: ResumeName, val theJobseekerID: JobseekerID) extends Printable
{
  override def print(aPrinter: Printer) =
  {
    theResumeName.print(aPrinter)
  }
  def matches(aJobseekerID: JobseekerID) =
  {
    aJobseekerID == theJobseekerID
  }
}
