package job

import org.scalatest.{BeforeAndAfterAll, Matchers, GivenWhenThen, FeatureSpec}
import employer.{EmployerName, EmployerInfo, EmployerID, Employer}
import theLadders.EmailAddress

class TestJob extends FeatureSpec
  with GivenWhenThen
  with Matchers
//  with BeforeAndAfterAll
{
  val anEmployer = new Employer(new EmployerID(new EmailAddress("foucault@grenouille.fr")), new EmployerInfo(new EmployerName("FooCorp")))

  feature("Job")
  {
    scenario("create ATS")
    {
      val aJobID = new JobID(anEmployer, new JobNumber(7), new JobTitle("fooJob"))
      val fooJob = new ATS(aJobID)
      Given("ATS created with JobTitle of fooJob")

      val expect = "fooJob"
      val jobName = fooJob.theJobID.theJobTitle.toString

      Then("the ATS's JobTitle is " + expect)
      jobName should be(expect)
    }
    scenario("create JReq")
    {
      val aJobID = new JobID(anEmployer, new JobNumber(7), new JobTitle("fooJReq"))
      val fooJob = new JReq(aJobID)
      Given("JReq created with JobTitle of fooJReq")

      val expect = "fooJReq"
      val jobName = fooJob.theJobID.theJobTitle.toString

      Then("the JReq's JobTitle is " + expect)
      jobName should be(expect)
    }
  }

/*
  override def beforeAll()
  {
  }
  */

}
