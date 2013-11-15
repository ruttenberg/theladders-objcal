package job

import employer.Employer
import theLadders.{Printable, Printer}

/**
 * Created with IntelliJ IDEA.
 * User: jpr
 * Date: 10/17/13
 * Time: 11:04 AM
 * To change this template use File | Settings | File Templates.
 */
class JobID ( val theEmployer: Employer, val theJobNumber: JobNumber, val theJobTitle: JobTitle ) extends Printable
{
  override def print(aPrinter: Printer) =
  {
    val printList: List[Printable] =  List(theEmployer, theJobTitle, theJobNumber)
    aPrinter.printList(printList, '\t'.toString)
  }

  def printTitleAndEmployerName(aPrinter: Printer) =
  {
    aPrinter.printList(List(theJobTitle, theEmployer), '\t'.toString)
  }

  def matches(anEmployer: Employer) =
  {
    anEmployer == theEmployer
  }

  override def equals(other: Any) =
  {
    val that = other.asInstanceOf[JobID]
    if (that == null) false
    else
      that.theEmployer == theEmployer && that.theJobNumber == theJobNumber && that.theJobTitle == theJobTitle
  }
}
