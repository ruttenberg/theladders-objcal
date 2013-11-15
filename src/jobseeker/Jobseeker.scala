package jobseeker

import theLadders.{Printer, Printable}
import job.{Job, JobID}
import resume.ResumeID

class Jobseeker (val theJobseekerID: JobseekerID, val theJobseekerInfo: JobseekerInfo) extends Printable
{
  override def print(aPrinter: Printer) =
  {
//    aPrinter.printList(List(theJobseekerInfo, theJobseekerID), '\t'.toString())
    theJobseekerInfo.print(aPrinter)
  }

  def saveJob(aJob: Job) =
  {
    theJobseekerInfo.saveJob(aJob)
  }

  def printSavedJobs(aPrinter: Printer) =
  {
    theJobseekerInfo.printSavedJobs(aPrinter)
  }

  def noteJobApplication(jobThatHasBeenAppliedTo: Job) =
  {
    theJobseekerInfo.noteJobApplication(jobThatHasBeenAppliedTo)
  }

  def printJobsAppliedTo(aPrinter: Printer) =
  {
    theJobseekerInfo.printJobsAppliedTo(aPrinter)
  }

  def matches(aResumeID: ResumeID) =
  {
    aResumeID.matches(theJobseekerID)
  }

}
