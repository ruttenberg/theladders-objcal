package employer

import job.Job
import theLadders.{Printer, Printable, TheLaddersData}

/**
 * Created with IntelliJ IDEA.
 * User: jpr
 * Date: 10/17/13
 * Time: 10:07 AM
 * To change this template use File | Settings | File Templates.
 */
class Employer (val theEmployerID: EmployerID, val theEmployerInfo: EmployerInfo) extends Printable
{
  override def print(aPrinter: Printer) =
  {
    theEmployerInfo.print(aPrinter)
  }

  override def equals(other: Any) =
  {
    val that = other.asInstanceOf[Employer]
    if (that == null) false
    else
      that.theEmployerID == theEmployerID && that.theEmployerInfo == theEmployerInfo
  }
}
