package jobseeker

import theLadders.{Printer, Printable}
import job.{Job}

class JobseekerInfo (thePersonalInfo: PersonalInfo) extends Printable
{
  val theJobseekerJobs = new JobseekerJobs

  def print(aPrinter: Printer) = {}

  def saveJob(aJob: Job) =
  {
    theJobseekerJobs.saveJob(aJob)
  }

  def printSavedJobs(aPrinter: Printer) =
  {
    theJobseekerJobs.printSavedJobs(aPrinter)
  }
}
