package jobseeker

import theLadders.{Printer, Printable}
import job.{Job, JobID}

class Jobseeker (val theJobseekerID: JobseekerID, val theJobseekerInfo: JobseekerInfo) extends Printable
{
  def print(aPrinter: Printer) =
  {
    theJobseekerID.print(aPrinter)
  }

  def saveJob(aJob: Job) =
  {
    theJobseekerInfo.saveJob(aJob)
  }

  def printSavedJobs(aPrinter: Printer) =
  {
    theJobseekerInfo.printSavedJobs(aPrinter)
  }
}
