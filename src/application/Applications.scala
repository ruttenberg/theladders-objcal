package application

import employer.Employer
import job.{Job, JobID}
import application.day.Day
import jobseeker.Jobseeker
import theLadders.Printer

class Applications
{
  var theApplications: List[Application] = List()

  def add(anApplication: Application)
  {
    theApplications = anApplication :: theApplications
  }

  def applicationsForJobsPostedBy(anEmployer: Employer) : List[Application] =
  {
    val findApplicationByEmployer = predicate.applicationByEmployerIDPredicate(anEmployer)

    theApplications.filter(findApplicationByEmployer)
  }

  def applicationsForJob(aJobID: JobID) : List[Application] =
  {
    val findApplicationsByJob = predicate.applicationByJobIDPredicate(aJobID)

    theApplications.filter(findApplicationsByJob)
  }

  def applicationsForEmployerAndDay(anEmployer: Employer, aDay: Day) : List[Application] =
  {
    val findApplicationByEmployer = predicate.applicationByEmployerIDPredicate(anEmployer)
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

  def printNumberOfSuccessfulApplicationsFor(aJob: Job, aPrinter: Printer) =
  {
    val successCount = applicationsForJob(aJob.theJobID).size
    aPrinter.printInt(successCount)
  }

  def printNumberOfSuccessfulApplicationsForJobsPostedBy(anEmployer: Employer, aPrinter: Printer) =
  {
    aPrinter.printInt(applicationsForJobsPostedBy(anEmployer).size)
  }
}
