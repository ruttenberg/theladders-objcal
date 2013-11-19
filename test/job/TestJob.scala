package job

import org.scalatest.{Matchers, GivenWhenThen, FeatureSpec}
import employer.{EmployerName, EmployerInfo, EmployerID, Employer}
import theLadders.{ConsolePrinter, EmailAddress}

class TestJob extends FeatureSpec
  with GivenWhenThen
  with Matchers
//  with BeforeAndAfterAll
{
  val anEmployer = new Employer(new EmployerID(new EmailAddress("foucault@grenouille.fr")), new EmployerInfo(new EmployerName("FooCorp")))

  feature("Job")
  {
    val anATSID = new JobID(anEmployer, new JobNumber(7), new JobTitle("fooATS"))
    val fooATS = new ATS(anATSID)

    scenario("create ATS")
    {
      Given("ATS created with JobTitle of fooATS")

      val expect = "fooATS"
      val jobName = fooATS.theJobID.theJobTitle.toString

      Then("the ATS's JobTitle is " + expect)
      jobName should be(expect)
    }

    val aJReqID = new JobID(anEmployer, new JobNumber(7), new JobTitle("fooJReq"))
    val fooJReq = new JReq(aJReqID)
    scenario("create JReq")
    {
      Given("JReq created with JobTitle of fooJReq")

      val expect = "fooJReq"
      val jobName = fooJReq.theJobID.theJobTitle.toString

      Then("the JReq's JobTitle is " + expect)
      jobName should be(expect)
    }

    scenario("print ATS")
    {
      Given("ATS created with JobTitle of fooATS and EmployerName of FooCorp")

      When("ATS.print is called")
      val result = new java.io.ByteArrayOutputStream()
      Console.withOut(result)
      {
        fooATS.print(new ConsolePrinter)
      }

      val expect = "fooATS" + '\t'.toString + "FooCorp"
      Then("the Job prints as " + expect)
      result.toString should be(expect)
    }

    scenario("print JReq")
    {
      Given("JReq created with JobTitle of fooJReq and EmployerName of FooCorp")

      When("JReq.print is called")
      val result = new java.io.ByteArrayOutputStream()
      Console.withOut(result)
      {
        fooJReq.print(new ConsolePrinter)
      }

      val expect = "fooJReq" + '\t'.toString + "FooCorp"
      Then("the Job prints as " + expect)
      result.toString should be(expect)
    }
  }
}
