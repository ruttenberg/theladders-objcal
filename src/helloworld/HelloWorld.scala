package helloworld

import theLadders.{TheLaddersData, EmailAddress, ConsolePrinter, PrintableString}
import employer.EmployerID
import job._
import jobseeker._
import application.day.Today
import application.Application

/**
 * Created with IntelliJ IDEA.
 * User: jpr
 * Date: 10/16/13
 * Time: 3:40 PM
 * To change this template use File | Settings | File Templates.
 */
object HelloWorld extends App {
  val foo: String = "my string"

  override def  main(args: Array[String]) {

//    println("Hello, World")

    val pr = new ConsolePrinter

    /*
    val p = new PrintableString("bar")
    val foo = new PrintableString("foo")
    val lol = new PrintableString("lol")
    */

/*
    p.print(pr)
    println()


    pr.printList(List())
    println()

    pr.printList(List(p))
    println(); println()
*/
//    pr.printList(List(p, foo, lol))
//    pr.printList(List(p, foo), '\t'.toString())
//    println(); println()



    val employerID: EmployerID = new EmployerID(new EmailAddress("tj@watson.com"))
    val employerID2: EmployerID = new EmployerID(new EmailAddress("jobs@google.com"))
    val employerID3: EmployerID = new EmployerID(new EmailAddress("slaves@bloomberg.com"))

//    println(employerID.equals(employerID2))

    val theLaddersData: TheLaddersData = new TheLaddersData()

    val jobNumber: JobNumber = new JobNumber(99)
    val jobTitle: JobTitle = new JobTitle("Lord and Master")
    val jobID: JobID = new JobID(employerID, jobNumber, jobTitle)
    val job: Job = new ATS(jobID)
    theLaddersData.postJob(job)

    val jobNumber2: JobNumber = new JobNumber(5)
    val jobTitle2: JobTitle = new JobTitle("VP of Mendacity")
    val jobID2: JobID = new JobID(employerID2, jobNumber2, jobTitle2)
    val job2: Job = new ATS(jobID2)
    theLaddersData.postJob(job2)

    // same employer as first job
    val jobNumber3: JobNumber = new JobNumber(37)
    val jobTitle3: JobTitle = new JobTitle("VP of Mendacity")
    val jobID3: JobID = new JobID(employerID, jobNumber3, jobTitle3)
    val job3: Job = new ATS(jobID3)
    theLaddersData.postJob(job3)

//    jobID.print(pr)
    /*
    println("print one job")
    job.print(pr)
    println(); println()
    */


    println("print all jobs for: " + employerID.toString())
    theLaddersData.printJobsForEmployer(pr, employerID)
    println(); println()
/*
    val someJobs = new Jobs()
    someJobs.add(job3)
    println("print someJobs")
    someJobs.print(pr)
    println(); println()

    val seekerJobs = new JobseekerJobs()
    seekerJobs.saveJob(job3)
    println("print savedJobs from JobseekerJobs")
    seekerJobs.printSavedJobs(pr)
    println(); println()

    val testInfo = new JobseekerInfo(new PersonalInfo("test JobseekerInfo"))
    testInfo.saveJob(job3)
    println("print savedJobs from JobseekerInfo")
    testInfo.printSavedJobs(pr)
    println(); println()
*/
    // create Jobseeker and have Jobseeker save a Job
    val seekerID = new JobseekerID(new EmailAddress("dc@troll.org"))
    val seekerPersonalInfo = new PersonalInfo("Dick Cheney")
    val seekerInfo = new JobseekerInfo(seekerPersonalInfo)
    val seeker = new Jobseeker(seekerID, seekerInfo)
    seeker.saveJob(job3)

    println("print saved jobs for: " + seekerID.toString())
    seeker.printSavedJobs(pr)
    println(); println()

    val localJobs = new Jobs
    localJobs.add(job)
    localJobs.add(job2)
    localJobs.add(job3)
    print("find Job for JobID: "); jobID2.print(pr); println()
    localJobs.findByJobID(jobID2).print(pr)
    println(); println()

    println("Today: " + new Today)
    println(); println()

    val d1 = new Today
    val d2 = new Today
    println("d1 == d2: " + (d1 == d2))
    println(); println()

    print("Jobseeker '" + seekerID + "' is applying to Job '");  jobID3.print(pr); println("'")
    theLaddersData.applyToATS(jobID3, seeker)
    println(); println()

    print("Jobseeker '" + seekerID + "'");  println("' has applied to these Jobs:")
    seeker.printJobsAppliedTo(pr)
    println(); println()

    val ATS2: ATS = job2.asInstanceOf[ATS]
    val freeApp: Application = ATS2.createApplication(seeker)

    print("Application by '"); seeker.print(pr); print("' to Job '"); ATS2.print(pr); println("'");
    freeApp.print(pr); println
  }
}
