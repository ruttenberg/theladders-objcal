package theLadders

import employer.{Employer, Employers}
import job._
import application.Applications
import application.Application
import jobseeker.{Jobseeker, JobseekerID}
import resume.Resume
import application.day.Day

/**
 * Created with IntelliJ IDEA.
 * User: jpr
 * Date: 10/17/13
 * Time: 10:23 AM
 * To change this template use File | Settings | File Templates.
 */
class TheLaddersData
{
  val AllEmployers: Employers = new Employers
  val AllJobs: Jobs = new Jobs
  val AllApplications: Applications = new Applications

  def postJob(aJob: Job) =
  {
    AllJobs.add(aJob)
  }

  def printJobsForEmployer(aPrinter: Printer, anEmployer: Employer)
  {
    val jobsForThisEmployer : List[Job] = AllJobs.jobsPostedBy(anEmployer)
    aPrinter.printList(jobsForThisEmployer, "\n")
  }

  def printApplicationsForJob(aPrinter: Printer, aJobID: JobID) =
  {
    val applicationsForThisJob: List[Printable] = AllApplications.applicationsForJob(aJobID)
    aPrinter.printList(applicationsForThisJob, "\n")
  }

  def printApplicationsForEmployerAndDay(aPrinter: Printer, anEmployer: Employer,aDay: Day) =
  {
    val applicationsForEmployerAndDay: List[Printable] = AllApplications.applicationsForEmployerAndDay(anEmployer, aDay)
    aPrinter.printList(applicationsForEmployerAndDay, "\n")
  }

  def printApplicationsForJobAndDay(aPrinter: Printer, aJobID: JobID, aDay: Day) =
  {
    aPrinter.printList(AllApplications.applicationsForJobAndDay(aJobID, aDay), "\n")
  }

  def applyToATS(anATS: ATS, aJobseeker: Jobseeker)
  {
    val newApplication: Application = anATS.createApplication(aJobseeker)
    aJobseeker.noteJobApplication(anATS)
    addApplication(newApplication)
  }

  def applyToJReq(aJReq: JReq, aJobseeker: Jobseeker, aResume: Resume)
  {
    try
    {
      val newApplication = aJReq.createApplication(aJobseeker, aResume)
      aJobseeker.noteJobApplication(aJReq)
      addApplication(newApplication)
    }
    catch
    {
      case  _: Throwable => ;
    }
  }

  private def addApplication(anApplication: application.Application)
  {
    AllApplications.add(anApplication)
  }

  def applicationsForJobsPostedBy(anEmployer: Employer) =
  {
    AllApplications.applicationsForJobsPostedBy(anEmployer)
  }

  def applicationsByJobID(aJobID: JobID) =
  {
    AllApplications.applicationsForJob(aJobID: JobID)
  }

  def printJobseekersWhoHaveAppliedOn(someDay: Day, aPrinter: Printer) =
  {
    aPrinter.printList(AllApplications.jobseekersWhoHaveAppliedOn(someDay), "\n")
  }

  def printNumberOfFailedApplicationsFor(aJob: Job, aPrinter: Printer) =
  {
    aJob.printFailedApplicationCount(aPrinter: Printer)
  }
  
  def printNumberOfSuccessfulApplicationsFor(aJob: Job, aPrinter: Printer) =
  {
    AllApplications.printNumberOfSuccessfulApplicationsFor(aJob, aPrinter)
  }

  def printNumberOfFailedApplicationsForJobsPostedBy(anEmployer: Employer, aPrinter: Printer) =
  {
    AllJobs.printNumberOfFailedApplicationsForJobsPostedBy(anEmployer, aPrinter)
  }

  def printNumberOfSuccessfulApplicationsForJobsPostedBy(anEmployer: Employer, aPrinter: Printer) =
  {
    AllApplications.printNumberOfSuccessfulApplicationsForJobsPostedBy(anEmployer: Employer, aPrinter: Printer)
  }

  def printAllEmployers(aPrinter: Printer) =
  {
    AllEmployers.print(aPrinter)
  }
}
