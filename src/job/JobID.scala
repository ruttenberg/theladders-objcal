package job

import employer.EmployerID
import theLadders.{Printable, Printer}

/**
 * Created with IntelliJ IDEA.
 * User: jpr
 * Date: 10/17/13
 * Time: 11:04 AM
 * To change this template use File | Settings | File Templates.
 */
class JobID ( val theEmployerID: EmployerID, val theJobNumber: JobNumber, val theJobTitle: JobTitle ) extends Printable
{
  override def print(aPrinter: Printer) =
  {
    val printList: List[Printable] =  List(theEmployerID, theJobTitle, theJobNumber)
    aPrinter.printList(printList, '\t'.toString())
  }

  def matchesEmployer(anEmployerID: EmployerID) =
  {
    anEmployerID == theEmployerID
  }

  override def equals(other: Any) =
  {
    val that = other.asInstanceOf[JobID]
    if (that == null) false
    else
      that.theEmployerID == theEmployerID && that.theJobNumber == theJobNumber && that.theJobTitle == theJobTitle
  }
}
