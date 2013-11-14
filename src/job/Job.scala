package job

import theLadders.{Printer, Printable}
import employer.EmployerID
import jobseeker.JobseekerID
import resume.Resume

/**
 * Created with IntelliJ IDEA.
 * User: jpr
 * Date: 10/17/13
 * Time: 10:57 AM
 * To change this template use File | Settings | File Templates.
 */
trait Job extends Printable
{
  val theJobID: JobID
  var failedApplicationCount: Int = 0

//  def Job(aJobID: JobID)

  override def print(thePrinter: Printer) =
  {
    theJobID.print(thePrinter)
  }

  def belongsTo(anEmployerID: EmployerID) =
  {
    theJobID.matches(anEmployerID)
  }

  def printFailedApplicationCount(aPrinter: Printer) =
  {
    aPrinter.printInt(failedApplicationCount)
  }

}
