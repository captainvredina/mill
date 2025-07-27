import mill.eval._

object EvaluatorExample extends App {
  // Create an evaluator that works in the current build
  val evaluator = new Evaluator()

  // Resolve segments for the task foo.compile
  val segments = evaluator.resolveSegments(Seq("foo.compile"))
  println(s"Resolved segments: ${segments}")

  // Plan the build
  val plan = evaluator.plan(segments)
  println(s"Planned tasks: ${plan.targets.map(_.task).mkString(", ")}")

  // Execute the planned tasks
  val executed = evaluator.execute(plan)
  println(s"Executed ok: ${executed.ok}")

  // Evaluate the results
  val results = evaluator.evaluate(plan.targets).results
  println(s"Results: ${results}")
}
