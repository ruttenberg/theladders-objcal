package application

import employer.EmployerID
import job.JobID
import application.day.Day
import jobseeker.Jobseeker

class Applications
{
  var theApplications: List[Application] = List()

  def add(anApplication: Application)
  {
    theApplications = anApplication :: theApplications
  }

  def applicationsForEmployer(anEmployerID: EmployerID) : List[Application] =
  {
    val findApplicationByEmployer = predicate.applicationByEmployerIDPredicate(anEmployerID)

    theApplications.filter(findApplicationByEmployer)
  }

  def applicationsForJob(aJobID: JobID) : List[Application] =
  {
    val findApplicationsByJob = predicate.applicationByJobIDPredicate(aJobID)

    theApplications.filter(findApplicationsByJob)
  }

  def applicationsForEmployerAndDay(anEmployerID: EmployerID, aDay: Day) : List[Application] =
  {
    val findApplicationByEmployer = predicate.applicationByEmployerIDPredicate(anEmployerID)
    val findApplicationsByDay = predicate.applicationByDayPredicate(aDay)

    theApplications.filter(findApplicationsByDay).filter(findApplicationByEmployer)
  }

  def applicationsForJobAndDay(aJobID: JobID, aDay: Day) : List[Application] =
  {
    val findApplicationsByJob = predicate.applicationByJobIDPredicate(aJobID)
    val findApplicationsByDay = predicate.applicationByDayPredicate(aDay)

    theApplications.filter(findApplicationsByJob).filter(findApplicationsByDay)
  }

  def toJobseeker(anApplication: Application) =
  {
    anApplication.toJobseeker()
  }

  private def jobseekersWhoHaveMadeThese(someApplications: List[Application]) =
  {
    someApplications.map(toJobseeker).toSet.toList
  }

  def jobseekersWhoHaveAppliedOn(someDay: Day) : List[Jobseeker] =
  {
    val applicationsForSomeDay: List[Application] = applicationsForDay(someDay)
    jobseekersWhoHaveMadeThese(applicationsForSomeDay)
  }

  def jobseekersWhoHaveAppliedTo(aJobID: JobID) =
  {
    jobseekersWhoHaveMadeThese(applicationsForJob(aJobID))
  }

  def applicationsForDay(aDay: Day) : List[Application] =
  {
    val findApplicationsByDay = predicate.applicationByDayPredicate(aDay)
    theApplications.filter(findApplicationsByDay)
  }
}
