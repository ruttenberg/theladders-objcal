package theLadders

import employer.{EmployerID, Employers}
import job.{predicate, Jobs, Job}

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

  def postJob(aJob: Job) =
  {
    AllJobs.add(aJob)
  }

  def printJobsForEmployer(aPrinter: Printer, anEmployerID: EmployerID)
  {
    val jobsForThisEmployer : List[Job] = AllJobs.jobsForEmployer(anEmployerID)
    aPrinter.printList(jobsForThisEmployer, "\n")
  }
}
