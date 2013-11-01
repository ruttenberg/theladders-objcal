package employer

import job.Job
import theLadders.TheLaddersData

/**
 * Created with IntelliJ IDEA.
 * User: jpr
 * Date: 10/17/13
 * Time: 10:07 AM
 * To change this template use File | Settings | File Templates.
 */
abstract class Employer {
  val theEmployerID: EmployerID
  val theEmployerInfo: EmployerInfo
}
