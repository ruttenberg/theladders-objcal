package application

import application.day.Day
import employer.EmployerID
import theLadders.{Printable, Printer}

trait Application extends Printable
{
  val theApplicationID: ApplicationID
  val theDay: Day

  def isForThisEmployer(anEmployerID: EmployerID) =
  {
    theApplicationID.isForThisEmployer(anEmployerID)
  }

  override def print(aPrinter: Printer) =
  {
    aPrinter.printList(List(theApplicationID, theDay), '\t'.toString())
  }
}
