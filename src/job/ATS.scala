package job

import theLadders.Printer
import jobseeker.{Jobseeker, JobseekerID}
import application.{ATSApplication, Application, ApplicationID}
import resume.Resume
import application.day._

/**
 * Created with IntelliJ IDEA.
 * User: jpr
 * Date: 10/23/13
 * Time: 12:01 PM
 * To change this template use File | Settings | File Templates.
 */
class ATS (val theJobID: JobID) extends Job
{
  def createApplication(aJobseeker: Jobseeker) : Application =
  {
    val anApplicationID: ApplicationID = new ApplicationID(theJobID, aJobseeker)
    val today: Day = new Today
    new ATSApplication(anApplicationID, today)
  }
}
