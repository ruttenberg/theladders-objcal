package application

import job.JobID
import jobseeker.{Jobseeker}
import employer.Employer
import theLadders.{Printer, Printable}

class ApplicationID (val theJobID: JobID, val theJobseeker: Jobseeker) extends Printable
{
  def isForThisEmployer(anEmployer: Employer) =
  {
    theJobID.matches(anEmployer)
  }

  def isForThisJob(aJobID: JobID) =
  {
    theJobID == aJobID
  }

  override def print(aPrinter: Printer) =
  {
    aPrinter.printList(List(theJobID, theJobseeker), '\t'.toString())
  }
}
