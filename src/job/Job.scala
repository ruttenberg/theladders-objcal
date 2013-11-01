package job

import theLadders.{Printer, Printable}
import employer.EmployerID

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
  val failedApplicationCount: Int = 0

//  def Job(aJobID: JobID)

  def print(thePrinter: Printer) =
  {
    theJobID.print(thePrinter)
  }

  def belongsToEmployer(anEmployerID: EmployerID) =
  {
    theJobID.matchesEmployer(anEmployerID)
  }
}
