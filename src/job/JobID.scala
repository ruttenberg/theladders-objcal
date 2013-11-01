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
  def print(aPrinter: Printer) =
  {
    val printList: List[Printable] =  List(theEmployerID, theJobTitle, theJobNumber)
    aPrinter.printList(printList, '\t'.toString())
  }

  def matchesEmployer(anEmployerID: EmployerID) =
  {
    anEmployerID == theEmployerID
  }
}
