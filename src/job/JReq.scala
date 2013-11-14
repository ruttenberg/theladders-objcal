package job

import jobseeker.{Jobseeker, JobseekerID}
import application.{JReqApplication, ApplicationID, Application}
import application.day._
import resume.Resume

/**
 * Created with IntelliJ IDEA.
 * User: jpr
 * Date: 10/23/13
 * Time: 12:00 PM
 * To change this template use File | Settings | File Templates.
 */
class JReq (val theJobID: JobID) extends Job
{
  def createApplication(aJobseeker: Jobseeker, aResume: Resume) : Application =
  {
    if (!aResume.matches(aJobseeker))
      failedApplicationCount = failedApplicationCount + 1; throw new Exception("Resume does not belong to Jobseeker")

    val anApplicationID: ApplicationID = new ApplicationID(theJobID, aJobseeker)
    val today: Day = new Today
    new JReqApplication(anApplicationID, today, aResume)
  }
}
