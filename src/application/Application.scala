package application

import application.day.Day
import employer.EmployerID
import theLadders.{Printable, Printer}
import job.JobID

trait Application extends Printable
{
  val theApplicationID: ApplicationID
  val theDay: Day

  def isForThisEmployer(anEmployerID: EmployerID) =
  {
    theApplicationID.isForThisEmployer(anEmployerID)
  }

  def isForThisJob(aJobID: JobID) =
  {
    theApplicationID.isForThisJob(aJobID)
  }

  def isForThisDay(aDay: Day) =
  {
    aDay == theDay
  }

  override def print(aPrinter: Printer) =
  {
    aPrinter.printList(List(theApplicationID, theDay), '\t'.toString())
  }

  def toJobseeker() =
  {
    theApplicationID.theJobseeker
  }
}
