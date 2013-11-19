package employer

import org.scalatest.{Matchers, GivenWhenThen, FeatureSpec}
import theLadders.{TheLaddersData, ConsolePrinter, EmailAddress}
import job._

class TestEmployer extends FeatureSpec
with GivenWhenThen
with Matchers
{
  val expect = "FooCorp"
  val anEmployer = new Employer(new EmployerID(new EmailAddress("foucault@grenouille.fr")),
                                new EmployerInfo(new EmployerName(expect)))

  val anATSID = new JobID(anEmployer, new JobNumber(7), new JobTitle("Oscillator"))
  val fooATS = new ATS(anATSID)
  val aJReqID = new JobID(anEmployer, new JobNumber(7), new JobTitle("fooJReq"))
  val fooJReq = new JReq(aJReqID)

  feature("Employer")
  {
    scenario("print Employer")
    {
      Given("Employer with name of 'FooCorp'")
      When("Employer.print is called")
      val result = new java.io.ByteArrayOutputStream()
      Console.withOut(result)
      {
        anEmployer.print(new ConsolePrinter)
      }

      Then("the Employer prints as " + expect)
      result.toString should be(expect)
    }

    scenario("Post ATS")
    {
      Given("Employer with name of FooCorp and ATS with title of Oscillator")

      When("the ATS is posted to TheLadders")
      val theLaddersData = new TheLaddersData
      theLaddersData.postJob(fooATS)
      val result = new java.io.ByteArrayOutputStream()
      Console.withOut(result)
      {
        theLaddersData.printJobsForEmployer(new ConsolePrinter, anEmployer)
      }

      Then("there should be exactly one Job belonging to FooCorp")
      result.toString.lines.count((aString: String)=>true) should be(1)

      val expect = "Oscillator" + '\t'.toString + "FooCorp"
      Then("that Job should print as " + expect)
      result.toString should be(expect)
    }

    scenario("Post no job")
    {
      Given("Employer with name of FooCorp and ATS with title of Oscillator")

      When("no Job is posted to TheLadders")
      val theLaddersData = new TheLaddersData
      val result = new java.io.ByteArrayOutputStream()
      Console.withOut(result)
      {
        theLaddersData.printJobsForEmployer(new ConsolePrinter, anEmployer)
      }

      Then("there should be no Jobs belonging to FooCorp")
      result.toString.lines.count((aString: String)=>true) should be(0)
    }

    scenario("Print Jobs posted by Employer")
    {
      val theLaddersData = new TheLaddersData

      Given("Employer with name of FooCorp and ATS with title of Oscillator")

      When("the ATS is posted to TheLadders")
      theLaddersData.postJob(fooATS)

      When("the JReq is posted to TheLadders")
      theLaddersData.postJob(fooJReq)

      val result = new java.io.ByteArrayOutputStream()
      Console.withOut(result)
      {
        theLaddersData.printJobsForEmployer(new ConsolePrinter, anEmployer)
      }

      Then("there should be exactly two Jobs belonging to FooCorp")
      result.toString.lines.count((aString: String)=>true) should be(2)

      val expect =
        "fooJReq" + '\t'.toString + "FooCorp" + "\n" +
        "Oscillator" + '\t'.toString + "FooCorp"
      Then("those Jobs should print as \n" + expect)
      result.toString should be(expect)
    }
  }
}
