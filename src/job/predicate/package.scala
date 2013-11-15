package job

import employer.{Employer}

/**
 * Created with IntelliJ IDEA.
 * User: jpr
 * Date: 10/29/13
 * Time: 6:33 PM
 * To change this template use File | Settings | File Templates.
 */
package object predicate
{
  def jobByEmployerIDPredicate(anEmployer: Employer) =
    (aJob: Job) => aJob.belongsTo(anEmployer)

  def jobByJobIDPredicate(aJobID: JobID) =
    (aJob: Job) => aJob.theJobID == aJobID
}
