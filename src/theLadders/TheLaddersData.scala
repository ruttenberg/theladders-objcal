package theLadders

import employer.{EmployerID, Employers}
import job._
import application.Applications
import application.Application
import jobseeker.{Jobseeker, JobseekerID}
import resume.Resume

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

  def printJobsForEmployer(aPrinter: Printer, anEmployerID: EmployerID)
  {
    val jobsForThisEmployer : List[Job] = AllJobs.jobsForEmployer(anEmployerID)
    aPrinter.printList(jobsForThisEmployer, "\n")
  }

  def applyToATS(aJobID: JobID, aJobseeker: Jobseeker)
  {
    val anATS: ATS = (AllJobs.findByJobID(aJobID)).asInstanceOf[ATS]
    val newApplication: Application = anATS.createApplication(aJobseeker)
    aJobseeker.noteJobApplication(anATS)
    AllApplications.add(newApplication)
  }

  def applyToJReq(aJobID: JobID, aJobseeker: Jobseeker, aResume: Resume)
  {
    val aJReq: JReq = (AllJobs.findByJobID(aJobID)).asInstanceOf[JReq]
    val newApplication: Application = aJReq.createApplication(aJobseeker, aResume)
    aJobseeker.noteJobApplication(aJReq)
    AllApplications.add(newApplication)
  }

  private def addApplication(anApplication: application.Application)
  {
    AllApplications.add(anApplication)
  }

  def applicationsByEmployerID(anEmployerID: EmployerID) =
  {
 //   val findThisEmployerID = applicationByEmployerIDPredicate
  }
}
