package job

import employer.{EmployerID, Employer}

/**
 * Created with IntelliJ IDEA.
 * User: jpr
 * Date: 10/29/13
 * Time: 6:33 PM
 * To change this template use File | Settings | File Templates.
 */
package object predicate
{
  def jobByEmployerIDPredicate(anEmployerID: EmployerID) =
    (aJob: Job) => aJob.belongsToEmployer(anEmployerID)
}
