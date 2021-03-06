package job

import employer.Employer
import theLadders.{Printer, Printable}

/**
 * Created with IntelliJ IDEA.
 * User: jpr
 * Date: 10/17/13
 * Time: 11:30 AM
 * To change this template use File | Settings | File Templates.
 */
class Jobs extends Printable
{
  var theJobs: List[Job] = List()

  override def print(aPrinter: Printer) =
  {
    aPrinter.printList(theJobs, "\n")
  }

  def add(aJob: Job)
  {
    theJobs = aJob :: theJobs
  }

  def jobsPostedBy(anEmployerID: Employer) =
  {
    val findJobByEmployer = predicate.jobByEmployerIDPredicate(anEmployerID)

    theJobs.filter(findJobByEmployer)
  }

  def findByJobID(aJobID: JobID) =
  {
    val findJobByJobID = predicate.jobByJobIDPredicate(aJobID)
    theJobs.filter(findJobByJobID).head
  }

  def printNumberOfFailedApplicationsForJobsPostedBy(anEmployerID: Employer, aPrinter: Printer) =
  {
    val jobs: List[Job] = jobsPostedBy(anEmployerID)

    def jobToFailureCount(aJob: Job) =
    {
      aJob.failedApplicationCount
    }

    aPrinter.printInt(jobs.map(jobToFailureCount).sum)
  }

}
