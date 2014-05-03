// import org.stairwaybook.expr._
// 
// object Express extends Application {
//   val f = new ExprFormatter
// 
//   val e1 = BinOp("*", BinOp("/", Number(1), Number(2)),
//                       BinOp("+", Var("x"), Number(1)))
//   val e2 = BinOp("+", BinOp("/", Var("x"), Number(2)),
//                       BinOp("/", Number(1.5), Var("x")))
//   val e3 = BinOp("/", e1, e2)
// 
//   def show(e: org.stairwaybook.expr.Expr) = println(f.format(e) + "\n\n")
// 
//   for(val e <- Array(e1, e2, e3)) show(e)
// 
// 
// }
// 
import org.stairwaybook.layout.Element
import Element.elem


import org.stairwaybook.expr._

object Express extends Application {

  val f = new ExprFormatter

  val e1 = BinOp("*", BinOp("/", Number(1), Number(2)), 
                      BinOp("+", Var("x"), Number(1)))
  val e2 = BinOp("+", BinOp("/", Var("x"), Number(2)), 
                      BinOp("/", Number(1.5), Var("x")))
  val e3 = BinOp("/", e1, e2)

  def show(e: Expr) = println(f.format(e)+ "\n\n")

  for (e <- Array(e1, e2, e3)) show(e)
}
