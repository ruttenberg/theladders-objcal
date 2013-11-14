package application

import job.JobID
import jobseeker.{Jobseeker, JobseekerID}
import employer.EmployerID
import theLadders.{Printer, Printable}

class ApplicationID (val theJobID: JobID, val theJobseeker: Jobseeker) extends Printable
{
  def isForThisEmployer(anEmployerID: EmployerID) =
  {
    theJobID.matchesEmployer(anEmployerID)
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
