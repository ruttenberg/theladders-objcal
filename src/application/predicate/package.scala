package application

import employer.Employer
import job.JobID
import application.day.Day

package object predicate
{
  def applicationByEmployerIDPredicate(anEmployerID: Employer) =
    (anApplication: Application) => anApplication.isForThisEmployer(anEmployerID)

  def applicationByJobIDPredicate(aJobID: JobID) =
  {
    (anApplication: Application) => anApplication.isForThisJob(aJobID)
  }

  def applicationByDayPredicate(thisDay: Day) =
  {
    (anApplication: Application) => anApplication.isForThisDay(thisDay)
  }
}
