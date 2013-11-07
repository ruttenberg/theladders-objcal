package job

import employer.EmployerID
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

  def jobsForEmployer(anEmployerID: EmployerID) =
  {
    val findJobByEmployer = predicate.jobByEmployerIDPredicate(anEmployerID)

    theJobs.filter(findJobByEmployer)
  }

  def findByJobID(aJobID: JobID) =
  {
    val findJobByJobID = predicate.jobByJobIDPredicate(aJobID)
    theJobs.filter(findJobByJobID).head
  }
}
