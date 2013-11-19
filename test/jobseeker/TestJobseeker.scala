package jobseeker

import org.scalatest.{Matchers, GivenWhenThen, FeatureSpec}
import theLadders.{TheLaddersData, ConsolePrinter, EmailAddress}
import job._
import employer.{EmployerName, EmployerInfo, EmployerID, Employer}
import resume.{ResumeContent, ResumeName, ResumeID, Resume}

class TestJobseeker extends FeatureSpec
with GivenWhenThen
with Matchers
{
  feature("Jobseeker")
  {
    val seekerID = new JobseekerID(new EmailAddress("dc@troll.org"))

    val anEmployer = new Employer(new EmployerID(new EmailAddress("foucault@grenouille.fr")),
                                  new EmployerInfo(new EmployerName("FooCorp")))



    val DCResume = new Resume(new ResumeID(new ResumeName("Varnished Truth"), seekerID), new ResumeContent("Disarmed Iraq"))

    scenario("Jobseeker saves Job")
    {
      val seekerPersonalInfo = new PersonalInfo("Dick Cheney")
      val seekerInfo = new JobseekerInfo(seekerPersonalInfo)
      val seeker = new Jobseeker(seekerID, seekerInfo)

      val anATSID = new JobID(anEmployer, new JobNumber(7), new JobTitle("Oscillator"))
      val fooATS = new ATS(anATSID)

      Given("Jobseeker Dick Cheney and Job Oscillator at FooCorp")
      When("Jobseeker saves Job")
      seeker.saveJob(fooATS)

      val expect = "Oscillator" + '\t'.toString + "FooCorp"
      Then("printing the Jobseeker's Jobs shows " + expect)

      val result = new java.io.ByteArrayOutputStream()
      Console.withOut(result)
      {
        seeker.printSavedJobs(new ConsolePrinter)
      }

      result.toString should be(expect)
    }

    scenario("Jobseeker applies to ATS")
    {
      val seekerPersonalInfo = new PersonalInfo("Dick Cheney")
      val seekerInfo = new JobseekerInfo(seekerPersonalInfo)
      val seeker = new Jobseeker(seekerID, seekerInfo)
      val anATSID = new JobID(anEmployer, new JobNumber(7), new JobTitle("Oscillator"))
      val fooATS = new ATS(anATSID)

      Given("Jobseeker Dick Cheney and Job Oscillator at FooCorp")

      When("Jobseeker applies to ATS")
      val theLaddersData = new TheLaddersData
      theLaddersData.applyToATS(fooATS, seeker)

      val expect = "Oscillator" + '\t'.toString + "FooCorp"
      Then("printing the Jobseeker's Jobs shows " + expect)

      val result = new java.io.ByteArrayOutputStream()
      Console.withOut(result)
      {
        seeker.printJobsAppliedTo(new ConsolePrinter)
      }

      result.toString should be(expect)
    }

    scenario("Jobseeker applies to JReq")
    {
      val seekerPersonalInfo = new PersonalInfo("Dick Cheney")
      val seekerInfo = new JobseekerInfo(seekerPersonalInfo)
      val seeker = new Jobseeker(seekerID, seekerInfo)
      val aJReqID = new JobID(anEmployer, new JobNumber(7), new JobTitle("fooJReq"))
      val fooJReq = new JReq(aJReqID)

      Given("Jobseeker Dick Cheney and JReq fooJReq at FooCorp")

      When("Jobseeker applies to JReq")
      val theLaddersData = new TheLaddersData
      theLaddersData.applyToJReq(fooJReq, seeker, DCResume)

      val expect = "fooJReq" + '\t'.toString + "FooCorp"
      Then("printing the Jobseeker's Jobs shows\n" + expect)

      val result = new java.io.ByteArrayOutputStream()
      Console.withOut(result)
      {
        seeker.printJobsAppliedTo(new ConsolePrinter)
      }

      result.toString should be(expect)
    }

    ignore("Jobseeker attempts to apply using someone else's Resume")
    {

    }

    ignore("Jobseeker applies to two Jobs, each using a different Resume")
    {

    }

    ignore("Jobseeker prints a list of Jobs that the Jobseeker applied to")
    {

    }
  }
}
