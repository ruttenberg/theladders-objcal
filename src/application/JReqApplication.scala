package application

import resume.Resume
import application.day.Day

class JReqApplication(val theApplicationID: ApplicationID, val theDay: Day, val theResume: Resume) extends Application
{
}