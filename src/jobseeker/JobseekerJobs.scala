package jobseeker

import theLadders.{Printer, Printable}
import job.{Job, Jobs}

class JobseekerJobs () extends Printable
{
  val savedJobs: Jobs = new Jobs
  val appliedJobs: Jobs = new Jobs

  def print(aPrinter: Printer) = {}

  def saveJob(aJob: Job) =
  {
    savedJobs.add(aJob)
  }

  def printSavedJobs(aPrinter: Printer) =
  {
    savedJobs.print(aPrinter)
  }
}
